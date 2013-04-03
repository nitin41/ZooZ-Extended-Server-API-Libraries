<?php
	
	include_once 'lib/nvps.php';
	include_once 'lib/zooz.exception.php';
	include_once 'lib/address.php';
	include_once 'lib/invoice.php';
	include_once 'lib/user.details.php';

	class ZooZLibrary {
		
		private $ch;
		
		public $userDetails;
		public $billingAddress;
		public $shippingAddress;
		public $invoice;
		
		const SANDBOX_URL = "https://sandbox.zooz.co";
		const PRODUCTION_URL = "https://app.zooz.com";
		
		/**
		 * ZooZLibrary constructor
		 * 
		 * @param string $zoozUniqueId - App Unique ID, as registered in the ZooZ developer portal.
		 * @param string $zoozAppKey - App key as received upon registration - can be found on the top section of the app details. 
		 * @param boolean $isSandbox - TRUE to use sandbox environment, FALSE to use live environment.
		 * @throws ZooZException
		 */
		function __construct($zoozUniqueId, $zoozAppKey, $isSandbox) {
			
			if (!function_exists('curl_init')){
				throw new ZooZException('Sorry cURL is not installed!');
			}
			
			if (empty($zoozUniqueId)) {
				throw new ZooZException("Please enter ZooZ unique ID as registered in ZooZ's developer portal");
			}
			
			if (empty($zoozAppKey)) {
				throw new ZooZException("Please enter ZooZ App Key as diaplayed in ZooZ's developer portal under app details");
			}
			
			$zoozServer;
			
			if ($isSandbox) {
				$zoozServer = self::SANDBOX_URL;
				curl_setopt($this->ch, CURLOPT_SSL_VERIFYPEER, 0);
			} else {
				$zoozServer = self::PRODUCTION_URL;
			}
			
			$zoozServer .= "/mobile/SecuredWebServlet";
			
			$this->ch = curl_init();
			
			curl_setopt($this->ch, CURLOPT_HTTPHEADER, array(
					'ZooZUniqueID: ' . $zoozUniqueId,
					'ZooZAppKey: ' . urlencode($zoozAppKey),
					'ZooZResponseType: NVP'
			) );
				
			curl_setopt($this->ch, CURLOPT_URL, $zoozServer);
			curl_setopt($this->ch, CURLOPT_TIMEOUT, 30 );
			curl_setopt($this->ch, CURLOPT_RETURNTRANSFER, true);
			curl_setopt($this->ch, CURLOPT_POST, true);
			
		}
		
		/**
		 * Open transaction on a secured channel to ZooZ server. This call returns a token that will be used to uniquely identify the transaction.
		 * 
		 * @param double $amount - The amount to pay (including tax).
		 * @param double $taxAmount - (Optional) Tax amount for the payment.
		 * @param string $currencyCode - ISO-4217 3-letter currency code.
		 * @throws ZooZException
		 * @return string sessionToken - to be used with the JavaScript call zoozStartCheckout()
		 */
		function openTrx($amount, $taxAmount, $currencyCode) {
			
			if ($amount <= 0) {
				throw new ZooZException("Amount has to be a positive value");
			}
			if (empty($currencyCode)) {
				throw new ZooZException("Currency code is empty");
			}
			
			$nvps = new NVPs();
			$nvps->add("cmd", "openTrx");
			
			$nvps->add("amount", $amount);
			$nvps->add("currencyCode", $currencyCode);
			
			if ($taxAmount != 0) {
				$nvps->add("taxAmount", $taxAmount);
			}
			
			if (!empty($this->userDetails)) {
				$nvps->addAll($this->userDetails->toNVPs());
			}
			
			if (!empty($this->billingAddress)) {
				$nvps->addAll($this->billingAddress->toNVPs());
			}
			
			if (!empty($this->shippingAddress)) {
				$nvps->addAll($this->shippingAddress->toNVPs());
			}
			
			if (!empty($this->invoice)) {
				$nvps->addAll($this->invoice->toNVPs());
			}
			
			$openTrxResponse = Array();
			
			$req = $nvps->toString();
			
			error_log($req);
			
			$res = $this->postToZooZ($req);
			
			error_log($res);
				
			parse_str($res, $openTrxResponse);
			
			$log = '';
			
			foreach ($openTrxResponse as $key => $value) {
				$log .= '$openTrxResponse[' . $key . ']=' . $value;
			}
			
			error_log($log);
				
			$statusCode = $openTrxResponse["statusCode"];
			
			if ($statusCode != 0) {
				$errorMessage = $openTrxResponse["errorMessage"];
				if (empty($errorMessage)) {
					$errorMessage = "Some general error has occured, please try again";
				}
				throw new ZooZException($errorMessage, $statusCode);
			}
			
			return rtrim($openTrxResponse["sessionToken"], "\n");
			
			
		}
		
		/**
		 * Verify the transaction to make sure transaction indeed succeeded. 
		 * 
		 * @param string $transactionId - Transaction ID as returned by ZooZ to the returnUrl upon transaction completion.
		 * @throws ZooZException
		 * @return boolean - true if transaction was successfully verified.
		 */
		function verifyTrx($transactionId) {
			
			if (empty($transactionId)) {
				throw new ZooZException("transactionId cannot be empty");
			}
			
			$nvps = new NVPs();
			
			$nvps->add("cmd", "verifyTrx");
			
			$nvps->add("trxId", $transactionId);
			
			$verifyTrxResponse = Array();
			
			parse_str($this->postToZooZ($nvps->toString(), $verifyTrxResponse));
			
			if ($statusCode != 0) {
				$errorMessage = $openTrxResponse["errorMessage"];
				if (empty($errorMessage)) {
					$errorMessage = "Some general error has occured, please try again";
				}
				throw new ZooZException($errorMessage, $statusCode);
			}
			
			return true;
			
		}
		
		
		private function postToZooZ($data) {
			
			curl_setopt($this->ch, CURLOPT_POSTFIELDS, $data);
			
			try {
				$chResult = curl_exec($this->ch);
				return $chResult;
			} catch (Exception $e) {
				throw $e;	
			}
			
		}
		
		/**
		 * ZooZLibrary destructor
		 */
		function __destruct() {
			curl_close($this->ch);
		}
	}
?>
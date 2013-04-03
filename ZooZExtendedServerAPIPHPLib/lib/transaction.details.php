<?php

include_once 'lib/address.php';
include_once 'lib/invoice.php';
include_once 'lib/user.details.php';

class TransactionDetails {

	public $appName;
	public $transactionID;
	public $isSandbox;
	public $transactionStatus;
	public $fundSourceType;
	public $lastFourDigits;
	public $amount;
	public $paidAmount;
	public $currencyCode;
	public $transactionFee;
	public $transactionTimestamp;
	public $user;
	public $invoice;
	public $billingAddress;
	public $shippingAddress;

	function __construct($jsonObj) {
		
		$this->amount = $jsonObj[amount];
		$this->appName = utf8_decode($jsonObj[appName]);
		if (!empty($jsonObj[addresses])) {
			if (!empty($jsonObj[addresses][billing])) {
				$this->billingAddress = new Address(AddressType::billingAddress, $jsonObj[addresses][billing]);
			}
			if (!empty($jsonObj[addresses][shipping])) {
				$this->shippingAddress = new Address(AddressType::shippingAddress, $jsonObj[addresses][shipping]);
			}
			
		}
		$this->currencyCode = $jsonObj[currencyCode];
		$this->fundSourceType = $jsonObj[fundSourceType];
		if (!empty($jsonObj[invoice])) {
			$this->invoice = new Invoice($jsonObj[invoice]);
		}
		$this->isSandbox = $jsonObj[isSandbox];
		$this->lastFourDigits = $jsonObj[lastFourDigits];
		$this->paidAmount = $jsonObj[paidAmount];
		$this->transactionFee = $jsonObj[transactionFee];
		$this->transactionID = $jsonObj[transactionID];
		$this->transactionStatus = $jsonObj[transactionStatus];
		$this->transactionTimestamp = $jsonObj[transactionTimestamp];
		if (!empty($jsonObj[user])) {
			$this->user = new UserDetails($jsonObj[user]);
		}
	}

}
?>

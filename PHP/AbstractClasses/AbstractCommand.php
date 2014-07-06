<?php
/**
 * Description of AbsreactClasses
 *
 * @author Roy Keynan
 */
#include_once 'lib/nvps.php';

require_once 'lib/nvps.php';
require_once './ZooZExtendedServerAPI.php';

abstract class AbstractCommand {

    const VERSION_NUMBER = "1.1.3";
    private $ch;
    
    protected $nvps;
    function __construct() {
        $this->nvps = new NVPs();
        $this->nvps->add("cmd", $this->getCommand());
	$this->nvps->add("ver", self::VERSION_NUMBER);
    }
        
    abstract protected function getCommand();
    
    function response(){
        $this->ch = curl_init();
        curl_setopt($this->ch, CURLOPT_HTTPHEADER, array(
            'ZooZDeveloperId: ' . ZooZExtendedServerAPI::$developerId,
            'ZooZServerAPIKey: ' . urlencode((string)ZooZExtendedServerAPI::$apiKey),
            ) );
              
        
        curl_setopt($this->ch, CURLOPT_SSL_VERIFYPEER, 0); 
        curl_setopt($this->ch, CURLOPT_URL, ZooZExtendedServerAPI::$zoozServer);
	curl_setopt($this->ch, CURLOPT_TIMEOUT, 30 );
	curl_setopt($this->ch, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($this->ch, CURLOPT_POST, true);
        
        return $this->postToZooZ($this->nvps->toString());
        //return $responseObj;
        
    }
    
    private function postToZooZ($data) {
				
    curl_setopt($this->ch, CURLOPT_POSTFIELDS, $data);
    $chResult = curl_exec($this->ch);
    $chResult_trim = trim($chResult, "\n");
//    $errorMsg = "Error communicating with ZooZ server, please check your network connection";
//    $errorCode = -1;
//    if (empty($chResult)) {
//        throw new ZooZException($errorMsg);
//    }
			
//    $decoded = json_decode(trim($chResult_trim), TRUE); 
    
    //return $decoded['ResponseObject'];

    return trim($chResult_trim);
    
//    if ($decoded['ResponseStatus'] != 0) {
//        if (!empty($decoded[ResponseObject]) && !empty($decoded['ResponseObject']['errorMessage'])) {
//            $errorMsg = $decoded[ResponseObject][errorMessage];
//            $errorCode = $decoded['ResponseStatus'];
//           }
//				throw new ZooZException($errorMsg, $errorCode);
//			}
//			
//			return $decoded['ResponseObject'];
//				
//		}
    }
    
    function getNvps(){
        return $this->nvps->toString();
    }

//class Child extends AbsreactCommand {
//    function __construct($transactionID) {
//        parent::__construct();
//        $this->nvps->add("transactionID", $transactionID);
//        
//    }
//    
//    function dump()
//    {
//        print $this->nvps->toString();
//    }
//
//    protected function getCommand() {
//        return "getTransaction";
//    }
//
//
}
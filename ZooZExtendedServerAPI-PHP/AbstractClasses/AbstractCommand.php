<?php
/**
 * Description of AbsreactClasses
 *
 * @author Roy Keynan
 */

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
              
        curl_setopt($this->ch, CURLOPT_URL, ZooZExtendedServerAPI::$zoozServer);
	curl_setopt($this->ch, CURLOPT_TIMEOUT, 30 );
	curl_setopt($this->ch, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($this->ch, CURLOPT_POST, true);
        
        return $this->postToZooZ($this->nvps->toString());
        
    }
    
    private function postToZooZ($data) {
				
    curl_setopt($this->ch, CURLOPT_POSTFIELDS, $data);
    $chResult = curl_exec($this->ch);
    $chResult_trim = trim($chResult, "\n");

    return trim($chResult_trim);
    
    }
    
    function getNvps(){
        return $this->nvps->toString();
    }

}

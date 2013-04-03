<?php

include_once 'lib/zooz.extended.server.api.php';


const DEVELOPER_ID = "<developer@email.here>";
const API_KEY = "<api-key>";
const IS_SANDBOX = true;

$zooz = new ZooZExtendedServerAPI(DEVELOPER_ID, API_KEY, IS_SANDBOX);

try {

var_dump($zooz->getTransactionDetailsByTransactionID("<transaction-ID>"));

var_dump($zooz->getTransactionDetailsByPayeeEmail("<payee@email.here>"));


var_dump($zooz->commitTransaction("<transaction-ID>"));

var_dump($zooz->refundTransaction("<transaction-ID>"));
 
	} catch (Exception $e) {
		echo $e->getMessage();
	}
?>
<?php

include_once 'lib/zooz.extended.server.api.php';


const DEVELOPER_ID = '<developer@email.here>';
const API_KEY = '<api-key>';
const IS_SANDBOX = true;

$zooz = new ZooZExtendedServerAPI(DEVELOPER_ID, API_KEY, IS_SANDBOX);

try {

	date_default_timezone_set('Europe/London');
	
	var_dump($zooz->getTransactionDetailsByTransactionID("<transaction-ID>"));
	
	$fromDate = new DateTime('2013-04-04');

	$toDate = new DateTime('2013-04-05');
	
	var_dump($zooz->getTransactionDetailsByPayeeEmail("sharon@zooz.com", $fromDate, $toDate));

	$invoice = Invoice::createInvoice();
	$invoice->addItem("item 1", "", 1, 0.99, 0);
	$invoice->addItem("item 2", "test", 2, 11.25, 0.15, "none");
	$invoice->additionalDetails = "Some more details.";
	$invoice->number = "ABCD12343524545";
	echo json_encode($invoice);
	var_dump($zooz->commitTransaction("<transaction-ID>", NULL, $invoice));

	var_dump($zooz->refundTransaction("<transaction-ID>"));
 
} catch (Exception $e) {

	echo $e->getMessage();

}
?>
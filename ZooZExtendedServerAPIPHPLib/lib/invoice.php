<?php
	
	include_once 'lib/invoice.item.php';

	class Invoice {
		
		public $number;
		public $invoiceItems;
		public $additionalDetails;
		
		function __construct($jsonObj) {
			$this->invoiceItems = Array();
			if (!empty($jsonObj[items])) {
				foreach ($jsonObj[items] as $key => $value) {
					array_push($this->invoiceItems, new InvoiceItem($value));
				}	
			}
			$this->number = $jsonObj[number];
			$this->additionalDetails = utf8_decode($jsonObj[additionalDetails]);		
		}
		
	}
	
?>
<?php
	
	require 'lib/nvps.php';
	require 'lib/invoice.item.php';

	class Invoice {
		
		public $number;
		public $invoiceItems;
		public $additionalDetails;
		
		function __construct() {
			$this->items = Array();			
		}
		
		function addInvoiceItem(InvoiceItem $invoiceItem) {
			array_push($this->invoiceItems, $invoiceItem);
		}
		
		function toNVPs() {
			$nvps = new NVPs();
			
			$INVOICE = "invoice"; 
			
			$nvps->add($INVOICE . ".number" , $this->number);
			$nvps->add($INVOICE . ".additionalDetails" , $this->number);
			
			foreach ($this->invoiceItems as $i => $invoiceItem) {
				$ITEMS = ".items(" . $i . ")";
				$nvps->add($INVOICE . $ITEMS . ".name", $invoiceItem->name);
				$nvps->add($INVOICE . $ITEMS . ".id", $invoiceItem->id);
				$nvps->add($INVOICE . $ITEMS . ".name", $invoiceItem->name);
				$nvps->add($INVOICE . $ITEMS . ".quantity", $invoiceItem->quantity);
				$nvps->add($INVOICE . $ITEMS . ".price", $invoiceItem->price);
				$nvps->add($INVOICE . $ITEMS . ".taxAmount", $invoiceItem->taxAmount);
				$nvps->add($INVOICE . $ITEMS . ".additionalDetails", $invoiceItem->additionalItems);
			}
			
			return $nvps;
		}
	}
	
?>
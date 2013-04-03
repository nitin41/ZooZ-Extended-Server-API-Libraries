<?php
	class InvoiceItem {
		
		public $name;
		public $id;
		public $quantity;
		public $price;
		public $taxAmount;
		public $additionalDetails; 
		
		function __construct($name, $id, $quantity, $price, $taxAmount, $additionalDetails) {
			$this->name = $name;
			$this->id = $id;
			$this->quantity = $quantity;
			$this->price = $price;
			$this->taxAmount = $taxAmount;
			$this->additionalDetails = $additionalDetails;
		}
	}
?>
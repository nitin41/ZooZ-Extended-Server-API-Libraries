<?php
	class InvoiceItem {
		
		public $name;
		public $id;
		public $quantity;
		public $price;
		public $taxAmount;
		public $additionalDetails; 
		
		function __construct($jsonObj) {
			$this->name = utf8_decode($jsonObj[name]);
			$this->id = $jsonObj[id];
			$this->quantity = $jsonObj[quantity];
			$this->price = $jsonObj[price];
			$this->taxAmount = $jsonObj[taxAmount];
			$this->additionalDetails = utf8_decode($jsonObj[additionalDetails]);
		}
	}
?>
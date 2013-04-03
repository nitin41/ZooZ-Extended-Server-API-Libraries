<?php
	
	class Address {
		
		public $addressType;
 		public $firstName;
 		public $lastName;
// 		public $phoneCountryCode;
// 		public $phoneNumber;
		public $street;
		public $city;
		public $state;
		public $country;
		public $zipCode;
		
		function __construct($addressType, $jsonObj) {
			$this->addressType = $addressType;
			$this->firstName = utf8_decode($jsonObj[firstName]);
			$this->lastName = utf8_decode($jsonObj[lastName]);
			$this->street = utf8_decode($jsonObj[street]);
			$this->city = utf8_decode($jsonObj[city]);
			$this->state = utf8_decode($jsonObj[state]);
			$this->country = utf8_decode($jsonObj[country]);
			$this->zipCode = $jsonObj[zip];
		}
		
	}
	
	
	class AddressType {
		const billingAddress = "billingAddress";
		const shippingAddress = "shippingAddress";
	}

?>
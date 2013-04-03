<?php

	class UserDetails {
		
		public $firstName;
		public $lastName;
		public $phoneCountryCode;
		public $phoneNumber;
		public $email;
		public $additionalDetails;
		
		function __construct($jsonObj) {
			$this->firstName = utf8_decode($jsonObj[firstName]);
			$this->lastName = utf8_decode($jsonObj[lastName]);
			if (!empty($jsonObj[phone])) {
				$this->phoneCountryCode = $jsonObj[phone][countryCode];
				$this->phoneNumber = $jsonObj[phone][phoneNumber];
			}
			$this->email = $jsonObj[email];
			$this->additionalDetails = utf8_decode($jsonObj[additionalDetails]);
		}
		
	}
?>
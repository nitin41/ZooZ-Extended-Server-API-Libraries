<?php

	require 'lib/nvps.php';

	class UserDetails {
		
		public $firstName;
		public $lastName;
		public $phoneCountryCode;
		public $phoneNumber;
		public $email;
		public $idNumber;
		public $zipCode;
		public $additionalDetails;
		
		function toNVPs() {
			$nvps = new NVPs();
			
			$USER = "user";
			
			$nvps->add($USER . ".firstName", $this->firstName);
			$nvps->add($USER . ".lastName", $this->lastName);
			$nvps->add($USER . ".phone.countryCode", $this->phoneCountryCode);
			$nvps->add($USER . ".phone.number", $this->phoneNumber);
			$nvps->add($USER . ".email", $this->email);
			$nvps->add($USER . ".idNumber", $this->idNumber);
			$nvps->add($USER . ".zipCode", $this->zipCode);
			$nvps->add($USER . ".additionalDetails", $this->additionalDetails);
			
			return $nvps;
		}
		
	}
?>
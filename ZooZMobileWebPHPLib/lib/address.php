<?php
	
	require 'lib/nvps.php';

	class Address {
		
		public $addressType;
		public $firstName;
		public $lastName;
		public $phoneCountryCode;
		public $phoneNumber;
		public $street;
		public $city;
		public $state;
		public $country;
		public $zipCode;
		
		function __construct(AddressType $addressType) {
			$this->addressType = $addressType;
		}
		
		function toNVPs() {
			$nvps = new NVPs();
			
			$nvps->add($this->addressType . ".firstName", $this->firstName);
			$nvps->add($this->addressType . ".lastName", $this->lastName);
			$nvps->add($this->addressType . ".phone.countryCode", $this->phoneCountryCode);
			$nvps->add($this->addressType . ".phone.number", $this->phoneNumber);
			$nvps->add($this->addressType . ".street", $this->street);
			$nvps->add($this->addressType . ".city", $this->city);
			$nvps->add($this->addressType . ".state", $this->state);
			$nvps->add($this->addressType . ".country", $this->country);
			$nvps->add($this->addressType . ".zipCode", $this->zipCode);
			
			return $nvps;
		}
		
		
	}
	
	
	class AddressType {
		const billingAddress = "billingAddress";
		const shippingAddress = "shippingAddress";
	}

?>
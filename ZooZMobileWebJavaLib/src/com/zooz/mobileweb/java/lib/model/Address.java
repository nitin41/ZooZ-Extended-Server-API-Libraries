package com.zooz.mobileweb.java.lib.model;


public class Address {
	
	public enum AddressType {
		billingAddress, shippingAddress
	}
	
	private AddressType addressType;
	private String firstName;
	private String lastName;
	private String phoneCountryCode;
	private String phoneNumber;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	
	public Address(AddressType addressType) {
		this.addressType = addressType;
	}


	public AddressType getAddressType() {
		return addressType;
	}


	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}


	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public NVPs toNvps() {
		NVPs nvps = new NVPs();
		
		nvps.add(addressType.name() + ".firstName", firstName);
		nvps.add(addressType.name() + ".lastName", lastName);
		nvps.add(addressType.name() + ".phone.countryCode", phoneCountryCode);
		nvps.add(addressType.name() + ".phone.number", phoneNumber);
		nvps.add(addressType.name() + ".street", street);
		nvps.add(addressType.name() + ".city", city);
		nvps.add(addressType.name() + ".state", state);
		nvps.add(addressType.name() + ".country", country);
		nvps.add(addressType.name() + ".zipCode", zipCode);
		
		return nvps;
		
	}
	
	
	
	

}

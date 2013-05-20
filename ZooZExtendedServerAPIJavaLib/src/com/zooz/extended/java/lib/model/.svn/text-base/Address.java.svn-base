package com.zooz.extended.java.lib.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.zooz.extended.java.lib.utils.ZooZJSONUtils;

public class Address {
	
	public enum AddressType {
		billingAddress, shippingAddress
	}
	
	private AddressType addressType;
	private String firstName;
	private String lastName;
//	private String phoneCountryCode;
//	private String phoneNumber;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	
	public Address(AddressType addressType, JSONObject jsonObject) throws JSONException {
		this.addressType = addressType;
		
		this.firstName = ZooZJSONUtils.getDecodedString(jsonObject, "firstName");
		this.lastName = ZooZJSONUtils.getDecodedString(jsonObject, "lastName");
		this.street = ZooZJSONUtils.getDecodedString(jsonObject, "street");
		this.city = ZooZJSONUtils.getDecodedString(jsonObject, "city");
		this.state = ZooZJSONUtils.getDecodedString(jsonObject, "state");
		this.country = ZooZJSONUtils.getDecodedString(jsonObject, "country");
		this.zipCode = ZooZJSONUtils.getString(jsonObject, "zip");
	}


	public AddressType getAddressType() {
		return addressType;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getStreet() {
		return street;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public String getCountry() {
		return country;
	}


	public String getZipCode() {
		return zipCode;
	}


}

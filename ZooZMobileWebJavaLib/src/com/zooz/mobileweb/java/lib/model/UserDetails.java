package com.zooz.mobileweb.java.lib.model;


public class UserDetails {
	
	private String firstName;
    private String lastName;
    private String phoneCountryCode;
    private String phoneNumber;
    private String email;
    private String idNumber;
    private String zipCode;
    private String additionalDetails;
    
    public UserDetails() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
    
	public NVPs toNvps() {
		NVPs nvps = new NVPs();
		
		final String USER = "user";
		
		nvps.add(USER + ".firstName", firstName);
		nvps.add(USER + ".lastName", lastName);
		nvps.add(USER + ".phone.countryCode", phoneCountryCode);
		nvps.add(USER + ".phone.number", phoneNumber);
		nvps.add(USER + ".email", email);
		nvps.add(USER + ".idNumber", idNumber);
		nvps.add(USER + ".zipCode", zipCode);
		nvps.add(USER + ".additionalDetails", additionalDetails);
		
		return nvps;
		
	}

}

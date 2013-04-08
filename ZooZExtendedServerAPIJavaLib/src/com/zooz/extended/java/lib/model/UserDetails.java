package com.zooz.extended.java.lib.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.zooz.extended.java.lib.utils.ZooZJSONUtils;

public class UserDetails {
	
	private String firstName;
	private String lastName;
	private String phoneCountryCode;
	private String phoneNumber;
	private String email;
	private String additionalDetails;
	
	public UserDetails(JSONObject jsonObject) throws JSONException {
		this.firstName = ZooZJSONUtils.getDecodedString(jsonObject, "firstName");
		this.lastName = ZooZJSONUtils.getString(jsonObject, "lastName");
		JSONObject phoneJsonObj = ZooZJSONUtils.getJSONObject(jsonObject, "phone");
		if (phoneJsonObj != null) {
			this.phoneCountryCode = ZooZJSONUtils.getString(phoneJsonObj, "countryCode");
			this.phoneNumber = ZooZJSONUtils.getString(phoneJsonObj, "phoneNumber");
		}
		this.email = ZooZJSONUtils.getString(jsonObject, "email");
		this.additionalDetails = ZooZJSONUtils.getDecodedString(jsonObject, "additionalDetails");
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}
	
	
	

}

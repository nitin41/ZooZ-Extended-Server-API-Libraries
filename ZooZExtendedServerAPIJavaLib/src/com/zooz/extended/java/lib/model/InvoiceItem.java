package com.zooz.extended.java.lib.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.zooz.extended.java.lib.utils.ZooZJSONUtils;

public class InvoiceItem {
	
	private String name;
	private String id;
	private double quantity;
	private double price;
	private double taxAmount;
	private String additionalDetails;
	
	
	public InvoiceItem(JSONObject jsonObject) throws JSONException {
		this.name = ZooZJSONUtils.getDecodedString(jsonObject, "name");
		this.id = ZooZJSONUtils.getString(jsonObject, "id");
		this.quantity = ZooZJSONUtils.getDouble(jsonObject, "quantity");
		this.price = ZooZJSONUtils.getDouble(jsonObject, "price");
		this.taxAmount = ZooZJSONUtils.getDouble(jsonObject, "taxAmount");
		this.additionalDetails = ZooZJSONUtils.getDecodedString(jsonObject, "additionalDetails");
	}


	public String getName() {
		return name;
	}


	public String getId() {
		return id;
	}


	public double getQuantity() {
		return quantity;
	}


	public double getPrice() {
		return price;
	}


	public double getTaxAmount() {
		return taxAmount;
	}


	public String getAdditionalDetails() {
		return additionalDetails;
	}

	
}

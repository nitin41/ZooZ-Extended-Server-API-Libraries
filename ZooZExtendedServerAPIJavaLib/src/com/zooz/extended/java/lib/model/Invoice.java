package com.zooz.extended.java.lib.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zooz.extended.java.lib.utils.ZooZJSONUtils;

public class Invoice {

	private String number;
	private List<InvoiceItem> invoiceItems;
	private String additionalDetails;
	
	public Invoice(JSONObject jsonObject) {
		this.invoiceItems = new ArrayList<InvoiceItem>();
		if (!jsonObject.isNull("items")) {
			JSONArray invoiceItemsArray = jsonObject.getJSONArray("items");
			for (int i = 0; i < invoiceItemsArray.length(); i++) {
				JSONObject jsonObj = invoiceItemsArray.getJSONObject(i);
				invoiceItems.add(new InvoiceItem(jsonObj));
			}
		}
		
		this.number = jsonObject.getString("number");
		this.additionalDetails = ZooZJSONUtils.getDecodedString(jsonObject, "additionalDetails");
	}

	public String getNumber() {
		return number;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}
	
}

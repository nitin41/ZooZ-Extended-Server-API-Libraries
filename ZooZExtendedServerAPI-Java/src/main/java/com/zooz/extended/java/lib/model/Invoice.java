package com.zooz.extended.java.lib.model;

import com.zooz.extended.java.lib.utils.ZooZJSONUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

	private String number;
    private String additionalDetails;
    private List<InvoiceItem> invoiceItems;

	public Invoice(JSONObject jsonObject) throws JSONException {
        this.additionalDetails = ZooZJSONUtils.getDecodedString(jsonObject, "additionalDetails");
        this.invoiceItems = new ArrayList<InvoiceItem>();
        if (!jsonObject.isNull("items")) {
            JSONArray invoiceItemsArray = jsonObject.getJSONArray("items");
            for (int i = 0; i < invoiceItemsArray.length(); i++) {
                JSONObject jsonObj = invoiceItemsArray.getJSONObject(i);
                this.invoiceItems.add(new InvoiceItem(jsonObj));
            }
        }
        this.number = jsonObject.getString("number");

	}
	
	public Invoice() {
		this.number = null;
		this.additionalDetails = null;
		this.invoiceItems = new ArrayList<InvoiceItem>();
	}
	
	public void addItem(String name, String id, double quantity, double price, double taxAmount, String additionalDetails) {
		invoiceItems.add(new InvoiceItem(name, id, quantity, price, taxAmount, additionalDetails));
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
	
	public void setNumber(String number) {
		this.number = number;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public String toJSONString() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("number", number);
		jsonObject.put("items", new JSONArray(invoiceItems));
		jsonObject.put("additionalDetails", additionalDetails);
		
		return jsonObject.toString();
	}
}

package com.zooz.mobileweb.java.lib.model;

import java.util.ArrayList;
import java.util.List;

import com.zooz.mobileweb.java.lib.utils.ZooZStringUtils;

public class Invoice {

	private String number;
	private String additionalDetails;
	private List<InvoiceItem> invoiceItems;

	public Invoice() {
		this.invoiceItems = new ArrayList<InvoiceItem>();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public void addInvoiceItem(InvoiceItem invoiceItem) {
		invoiceItems.add(invoiceItem);
	}


	public NVPs toNvps() {
		NVPs nvps = new NVPs();

		final String INVOICE = "invoice";

		nvps.add(INVOICE + ".number", number);
		nvps.add(INVOICE + ".additionalDetails", additionalDetails);
		for (int i = 0; i < invoiceItems.size(); i++) {

			InvoiceItem item = invoiceItems.get(i);
			if (!ZooZStringUtils.isEmpty(item.getName())) {
				final String ITEMS = ".items(" + i + ")";
				nvps.add(INVOICE + ITEMS + ".name", item.getName());
				nvps.add(INVOICE + ITEMS + ".id", item.getIdentifier());
				nvps.addDouble(INVOICE + ITEMS + ".quantity", item.getQuantity());
				nvps.addDouble(INVOICE + ITEMS + ".price", item.getPrice());
				nvps.addDouble(INVOICE + ITEMS + ".taxAmount", item.getTax());
				nvps.add(INVOICE + ITEMS + ".additionalDetails", item.getAdditionalDetails());
			}

		}

		return nvps;
	}



}

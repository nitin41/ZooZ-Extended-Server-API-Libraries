package com.zooz.mobileweb.java.lib.model;

public class InvoiceItem {
	
	private String name;
	private String identifier;
	private double quantity;
	private double price;
	private double tax;
	private String additionalDetails;
	
	public InvoiceItem(String name, String identifier, double quantity, double price, double tax, String additionalDetails) {
		this.name = name;
		this.identifier = identifier;
		this.quantity = quantity;
		this.price = price;
		this.tax = tax;
		this.additionalDetails = additionalDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
	

}

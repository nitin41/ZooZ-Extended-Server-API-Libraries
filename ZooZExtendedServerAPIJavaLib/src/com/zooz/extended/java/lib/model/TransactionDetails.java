package com.zooz.extended.java.lib.model;

import java.util.Date;

import org.json.JSONObject;

import com.zooz.extended.java.lib.model.Address.AddressType;
import com.zooz.extended.java.lib.utils.ZooZJSONUtils;

public class TransactionDetails {
	
	public enum TransactionStatus {
		Pending, 
	    TPCPending,
		AuthorizationProcess,
	    Succeed,
		Failed
	}
	
	private String appName;
	private String transactionID;
	private boolean isSandbox;
	private TransactionStatus transactionStatus;
	private String fundSourceType;
	private String lastFourDigits;
	private double amount;
	private double paidAmount;
	private String currencyCode;
	private double transactionFee;
	private Date transactionTimestamp;
	private UserDetails userDetails;
	private Invoice invoice;
	private Address billingAddress;
	private Address shippingAddress;
	
	public TransactionDetails(JSONObject jsonObject) {
		this.amount = ZooZJSONUtils.getDouble(jsonObject, "amount");
		this.appName = ZooZJSONUtils.getDecodedString(jsonObject, "appName");
		JSONObject addressesJson = ZooZJSONUtils.getJSONObject(jsonObject, "addresses");
		if (addressesJson != null) {
			if (!addressesJson.isNull("billing")) {
				this.billingAddress = new Address(AddressType.billingAddress, ZooZJSONUtils.getJSONObject(addressesJson, "billing"));
			}
			if (!addressesJson.isNull("shipping")) {
				this.shippingAddress = new Address(AddressType.shippingAddress, ZooZJSONUtils.getJSONObject(addressesJson, "shipping"));
			}
		}
		this.currencyCode = ZooZJSONUtils.getString(jsonObject, "currencyCode");
		this.fundSourceType = ZooZJSONUtils.getString(jsonObject, "fundSourceType");
		JSONObject invoiceJson = ZooZJSONUtils.getJSONObject(jsonObject, "invoice");
		if (invoiceJson != null) {
			this.invoice = new Invoice(invoiceJson);
		}
		this.isSandbox = ZooZJSONUtils.getBoolean(jsonObject, "isSandbox");
		this.lastFourDigits = ZooZJSONUtils.getString(jsonObject, "lastFourDigits");
		this.paidAmount = ZooZJSONUtils.getDouble(jsonObject, "paidAmount");
		this.transactionFee = ZooZJSONUtils.getDouble(jsonObject, "transactionFee");
		this.transactionID = ZooZJSONUtils.getString(jsonObject, "transactionID");
		try {
			this.transactionStatus = TransactionStatus.valueOf(ZooZJSONUtils.getString(jsonObject, "transactionStatus"));
		} catch (Exception e) {
			// do nothing
		}
		if (!jsonObject.isNull("transactionTimestamp")) {
			this.transactionTimestamp = new Date(jsonObject.getLong("transactionTimestamp"));
		}
		if (!jsonObject.isNull("user")) {
			this.userDetails = new UserDetails(ZooZJSONUtils.getJSONObject(jsonObject, "user"));
		}
		
	}

	public String getAppName() {
		return appName;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public boolean isSandbox() {
		return isSandbox;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public String getFundSourceType() {
		return fundSourceType;
	}

	public String getLastFourDigits() {
		return lastFourDigits;
	}

	public double getAmount() {
		return amount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public double getTransactionFee() {
		return transactionFee;
	}

	public Date getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	
	

}

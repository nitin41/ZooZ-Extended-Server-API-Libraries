/*
 * The information in this document is proprietary
 * to TactusMobile and the TactusMobile Product Development.
 * It may not be used, reproduced or disclosed without
 * the written approval of the General Manager of
 * TactusMobile Product Development.
 * 
 * PRIVILEGED AND CONFIDENTIAL
 * TACTUS MOBILE PROPRIETARY INFORMATION
 * REGISTRY SENSITIVE INFORMATION
 *
 * Copyright (c) 2010 TactusMobile, Inc.  All rights reserved.
 */

package com.zooz.sample.mobileweb;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zooz.mobileweb.java.lib.ZooZLibrary;
import com.zooz.mobileweb.java.lib.exceptions.ZooZException;
import com.zooz.mobileweb.java.lib.model.Address;
import com.zooz.mobileweb.java.lib.model.Invoice;
import com.zooz.mobileweb.java.lib.model.InvoiceItem;
import com.zooz.mobileweb.java.lib.model.UserDetails;
import com.zooz.mobileweb.java.lib.model.Address.AddressType;
import com.zooz.mobileweb.java.lib.utils.StringUtils;


/**
 * Sample servlet for mobile web checkout.
 * This class demonstrates the integration with the ZooZ server.
 * 
 */
@WebServlet(name = "SampleServlet", urlPatterns = "/SampleServlet")
public class SampleServlet extends HttpServlet {

	private static final long serialVersionUID = 3570259871387669173L;
	private static final Logger logger = Logger.getLogger(SampleServlet.class.getName());

	private static final String THANK_YOU_PAGE = "/thankyou.html";
	private static final String FAILED_PAGE = "/failed.html";
	
	//Unique ID as registered on the ZooZ developer portal
	private String uniqueId = "com.zooz.mobileweb.sample";
			
	//The app key for this registered app
	private String appKey = "my-app-key";
	
	private boolean isSandbox = true;
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		logger.fine("SampleServlet-init");
	
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException  {

		String cmd = request.getParameter("cmd");
		
		try {
			
			
			ZooZLibrary zoozLibrary = new ZooZLibrary(uniqueId, appKey, isSandbox);
			

			if (cmd.equals("openTrx")){
				
				Address billingAddress = new Address(AddressType.billingAddress);
				billingAddress.setCity(request.getParameter("billingAddress.city"));
				billingAddress.setCountry(request.getParameter("billingAddress.country"));
				billingAddress.setFirstName(request.getParameter("billingAddress.firstName"));
				billingAddress.setLastName(request.getParameter("billingAddress.lastName"));
				billingAddress.setPhoneCountryCode(request.getParameter("billingAddress.phone.countryCode"));
				billingAddress.setPhoneNumber(request.getParameter("billingAddress.phone.number"));
				billingAddress.setState(request.getParameter("billingAddress.state"));
				billingAddress.setStreet(request.getParameter("billingAddress.street"));
				billingAddress.setZipCode(request.getParameter("billingAddress.zipCode"));

				zoozLibrary.setBillingAddress(billingAddress);
				
				Address shippingAddress = new Address(AddressType.shippingAddress);
				shippingAddress.setCity(request.getParameter("shippingAddress.city"));
				shippingAddress.setCountry(request.getParameter("shippingAddress.country"));
				shippingAddress.setFirstName(request.getParameter("shippingAddress.firstName"));
				shippingAddress.setLastName(request.getParameter("shippingAddress.lastName"));
				shippingAddress.setPhoneCountryCode(request.getParameter("shippingAddress.phone.countryCode"));
				shippingAddress.setPhoneNumber(request.getParameter("shippingAddress.phone.number"));
				shippingAddress.setState(request.getParameter("shippingAddress.state"));
				shippingAddress.setStreet(request.getParameter("shippingAddress.street"));
				shippingAddress.setZipCode(request.getParameter("shippingAddress.zipCode"));

				zoozLibrary.setShippingAddress(shippingAddress);
				
				UserDetails userDetails = new UserDetails();
				userDetails.setAdditionalDetails(request.getParameter("user.additionalDetails"));
				userDetails.setEmail(request.getParameter("user.email"));
				userDetails.setFirstName(request.getParameter("user.firstName"));
				userDetails.setIdNumber(request.getParameter("user.idNumber"));
				userDetails.setLastName(request.getParameter("user.lastName"));
				userDetails.setPhoneCountryCode(request.getParameter("user.phone.countryCode"));
				userDetails.setPhoneNumber(request.getParameter("user.phone.number"));
				userDetails.setZipCode(request.getParameter("user.zipCode"));
				
				zoozLibrary.setUserDetails(userDetails);
				
				Invoice invoice = new Invoice();
				if (!StringUtils.isEmpty(request.getParameter("invoice.items(0).name"))) {
					invoice.addInvoiceItem(new InvoiceItem(request.getParameter("invoice.items(0).name"), request.getParameter("invoice.items(0).id"), !StringUtils.isEmpty(request.getParameter("invoice.items(0).quantity")) ? Double.parseDouble(request.getParameter("invoice.items(0).quantity")) : 0, !StringUtils.isEmpty(request.getParameter("invoice.items(0).price")) ? Double.parseDouble(request.getParameter("invoice.items(0).price")) : 0, !StringUtils.isEmpty(request.getParameter("invoice.items(0).taxAmount")) ? Double.parseDouble(request.getParameter("invoice.items(0).taxAmount")) : 0, request.getParameter("invoice.items(0).additionalDetails")));
				}
				if (!StringUtils.isEmpty(request.getParameter("invoice.items(1).name"))) {
					invoice.addInvoiceItem(new InvoiceItem(request.getParameter("invoice.items(1).name"), request.getParameter("invoice.items(1).id"), !StringUtils.isEmpty(request.getParameter("invoice.items(1).quantity")) ? Double.parseDouble(request.getParameter("invoice.items(1).quantity")) : 0, !StringUtils.isEmpty(request.getParameter("invoice.items(1).price")) ? Double.parseDouble(request.getParameter("invoice.items(1).price")) : 0, !StringUtils.isEmpty(request.getParameter("invoice.items(1).taxAmount")) ? Double.parseDouble(request.getParameter("invoice.items(1).taxAmount")) : 0, request.getParameter("invoice.items(1).additionalDetails")));
				}
				if (!StringUtils.isEmpty(request.getParameter("invoice.items(2).name"))) {
					invoice.addInvoiceItem(new InvoiceItem(request.getParameter("invoice.items(2).name"), request.getParameter("invoice.items(2).id"), !StringUtils.isEmpty(request.getParameter("invoice.items(2).quantity")) ? Double.parseDouble(request.getParameter("invoice.items(2).quantity")) : 0, !StringUtils.isEmpty(request.getParameter("invoice.items(2).price")) ? Double.parseDouble(request.getParameter("invoice.items(2).price")) : 0, !StringUtils.isEmpty(request.getParameter("invoice.items(2).taxAmount")) ? Double.parseDouble(request.getParameter("invoice.items(2).taxAmount")) : 0, request.getParameter("invoice.items(2).additionalDetails")));
				}
				
				invoice.setAdditionalDetails(request.getParameter("invoice.additionalDetails"));
				invoice.setNumber(request.getParameter("invoice.number"));
				
				zoozLibrary.setInvoice(invoice);
				
				response.setContentType("text/json");
				

				String responseToClient = "";
				
				try {
					responseToClient = "var data = {'token' : '" + zoozLibrary.openTrx(0.99, 0, "EUR") + "'}";
				} catch (ZooZException e) {
					responseToClient = "var data = {'errorMessage' : '" + e.getMessage() + "'}";
				}
				
								
				// 2. send response back to page
				response.getWriter().print(responseToClient);

			
			} else if (cmd.equals("verifyTrx")){

				String transactionID = request.getParameter("transactionID");
				
				String transactionDisplayID = request.getParameter("transactionDisplayID");

				
				try {
					zoozLibrary.verifyTrx(transactionID);
				} catch (ZooZException e) {
					logger.log(Level.WARNING, "Error to confirm payment. " + e.getMessage());
					getServletContext().getRequestDispatcher(FAILED_PAGE).forward(request, response);
				}
				
				logger.log(Level.INFO, "Payment " + transactionID + " was confirmed. Display ID: " + transactionDisplayID);
				getServletContext().getRequestDispatcher(THANK_YOU_PAGE).forward(request, response);
				
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "General error when processing request.", ex);
			response.getWriter().println("Error " + ex.getMessage());
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}

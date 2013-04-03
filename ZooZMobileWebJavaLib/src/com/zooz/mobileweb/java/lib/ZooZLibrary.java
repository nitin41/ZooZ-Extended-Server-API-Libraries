package com.zooz.mobileweb.java.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zooz.mobileweb.java.lib.exception.ZooZException;
import com.zooz.mobileweb.java.lib.model.Address;
import com.zooz.mobileweb.java.lib.model.Invoice;
import com.zooz.mobileweb.java.lib.model.NVPs;
import com.zooz.mobileweb.java.lib.model.UserDetails;
import com.zooz.mobileweb.java.lib.responseobjects.OpenTrxResponse;
import com.zooz.mobileweb.java.lib.responseobjects.VerifyTrxResponse;
import com.zooz.mobileweb.java.lib.utils.ZooZStringUtils;

public class ZooZLibrary {
	
	private String zoozUniqueId;
	private String zoozAppKey;
	private String zoozServer;
	
	private UserDetails userDetails;
	private Address billingAddress;
	private Address shippingAddress;
	private Invoice invoice;
	
	private static final Logger logger = Logger.getLogger(ZooZLibrary.class.getName());
	
	private static final String SANDBOX_URL = "https://sandbox.zooz.co";
	private static final String PRODUCTION_URL = "https://app.zooz.com";
	
	/**
	 * ZooZLibrary constructor
	 * 
	 * @param zoozUniqueId - App Unique ID, as registered in the ZooZ developer portal.
	 * @param zoozAppKey - App key as received upon registration - can be found on the top section of the app details.
	 * @param isSandbox - TRUE to use sandbox environment, FALSE to use live environment.
	 * @throws ZooZException
	 */
	public ZooZLibrary(String zoozUniqueId, String zoozAppKey, boolean isSandbox) throws ZooZException {
		
		if (ZooZStringUtils.isEmpty(zoozUniqueId)) {
			throw new ZooZException("Please enter ZooZ unique ID as registered in ZooZ's developer portal");
		}
		
		if (ZooZStringUtils.isEmpty(zoozAppKey)) {
			throw new ZooZException("Please enter ZooZ App Key as diaplayed in ZooZ's developer portal under app details");
		}
		
		this.zoozUniqueId = zoozUniqueId;
		this.zoozAppKey = zoozAppKey;
		if (isSandbox) {
			zoozServer = SANDBOX_URL;
		} else {
			zoozServer = PRODUCTION_URL;
		}
	}
	
	
	/**
	 * Open transaction on a secured channel to ZooZ server. This call returns a token that will be used to uniquely identify the transaction.
	 * @param amount - The amount to pay (including tax).
	 * @param taxAmount - (Optional) Tax amount for the payment.
	 * @param currencyCode - ISO-4217 3-letter currency code.
	 * @return String sessionToken - to be used with the JavaScript call zoozStartCheckout()
	 * @throws ZooZException
	 */
	public String openTrx(double amount, double taxAmount, String currencyCode) throws ZooZException {
		
		if (amount <= 0) {
			throw new ZooZException("Amount has to be a positive value");
		}
		if (ZooZStringUtils.isEmpty(currencyCode)) {
			throw new ZooZException("Currency code is empty");
		}
		
		NVPs nvps = new NVPs();
		
		nvps.add("cmd", "openTrx");
		
		nvps.addDouble("amount", amount);
		nvps.add("currencyCode", currencyCode);
		
		if (taxAmount != 0) {
			nvps.addDouble("taxAmount", taxAmount);
		}
		
		
		if (userDetails != null) {
			nvps.addAll(userDetails.toNvps());
		}
		if (billingAddress != null) {
			nvps.addAll(billingAddress.toNvps());
		}
		if (shippingAddress != null) {
			nvps.addAll(shippingAddress.toNvps());
		}
		if (invoice != null) {
			nvps.addAll(invoice.toNvps());
		}
		
		OpenTrxResponse openTrxResponse = null;
		
		try {
			openTrxResponse = OpenTrxResponse.create(postToZooZ(nvps.toString()));
		} catch (Exception e) {
			throw new ZooZException(e);
		}
		
		if (openTrxResponse.getStatusCode() != 0) {
			String errorMessage = openTrxResponse.getErrorMessage();
			if (ZooZStringUtils.isEmpty(errorMessage)) {
				errorMessage = "Some general error has occured, please try again";
			}
			logger.log(Level.WARNING, errorMessage);
			throw new ZooZException(errorMessage);
		}
		
		return openTrxResponse.getSessionToken();
		
	}

	/**
	 * Verify the transaction to make sure transaction indeed succeeded. 
	 * 
	 * @param transactionId - Transaction ID as returned by ZooZ to the returnUrl upon transaction completion.
	 * @return boolean - true if transaction was successfully verified.
	 * @throws ZooZException
	 */
	public boolean verifyTrx(String transactionId) throws ZooZException {

		if (ZooZStringUtils.isEmpty(transactionId)) {
			throw new ZooZException("transactionId cannot be empty");
		}
		
		NVPs nvps = new NVPs();
		
		nvps.add("cmd", "verifyTrx");
		
		nvps.add("trxId", transactionId);
		
		VerifyTrxResponse verifyTrxResponse = null;
		
		try {
			verifyTrxResponse = VerifyTrxResponse.create(postToZooZ(nvps.toString()));
		} catch (IOException e) {
			throw new ZooZException(e);
		}
		
		if (verifyTrxResponse.getStatusCode() != 0) {
			String errorMessage = verifyTrxResponse.getErrorMessage();
			if (ZooZStringUtils.isEmpty(errorMessage)) {
				errorMessage = "Some general error has occured, please try again";
			}
			logger.log(Level.WARNING, errorMessage);
			throw new ZooZException(errorMessage);
		}
		
		return true;
	}


	private String postToZooZ(String data) throws IOException {

		Writer writer = null;
		BufferedReader reader = null;
		StringBuilder resultSB = new StringBuilder();
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(zoozServer + "/mobile/SecuredWebServlet")
			.openConnection();
			conn.setDoOutput(true);

			// set bundleId and appKey for authentication to ZooZ secured server
			conn.setRequestProperty("ZooZUniqueID", zoozUniqueId);
			conn.setRequestProperty("ZooZAppKey", zoozAppKey);
			conn.setRequestProperty("ZooZResponseType", "NVP");
			
			conn.setReadTimeout(30000);

			// Send data
			writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(data);
			writer.flush();

			// Get the response
			reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				resultSB.append(line);
			}

		} catch (IOException ex) {
			logger.log(Level.WARNING, "Error to read/write from ZooZ server."
					+ ex.getMessage(), ex);
			throw ex;
		} finally {
			try {
				if (writer != null)
					writer.close();
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				logger.log(Level.WARNING, "Error to close reader/writer.", ex);
			}
		}

		return resultSB.toString();
	}

}

package com.zooz.extended.java.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zooz.extended.java.lib.exception.ZooZException;
import com.zooz.extended.java.lib.model.NVPs;
import com.zooz.extended.java.lib.model.TransactionDetails;
import com.zooz.extended.java.lib.utils.ZooZStringUtils;
import com.zooz.extended.java.lib.utils.ZooZJSONUtils;

public class ZooZExtendedServerAPI {
	
	private static final String SANDBOX_URL = "https://sandbox.zooz.co";
	private static final String PRODUCTION_URL = "https://app.zooz.com";
	
	private static final String VERSION_NUMBER = "1.0.1";
	
	private static final Logger logger = Logger.getLogger(ZooZExtendedServerAPI.class.getName());
	
	
	private String zoozDeveloperId;
	private String zoozServerAPIKey;
	private String zoozServer;
	
	/**
	 * ZooZExtendedServerAPI Constructor.
	 * 
	 * @param zoozDeveloperId - Developer email as entered in ZooZ Developer portal.
	 * @param zoozServerKey - ZooZ Server API Key assigned to you upon registration. Can be found on the "Account" section of the ZooZ Developer Portal.
	 * @param isSandbox - true to use sandbox environment, false to use live environment.
	 * @throws ZooZException
	 */
	public ZooZExtendedServerAPI(String zoozDeveloperId, String zoozServerKey, boolean isSandbox) throws ZooZException {
		
		if (ZooZStringUtils.isEmpty(zoozDeveloperId)) {
			throw new ZooZException("Please enter your developer email as registered in ZooZ's developer portal");
		}
		
		if (ZooZStringUtils.isEmpty(zoozServerKey)) {
			throw new ZooZException("Please enter ZooZ Server API Key as diaplayed in ZooZ's developer portal under \'My Account\'");
		}
		
		this.zoozDeveloperId = zoozDeveloperId;
		this.zoozServerAPIKey = zoozServerKey;
		if (isSandbox) {
			this.zoozServer = SANDBOX_URL;
		} else {
			this.zoozServer = PRODUCTION_URL;
		}
	}
	
	
	/**
	 * Get transaction details with the transaction ID API. 
	 * This allows you to retrieve complete transaction details and transaction statuses before and/or after commit or refund. 
	 * This call does not change the transaction state.
	 * 
	 * @param transactionID - Transaction ID as returned by the SDK upon transaction completion.
	 * @throws ZooZException
	 * @return TransactionDetails - Transaction details for above transaction
	 */
	public TransactionDetails getTransactionDetailsByTransactionID(String transactionID) throws ZooZException {
		if (ZooZStringUtils.isEmpty(transactionID)) {
			throw new ZooZException("transactionID is empty");
		}
		
		NVPs nvps = new NVPs();
		nvps.add("cmd", "getTransactionDetails");
		nvps.add("ver", VERSION_NUMBER);
		nvps.add("transactionID", transactionID);
		
		JSONObject responseObj = postToZooZ(nvps.toString());
		
		try {
			return new TransactionDetails(responseObj);
		} catch (JSONException e) {
			throw new ZooZException(e);
		}
		
	}
	
	/**
	 * Retrieve transaction full details and transaction status before or/and after commit or refund for all transactions associated with the payee's email. 
	 * 
	 * @param email - Payee's email
	 * @throws ZooZException
	 * @return TransactionDetails[] - Array of transaction details for all transactions associated with the above email
	 */
	public ArrayList<TransactionDetails> getTransactionDetailsByPayeeEmail(String email) throws ZooZException {
		
		if (ZooZStringUtils.isEmpty(email)) {
			throw new ZooZException("email is empty");
		}
		
		NVPs nvps = new NVPs();
		nvps.add("cmd", "getTransactionDetailsByPayeeEmail");
		nvps.add("ver", VERSION_NUMBER);
		nvps.add("email", email);
		
		JSONObject responseObj = postToZooZ(nvps.toString());
		
		try {

			ArrayList<TransactionDetails> transactionDetailsArr = new ArrayList<TransactionDetails>();
				if (responseObj != null && !responseObj.isNull("payments")) {
					JSONArray paymentsJsonArray = responseObj.getJSONArray("payments");
					for (int i = 0; i < paymentsJsonArray.length(); i++) {
						JSONObject paymentJson = paymentsJsonArray.getJSONObject(i);
						transactionDetailsArr.add(new TransactionDetails(paymentJson));
					}
				}
			return transactionDetailsArr;
		} catch (JSONException e) {
			throw new ZooZException(e);
		}
	}
	
	/**
	 * Commit a transaction in pending status (If your app is set to allow deferred payments).
	 * 
	 * @param transactionID - Transaction ID as returned by the SDK upon transaction completion.
	 * @param amount - (Optional) amount for partial commit, must be lower that the original transaction amount.
	 * @throws ZooZException
	 * @return boolean - true if action completed successfully.
	 */
	public boolean commitTransaction(String transactionID, Double amount) throws ZooZException {
		
		if (ZooZStringUtils.isEmpty(transactionID)) {
			throw new ZooZException("transactionID is empty");
		}
		
		NVPs nvps = new NVPs();
		nvps.add("cmd", "commitTransaction");
		nvps.add("ver", VERSION_NUMBER);
		nvps.add("transactionID", transactionID);
		
		if (amount != null) {
			nvps.add("amount", String.valueOf(amount));
		}
		
		JSONObject responseObj = postToZooZ(nvps.toString());
		try {
			return responseObj.getBoolean("boolean");
		} catch (JSONException e) {
			throw new ZooZException(e);
		}
		
	}
	
	/**
	 * Refund a transaction (Up to 60 days after execution)
	 * 
	 * @param transactionID - Transaction ID as returned by the SDK upon transaction completion.
	 * @param amount - (Optional) amount for partial refund, must be lower that the original transaction amount.
	 * @throws ZooZException
	 * @return boolean - true if action completed successfully.
	 */
	public boolean refundTransaction(String transactionID, Double amount) throws ZooZException {
		
		if (ZooZStringUtils.isEmpty(transactionID)) {
			throw new ZooZException("transactionID is empty");
		}
		
		NVPs nvps = new NVPs();
		nvps.add("cmd", "refundTransaction");
		nvps.add("ver", VERSION_NUMBER);
		nvps.add("transactionID", transactionID);
		
		if (amount != null) {
			nvps.add("amount", String.valueOf(amount));
		}
		
		JSONObject responseObj = postToZooZ(nvps.toString());
		try {
			return responseObj.getBoolean("boolean");
		} catch (JSONException e) {
			throw new ZooZException(e);
		}
		
	}
	
	
	private JSONObject postToZooZ(String data) throws ZooZException {

		Writer writer = null;
		BufferedReader reader = null;
		StringBuilder resultSB = new StringBuilder();
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(zoozServer + "/mobile/ExtendedServerAPI")
			.openConnection();
			conn.setDoOutput(true);

			// set bundleId and appKey for authentication to ZooZ secured server
			conn.setRequestProperty("ZooZDeveloperId", zoozDeveloperId);
			conn.setRequestProperty("ZooZServerAPIKey", zoozServerAPIKey);
			
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
			throw new ZooZException(ex);
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

		String res = resultSB.toString();
		
		try {
			JSONObject responseJson = new JSONObject(res);
			
			if (responseJson == null || responseJson.isNull("ResponseStatus")) {
				throw new ZooZException("Error communicating with ZooZ server, please check your network connection");
			}
			
			int responseStatus = responseJson.getInt("ResponseStatus");
			JSONObject responseObjectJson = ZooZJSONUtils.getJSONObject(responseJson, "ResponseObject");
			if (responseStatus != 0) {
				throw new ZooZException(ZooZJSONUtils.getDecodedString(responseObjectJson, "errorMessage"), responseStatus);
			}
			
			return responseObjectJson;
		} catch (JSONException e) {
			throw new ZooZException(res);
		}
		
	}
}

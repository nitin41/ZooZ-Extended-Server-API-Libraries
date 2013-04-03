package com.zooz.extended.java.lib.sample;

import java.lang.reflect.Field;
import java.util.List;

import com.zooz.extended.java.lib.ZooZExtendedServerAPI;
import com.zooz.extended.java.lib.exception.ZooZException;
import com.zooz.extended.java.lib.model.Address;
import com.zooz.extended.java.lib.model.Invoice;
import com.zooz.extended.java.lib.model.InvoiceItem;
import com.zooz.extended.java.lib.model.TransactionDetails;
import com.zooz.extended.java.lib.model.UserDetails;

public class ZooZExtendedServerAPISample {
	
	private static final String DEVELOPER_ID = "<developer@email.here>";
	private static final String API_KEY = "<api-key>";
	private static final boolean IS_SANDBOX = true;
	
	
	public static void main(String[] args) {
		
		try {
			ZooZExtendedServerAPI zoozExtendedServerAPI = new ZooZExtendedServerAPI(DEVELOPER_ID, API_KEY, IS_SANDBOX);

			TransactionDetails transactionDetails = zoozExtendedServerAPI.getTransactionDetailsByTransactionID("<transaction-ID>");
			
			dumpObject(transactionDetails);
			
			System.out.println("------------------------------------------------------");
			
			for (TransactionDetails trxDetails : zoozExtendedServerAPI.getTransactionDetailsByPayeeEmail("<payee@email.here>")) {
				dumpObject(trxDetails);
				System.out.println("-------");
			}
			
			System.out.println("------------------------------------------------------");
			
			if (zoozExtendedServerAPI.refundTransaction("<transaction-ID>", null)) {
				System.out.println("Refund completed successfully");
			}
			
			if (zoozExtendedServerAPI.commitTransaction("<transaction-ID>", null)) {
				System.out.println("Commit completed successfully");
			}
			
			
		} catch (ZooZException e) {
			System.err.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void dumpObject(Object object) throws IllegalArgumentException, IllegalAccessException {
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String name = field.getName();
			Object value = field.get(object);
			System.out.print(name + ": ");
			if (value instanceof List<?>) {
				List<?> list = (List<?>) value;
				System.out.print("[ ");
				for (int i = 0; i < list.size(); i++) {
					dumpObject(list.get(i));
					if (i < list.size() - 1) {
						System.out.print(',');
					}
				}
				System.out.println(" ]");
			} else if (value instanceof UserDetails || value instanceof Address || value instanceof Invoice || value instanceof InvoiceItem) {
				System.out.print("{ ");
				dumpObject(value);
				System.out.println(" }");
			} else {
				System.out.println(value);
			}
		}
	}
	

}

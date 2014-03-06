package com.zooz.extended.java.lib.sample;

import com.zooz.extended.java.lib.Commands.*;
import com.zooz.extended.java.lib.ZooZExtendedServerAPI;
import com.zooz.extended.java.lib.ZooZQueryTypes.*;
import com.zooz.extended.java.lib.exception.ZooZException;
import com.zooz.extended.java.lib.model.Invoice;
import com.zooz.extended.java.lib.model.InvoiceItem;
import com.zooz.extended.java.lib.model.QueryType;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Developer: Roy Keynan
 * <p/>
 * ZooZ Extended server API allows you to extend your control and manageability of your payment
 * transactions.
 * With the Extended Server API you can:
 * 1. Defer payments -??approve your users’ purchases after they authorize ZooZ transactions
 * 2. Get full details on transactions by transaction ID or payee email address.
 * 3. Refund transactions Prior to initiating any forms of integration,
 * it will be necessary for you to sign up for ZooZ at http://www.ZooZ.com
 * The purpose of this guide is to provide you with all necessary information for integration, however if you have
 * any questions, please feel free to contact us at support@ZooZ.com
 */
public class ZooZExtendedServerAPISample {

    private static final String DEVELOPER_ID = "developer@email.here";
    private static final String API_KEY = "api-key.here";
    private static final boolean IS_SANDBOX = true;
    private static FileHandler fileTxt;
    public static final Logger LOGGER = Logger.getLogger(ZooZExtendedServerAPISample.class.getName());

    public static void main(String[] args) {

        try {

            ZooZSettingUpLogger();

            LOGGER.info("Initialize Extended Server API For: \n Developer id: " + DEVELOPER_ID + "\n API Key: " + API_KEY + "\n Sandbox Mode: " + IS_SANDBOX);
            ZooZExtendedServerAPI.init(DEVELOPER_ID, API_KEY, IS_SANDBOX);

            LOGGER.info(" Get Transaction Details By Transaction ID: ");
            /**
             * GET_TRANSACTION_ID should be the unique identifier on ZooZ’s servers of the requested transaction.
             */
            String GET_TRANSACTION_ID = "xxxxxxxxxxxxxx";
            GetTransactionDetailsByTransactionID getTransactionDetailsByTransactionIDSample = new GetTransactionDetailsByTransactionID(GET_TRANSACTION_ID);
            JSONObject result_getTransactionDetailsByTransactionIDSample = getTransactionDetailsByTransactionIDSample.postToZooZ();
            getTransactionDetailsByTransactionIDSample.writeToLogger();

            LOGGER.info(" Get Transaction Details By Payer Email: ");
            /**
             * E_MAIL should be the payer e-mail you want to query.
             * START_DATE_EMAIL will filter the results by dates.
             * END_DATE_EMAIL will filter the results by dates, fill null if you want it filltered until certain date.
             */
            String E_MAIL = " jdoe@domain.com";
            String START_DATE_EMAIL = "yyyy-MM-dd";
            String END_DATE_EMAIL = "yyyy-MM-dd";
            GetTransactionDetailsByPayerEmail getTransactionDetailsByPayerEmailSample = new GetTransactionDetailsByPayerEmail(E_MAIL, START_DATE_EMAIL, END_DATE_EMAIL);
            JSONObject result_getTransactionDetailsByPayerEmailSample = getTransactionDetailsByPayerEmailSample.postToZooZ();
            getTransactionDetailsByPayerEmailSample.writeToLogger();

            LOGGER.info(" Get Transaction Details By Parameters: ");
            /**
             *  INVOICE_NUMBER should be the invoice number you want to query.
             */
            String INVOICE_NUMBER = "xxxxxxxxxxxxxx";
            InvoiceQuery invoiceQuerySample = new InvoiceQuery(INVOICE_NUMBER);
            /**
             * START_DATE_CBD will filter the results by dates.
             * END_DATE_CBD will filter the results by dates.
             */
            String START_DATE_CBD = "yyyy-MM-dd";
            String END_DATE_CBD = "yyyy-MM-dd";
            ClosedBetweenDatesQuery closedBetweenDatesQuerySample = new ClosedBetweenDatesQuery(START_DATE_CBD, END_DATE_CBD);
            /**
             * PAYMENT_STATUS - Please select one of the following:
             *  [Pending / TPCPending / AuthorizationProcess / Succeed / Failed / UserReject / POSCanceled  / Timeout]
             * START_DATE_SAD will filter the results by dates.
             * END_DATE_SAD will filter the results by dates.
             */
            String PAYMENT_STATUS = "xxxxxxxxxxxxxx";
            String START_DATE_SAD = "yyyy-MM-dd";
            String END_DATE_SAD = "yyyy-MM-dd";
            StatusAndDatesQuery statusAndDatesQuerySample = new StatusAndDatesQuery(PAYMENT_STATUS, START_DATE_SAD, END_DATE_SAD);
            /**
             *  CUSTOMER_LOGIN_ID - The customer login Id on the merchant's app
             */
            String CUSTOMER_LOGIN_ID = "xxxxxxxxxxxxxx";
            CustomerLoginIDQuery customerLoginIDQuerySample = new CustomerLoginIDQuery(CUSTOMER_LOGIN_ID);
            /**
             *  CUSTOMER_LOGIN_NAME - The customer login name on the merchant's app
             */
            String CUSTOMER_LOGIN_NAME = "xxxxxxxxxxxxxx";
            CustomerLoginNameQuery customerLoginNameQuerySample = new CustomerLoginNameQuery(CUSTOMER_LOGIN_NAME);

            /**
             * QUERY should be one of the queries:
             *  [invoiceQuerySample / closedBetweenDatesQuerySample / statusAndDatesQuerySample / customerLoginIDQuerySample / customerLoginNameQuerySample]
             */
            QueryType QUERY = invoiceQuerySample;
            GetTransactionDetailsByParameters getTransactionDetailsByTransactionByParametersSample = new GetTransactionDetailsByParameters(QUERY);
            JSONObject result_getTransactionDetailsByTransactionByParametersSample = getTransactionDetailsByTransactionByParametersSample.postToZooZ();
            getTransactionDetailsByTransactionByParametersSample.writeToLogger();

            LOGGER.info(" Commit Transaction: ");
            /**
             * COMMIT_TRANSACTION_ID should be the transaction id you want to commit.
             * COMMIT_AMOUNT should be the amount you want to partially commit, sending null will do a full commit.
             * COMMIT_INCOIVE If you wish to commit the transaction on a different invoice, edit createInvoiceSample method.
             */
            String COMMIT_TRANSACTION_ID = "xxxxxxxxxxxxxx";
            Double COMMIT_AMOUNT = new Double(50.50);
            Invoice COMMIT_INVOICE = createSampleInvoice("12345", "Invoice Add. Detail");
            CommitTransaction commitTransactionSample = new CommitTransaction(COMMIT_TRANSACTION_ID, COMMIT_AMOUNT, COMMIT_INVOICE);
            JSONObject result_commitTransactionSample = commitTransactionSample.postToZooZ();
            commitTransactionSample.writeToLogger();

            LOGGER.info(" Refund Transaction: ");
            /**
             * REF_TRANSACTION_ID  should be the transaction id you want to refund.
             * REF_AMOUNT should be the amount you want to partially refund, sending null will do a full refund.
             */
            String REF_TRANSACTION_ID = "xxxxxxxxxxxxxx";
            Double REF_AMOUNT = new Double(50.50);
            RefundTransaction refundTransactionSample = new RefundTransaction(REF_TRANSACTION_ID, REF_AMOUNT);
            JSONObject result_refundTransactionSample = refundTransactionSample.postToZooZ();
            refundTransactionSample.writeToLogger();

            LOGGER.info(" Cancel Transaction: ");
            /**
             *  CANCEL_TRANSACTION_ID = should be the transaction id you want to cancel.
             */
            String CANCEL_TRANSACTION_ID = "xxxxxxxxxxxxxx";
            CancelTransaction cancelTransactionSample = new CancelTransaction(CANCEL_TRANSACTION_ID);
            JSONObject result_cancelTransactionSample = cancelTransactionSample.postToZooZ();
            cancelTransactionSample.writeToLogger();

            LOGGER.info(" Get Subscription Details: ");
            /**
             * GET_SUBSCRIPTION_ID should be the unique identifier on ZooZ’s servers of the requested subscription you want to get.
             */
            String GET_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
            GetSubscriptionDetails getSubscriptionDetailsSample = new GetSubscriptionDetails(GET_SUBSCRIPTION_ID);
            JSONObject result_getSubscriptionDetailsSample = getSubscriptionDetailsSample.postToZooZ();
            getSubscriptionDetailsSample.writeToLogger();

            LOGGER.info(" Check Subscription: ");
            /**
             * CHECK_SUBSCRIPTION_ID should be the unique identifier on ZooZ’s servers of the requested subscription you want to check.
             */
            String CHECK_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
            CheckSubscription checkSubscriptionSample = new CheckSubscription(CHECK_SUBSCRIPTION_ID);
            JSONObject result_checkSubscriptionSample = checkSubscriptionSample.postToZooZ();
            checkSubscriptionSample.writeToLogger();

            LOGGER.info(" Cancel Subscription: ");
            /**
             * CANCEL_SUBSCRIPTION_ID should be the unique identifier on ZooZ’s servers of the requested subscription you want to cancel.
             */
            String CANCEL_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
            CancelSubscription cancelSubscriptionSample = new CancelSubscription(CANCEL_SUBSCRIPTION_ID);
            JSONObject result_cancelSubscriptionSample = cancelSubscriptionSample.postToZooZ();
            cancelSubscriptionSample.writeToLogger();

            LOGGER.info(" Get Transaction Details By User ID: ");
            /**
             * USER_ID should be a unique user ID number.
             * START_DATE_ID will filter the results by dates
             * END_DATE_ID will filter the results by dates.
             */
            String USER_ID = "xxxxxxxxxxxxxx";
            String START_DATE_ID = "yyyy-MM-dd";
            String END_DATE_ID = "yyyy-MM-dd";
            GetTransactionDetailsByUserID getTransactionDetailsByUserIDSample = new GetTransactionDetailsByUserID(USER_ID, START_DATE_ID, END_DATE_ID);
            JSONObject result_transactionDetailsByUserID = getTransactionDetailsByUserIDSample.postToZooZ();
            getTransactionDetailsByUserIDSample.writeToLogger();


        } catch (ZooZException e) {
            LOGGER.severe(e.getMessage());
        } catch (NullPointerException e) {
            LOGGER.severe(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Problems with creating the log files");
        }
        finally {
            fileTxt.close();
        }

    }

    /**
     * Setting up the ZooZ Logger.
     *
     * @throws java.io.IOException - there are IO problems opening the files.
     */
    public static void ZooZSettingUpLogger() throws IOException {

        Logger.getLogger(ZooZExtendedServerAPISample.class.getName());
        LOGGER.setLevel(Level.INFO);
        fileTxt = new FileHandler("ZooZExtendedServerAPI.txt");

        fileTxt.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fileTxt);

    }

    /**
     * @param number               If you wish to commit the transaction on a different
     *                             invoice.
     * @param setAdditionalDetails Invoice additional details as registered by the merchant
     * @return an Invoice object.
     */
    public static Invoice createSampleInvoice(String number, String setAdditionalDetails) {
        Invoice invoice = new Invoice();
        invoice.setNumber(number);
        invoice.setAdditionalDetails(setAdditionalDetails);

        List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
        InvoiceItem invoiceItem1 = new InvoiceItem("T-Shirt A", "10001", 1, 10.99, 1.99, "Size - L");
        invoiceItems.add(invoiceItem1);
        InvoiceItem invoiceItem2 = new InvoiceItem("T-Shirt B", "10002", 1, 11.99, 2.19, "Size - XL");
        invoiceItems.add(invoiceItem2);
        invoice.setInvoiceItems(invoiceItems);
        return invoice;
    }

}


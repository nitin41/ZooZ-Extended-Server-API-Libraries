using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CommandClasses;
using AbstractClasses;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System.Diagnostics;
using ZooZQueryTypes;

namespace ExtendedSeverAPI
{
    /// <summary>
    /// ZooZ Extended Server API Sample.
    /// <item>
    /// <term> Author</term>
    /// <description> Roy Keynan </description>
    /// </item>
    /// </summary>
    /// <remarks>
    /// ZooZ Extended server API allows you to extend your control and manageability of your payment transactions.
    /// With the Extended Server API you can:
    /// 1. Defer payments - approve your users purchases after they authorize ZooZ transactions
    /// 2. Get full details on transactions by transaction ID or payee email address.
    /// 3. Refund transactions Prior to initiating any forms of integration, it will be necessary for you to sign up for ZooZ at http://www.ZooZ.com.
    /// 
    /// The purpose of this guide is to provide you with all necessary information for integration, however if you have
    /// any questions, please feel free to contact us at support@ZooZ.com </remarks>
    class ZooZExtendedServerAPISample
    {

        private readonly static string DEVELOPER_ID = "developer@email.here";
        private readonly static string API_KEY = "api-key.here";
        private readonly static bool IS_SANDBOX = true;

        static void Main(string[] args)
        {
            
            Trace.TraceInformation("Initialize Extended Server API For: Developer id: " + DEVELOPER_ID + " API Key: " + API_KEY + " Sandbox Mode: " + IS_SANDBOX);
            ZooZExtendedServerAPI.init(DEVELOPER_ID, API_KEY, IS_SANDBOX);
            Trace.TraceInformation("// -------------------------------");

            Trace.TraceInformation(" Get Transaction Details By Transaction ID: ");
            //
            // GET_TRANSACTION_ID should be the unique identifier on ZooZÕs servers of the requested transaction.
            //
            String GET_TRANSACTION_ID = "xxxxxxxxxxxxxx";
            GetTransactionDetailsByTransactionID getTransactionDetailsByTransactionIDSample = new GetTransactionDetailsByTransactionID(GET_TRANSACTION_ID);
            JObject result_getTransactionDetailsByTransactionIDSample = getTransactionDetailsByTransactionIDSample.postToZooZ();
            getTransactionDetailsByTransactionIDSample.writeToLogger();

            Trace.TraceInformation(" Get Transaction Details By Payer Email: ");
            //
            // E_MAIL should be the payer e-mail you want to query.
            // START_DATE_EMAIL will filter the results by dates, please follow the format "yyyy,MM,dd".
            // END_DATE_EMAIL will filter the results by dates, please follow the format "yyyy,MM,dd" , fill null if you want it filtered until certain date.
            //
            String E_MAIL = " jdoe@domain.com";
            DateTime? START_DATE_EMAIL = new DateTime(2014, 03, 01);
            DateTime? END_DATE_EMAIL = new DateTime(2014, 03, 05);
            GetTransactionDetailsByPayerEmail getTransactionDetailsByPayerEmailSample = new GetTransactionDetailsByPayerEmail(E_MAIL, START_DATE_EMAIL, END_DATE_EMAIL);
            JObject result_getTransactionDetailsByPayerEmailSample = getTransactionDetailsByPayerEmailSample.postToZooZ();
            getTransactionDetailsByPayerEmailSample.writeToLogger();

            Trace.TraceInformation(" Get Transaction Details By Parameters: ");
            //
            //  INVOICE_NUMBER should be the invoice number you want to query.
            //
            String INVOICE_NUMBER = "xxxxxxxxxxxxxx";
            InvoiceNumberQuery invoiceQuerySample = new InvoiceNumberQuery(INVOICE_NUMBER);
            //
            // START_DATE_CBD will filter the results by dates, please follow the format "yyyy-MM-dd".
            // END_DATE_CBD will filter the results by dates, please follow the format "yyyy-MM-dd".
            //
            DateTime START_DATE_CBD = new DateTime(2014, 03, 01);
            DateTime END_DATE_CBD = new DateTime(2014, 03, 05);
            ClosedBetweenDatesQuery closedBetweenDatesQuerySample = new ClosedBetweenDatesQuery(START_DATE_CBD, END_DATE_CBD);
            //
            // PAYMENT_STATUS - Please select one of the following:
            //  [Pending / TPCPending / AuthorizationProcess / Succeed / Failed / UserReject / POSCanceled  / Timeout]
            // START_DATE_SAD will filter the results by dates, please follow the format "yyyy-MM-dd".
            // END_DATE_SAD will filter the results by dates, please follow the format "yyyy-MM-dd".
            //
            String PAYMENT_STATUS = "xxxxxxxxxxxxxx";
            DateTime START_DATE_SAD = new DateTime(2014, 03, 01);
            DateTime END_DATE_SAD = new DateTime(2014, 03, 05);
            StatusAndDatesQuery statusAndDatesQuerySample = new StatusAndDatesQuery(PAYMENT_STATUS, START_DATE_SAD, END_DATE_SAD);
            //
            //  CUSTOMER_LOGIN_ID - The customer login Id on the merchant's app
            //
            String CUSTOMER_LOGIN_ID = "xxxxxxxxxxxxxx";
            CustomerLoginIDQuery customerLoginIDQuerySample = new CustomerLoginIDQuery(CUSTOMER_LOGIN_ID);
            //
            //  CUSTOMER_LOGIN_NAME - The customer login name on the merchant's app
            //
            String CUSTOMER_LOGIN_NAME = "xxxxxxxxxxxxxx";
            CustomerLoginNameQuery customerLoginNameQuerySample = new CustomerLoginNameQuery(CUSTOMER_LOGIN_NAME);

            //
            // QUERY should be one of the queries:
            //  [invoiceQuerySample / closedBetweenDatesQuerySample / statusAndDatesQuerySample / customerLoginIDQuerySample / customerLoginNameQuerySample]
            //
            QueryType QUERY = invoiceQuerySample;
            GetTransactionDetailsByParameters getTransactionDetailsByTransactionByParametersSample = new GetTransactionDetailsByParameters(QUERY);
            JObject result_getTransactionDetailsByTransactionByParametersSample = getTransactionDetailsByTransactionByParametersSample.postToZooZ();
            getTransactionDetailsByTransactionByParametersSample.writeToLogger();

            Trace.TraceInformation(" Commit Transaction: ");
            //
            // COMMIT_TRANSACTION_ID should be the transaction id you want to commit.
            // COMMIT_AMOUNT should be the amount you want to partially commit, sending null will do a full commit.
            // COMMIT_INCOIVE If you wish to commit the transaction on a different invoice.
            //
            String COMMIT_TRANSACTION_ID = "xxxxxxxxxxxxxx";
            Double COMMIT_AMOUNT = 50.50;
            JObject COMMIT_INVOICE = null;
            CommitTransaction commitTransactionSample = new CommitTransaction(COMMIT_TRANSACTION_ID, COMMIT_AMOUNT, COMMIT_INVOICE);
            JObject result_commitTransactionSample = commitTransactionSample.postToZooZ();
            commitTransactionSample.writeToLogger();

            Trace.TraceInformation(" Refund Transaction: ");
            //
            // REF_TRANSACTION_ID  should be the transaction id you want to refund.
            // REF_AMOUNT should be the amount you want to partially refund, sending null will do a full refund.
            //
            String REF_TRANSACTION_ID = "xxxxxxxxxxxxxx";
            Double REF_AMOUNT = 50.50;
            RefundTransaction refundTransactionSample = new RefundTransaction(REF_TRANSACTION_ID, REF_AMOUNT);
            JObject result_refundTransactionSample = refundTransactionSample.postToZooZ();
            refundTransactionSample.writeToLogger();

            Trace.TraceInformation(" Cancel Transaction: ");
            //
            //  CANCEL_TRANSACTION_ID = should be the transaction id you want to cancel.
            //
            String CANCEL_TRANSACTION_ID = "xxxxxxxxxxxxxx";
            CancelTransaction cancelTransactionSample = new CancelTransaction(CANCEL_TRANSACTION_ID);
            JObject result_cancelTransactionSample = cancelTransactionSample.postToZooZ();
            cancelTransactionSample.writeToLogger();

            Trace.TraceInformation(" Get Subscription Details: ");
            //
            // GET_SUBSCRIPTION_ID should be the unique identifier on ZooZÕs servers of the requested subscription you want to get.
            //
            String GET_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
            GetSubscriptionDetails getSubscriptionDetailsSample = new GetSubscriptionDetails(GET_SUBSCRIPTION_ID);
            JObject result_getSubscriptionDetailsSample = getSubscriptionDetailsSample.postToZooZ();
            getSubscriptionDetailsSample.writeToLogger();

            Trace.TraceInformation(" Check Subscription: ");
            //
            // CHECK_SUBSCRIPTION_ID should be the unique identifier on ZooZÕs servers of the requested subscription you want to check.
            //
            String CHECK_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
            CheckSubscription checkSubscriptionSample = new CheckSubscription(CHECK_SUBSCRIPTION_ID);
            JObject result_checkSubscriptionSample = checkSubscriptionSample.postToZooZ();
            checkSubscriptionSample.writeToLogger();

            Trace.TraceInformation(" Cancel Subscription: ");
            //
            // CANCEL_SUBSCRIPTION_ID should be the unique identifier on ZooZÕs servers of the requested subscription you want to cancel.
            //
            String CANCEL_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
            CancelSubscription cancelSubscriptionSample = new CancelSubscription(CANCEL_SUBSCRIPTION_ID);
            JObject result_cancelSubscriptionSample = cancelSubscriptionSample.postToZooZ();
            cancelSubscriptionSample.writeToLogger();

            Trace.TraceInformation(" Get Transaction Details By User ID: ");
            //
            // USER_ID should be a unique user ID number.
            // START_DATE_ID will filter the results by dates
            // END_DATE_ID will filter the results by dates, please follow the format "yyyy-MM-dd".
            //
            String USER_ID = "xxxxxxxxxxxxxx";
            DateTime START_DATE_ID = new DateTime(2014, 03, 01);
            DateTime END_DATE_ID = new DateTime(2014, 03, 05);
            GetTransactionDetailsByUserId getTransactionDetailsByUserIDSample = new GetTransactionDetailsByUserId(USER_ID, START_DATE_ID, END_DATE_ID);
            JObject result_transactionDetailsByUserID = getTransactionDetailsByUserIDSample.postToZooZ();
            getTransactionDetailsByUserIDSample.writeToLogger();

        }
    }
}

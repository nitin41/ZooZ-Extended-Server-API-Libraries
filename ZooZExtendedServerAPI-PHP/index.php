<?php

/**
 * Developer: Roy Keynan
 * <p/>
 * ZooZ Extended server API allows you to extend your control and manageability of your payment
 * transactions.
 * With the Extended Server API you can:
 * 1. Defer payments -??approve your usersÕ purchases after they authorize ZooZ transactions
 * 2. Get full details on transactions by transaction ID or payee email address.
 * 3. Refund transactions Prior to initiating any forms of integration,
 * it will be necessary for you to sign up for ZooZ at http://www.ZooZ.com
 * The purpose of this guide is to provide you with all necessary information for integration, however if you have
 * any questions, please feel free to contact us at support@ZooZ.com
 */

require_once './ZooZExtendedServerAPI.php';
require_once './lib/JsonPrint.php';
require_once './lib/KLogger.php';

require_once './CommandClasses/GetTransactionDetailsByTransactionID.php';
require_once './CommandClasses/CancelTransaction.php';
require_once './CommandClasses/CommitTransaction.php';
require_once './CommandClasses/RefundTransaction.php';
require_once './CommandClasses/GetSubscriptionDetails.php';
require_once './CommandClasses/CheckSubscription.php';
require_once './CommandClasses/CancelSubscription.php';
require_once './CommandClasses/GetTransactionDetailsByPayerEmail.php';
require_once './CommandClasses/GetTransactionDetailsByParameters.php';
require_once './CommandClasses/GetTransactionDetailsByUserID.php';

require_once './ZooZQueries/InvoiceQuery.php';
require_once './ZooZQueries/ClosedBetweenDatesQuery.php';
require_once './ZooZQueries/StatusAndDatesQuery.php';
require_once './ZooZQueries/CustomerLoginIDQuery.php';
require_once './ZooZQueries/CustomerLoginNameQuery.php';

$zoozDeveloperId = "developer@email.here";
$zoozAPIKey = "api-key.here";
$zoozIsSandbox = True;

$zoozLog = KLogger::instance('/var/log/');

$zoozExtendedServerAPI = new ZooZExtendedServerAPI($zoozDeveloperId,$zoozAPIKey,$zoozIsSandbox);
$zoozLog->logInfo("---------------------------------------");

$zoozLog->logInfo("Get Transaction Details By Transaction ID:");
/**
 * GET_TRANSACTION_ID should be the unique identifier on ZooZÕs servers of the requested transaction.
 */
$GET_TRANSACTION_ID = "xxxxxxxxxxxxxx";
$getTransactionByIdSample = new GetTransactionDetailsByTransactionID($GET_TRANSACTION_ID);
$result_getTransactionByIdSample = $getTransactionByIdSample->response();
displayTransactions($zoozLog,$result_getTransactionByIdSample);

$zoozLog->logInfo("Get Transaction Details By Payer Email:");
/**
 * E_MAIL should be the payer e-mail you want to query.
 * START_DATE_EMAIL will filter the results by dates.
 * END_DATE_EMAIL will filter the results by dates, fill null if you want it filltered until certain date.
 */
$E_MAIL = " jdoe@domain.com";
$START_DATE_EMAIL = "yyyy-MM-dd";
$END_DATE_EMAIL = "yyyy-MM-dd";
$getTransactionDetailsByPayerEmailSample = new GetTransactionDetailsByPayerEmail($E_MAIL, $START_DATE_EMAIL, $END_DATE_EMAIL);
$result_getTransactionDetailsByPayerEmailSample = $getTransactionDetailsByPayerEmailSample->response();
displayTransactions($zoozLog,$result_getTransactionDetailsByPayerEmailSample);

$zoozLog->logInfo("Get Transaction Details By Parameters:");
/**
 *  INVOICE_NUMBER should be the invoice number you want to query.
 */
$INVOICE_NUMBER = "12345";
$invoiceQuerySample = new InvoiceQuery($INVOICE_NUMBER);
/**
 * START_DATE_CBD will filter the results by dates.
 * END_DATE_CBD will filter the results by dates.
 */
$START_DATE_CBD = "yyyy-MM-dd";
$END_DATE_CBD = "yyyy-MM-dd";
$closedBetweenDatesSample = new ClosedBetweenDatesQuery($START_DATE_CBD, $END_DATE_CBD);
/**
 * PAYMENT_STATUS - Please select one of the following:
 *  [Pending / TPCPending / AuthorizationProcess / Succeed / Failed / UserReject / POSCanceled  / Timeout]
 * START_DATE_SAD will filter the results by dates.
 * END_DATE_SAD will filter the results by dates.
 */
$PAYMENT_STATUS = "xxxxxxxxxxxxxx";
$START_DATE_SAD = "yyyy-MM-dd";
$END_DATE_SAD = "yyyy-MM-dd";
$statusAndDatesQuerySample = new StatusAndDatesQuery($PAYMENT_STATUS,$START_DATE_SAD, $END_DATE_SAD);
/**
 *  CUSTOMER_LOGIN_ID - The customer login Id on the merchant's app
 */
$CUSTOMER_LOGIN_ID = "xxxxxxxxxxxxxx";
$customerLoginIDQuerySample = new CustomerLoginIDQuery($CUSTOMER_LOGIN_ID);
/**
 *  CUSTOMER_LOGIN_NAME - The customer login name on the merchant's app
 */
$CUSTOMER_LOGIN_NAME = "xxxxxxxxxxxxxx";
$customerLoginNameQuerySample = new CustomerLoginNameQuery($CUSTOMER_LOGIN_NAME);
/**
 * QUERY should be one of the queries:
 *  [invoiceQuerySample / closedBetweenDatesQuerySample / statusAndDatesQuerySample / customerLoginIDQuerySample / customerLoginNameQuerySample]
 */
$QUERY = $invoiceQuerySample;
$getTransactionDetailsByParametersSample = new GetTransactionDetailsByParameters($QUERY);
$result_getTransactionDetailsByParametersSample = $getTransactionDetailsByParametersSample->response();
displayTransactions($zoozLog,$result_getTransactionDetailsByParametersSample);

$zoozLog->logInfo("Commit Transaction:");
/**
 * COMMIT_TRANSACTION_ID should be the transaction id you want to commit.
 * COMMIT_AMOUNT should be the amount you want to partially commit, sending null will do a full commit.
 * COMMIT_INCOIVE If you wish to commit the transaction on a different invoice, edit createInvoiceSample method.
 */
$COMMIT_TRANSACTION_ID = "xxxxxxxxxxxxxx";
$COMMIT_AMOUNT = 50.50;
$COMMIT_INVOICE_JSON = NULL;
$commitTransactionSample= new CommitTransaction($COMMIT_TRANSACTION_ID,$COMMIT_AMOUNT,$COMMIT_INVOICE_JSON);
$result_commitTransactionSample = $commitTransactionSample->response();
displayTransactions($zoozLog,$result_commitTransactionSample);

$zoozLog->logInfo("Refund Transaction:");
/**
 * REF_TRANSACTION_ID  should be the transaction id you want to refund.
 * REF_AMOUNT should be the amount you want to partially refund, sending null will do a full refund.
 */
$REF_TRANSACTION_ID = "xxxxxxxxxxxxxx";
$REF_AMOUNT = 50.50;
$refundTransactionSample= new RefundTransaction($REF_TRANSACTION_ID,$REF_AMOUNT);
$result_refundTransactionSample= $refundTransactionSample->response();
displayTransactions($zoozLog,$result_refundTransactionSample);

$zoozLog->logInfo("Cancel Transaction:");
/**
 *  CANCEL_TRANSACTION_ID = should be the transaction id you want to cancel.
 */
$CANCEL_TRANSACTION_ID = "xxxxxxxxxxxxxx";
$cancelTransactionSample= new CancelTransaction($CANCEL_TRANSACTION_ID);
$refund_cancelTransactionSample= $cancelTransactionSample->response();
displayTransactions($zoozLog,$refund_cancelTransactionSample);

$zoozLog->logInfo("Get Subscription Details:");
/**
 * GET_SUBSCRIPTION_ID should be the unique identifier on ZooZÕs servers of the requested subscription you want to get.
 */
$GET_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
$getSubscriptionDetailsSample = new GetSubscriptionDetails($GET_SUBSCRIPTION_ID);
$result_getSubscriptionDetailsSample = $getSubscriptionDetailsSample->response();
displayTransactions($zoozLog,$result_getSubscriptionDetailsSample);

$zoozLog->logInfo("Cancel Subscription:");
/**
 * CHECK_SUBSCRIPTION_ID should be the unique identifier on ZooZÕs servers of the requested subscription you want to check.
 */
$CHECK_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
$cancelSubscriptionSample = new CancelSubscription($CHECK_SUBSCRIPTION_ID);
$result_cancelSubscriptionSample = $cancelSubscriptionSample->response();
displayTransactions($zoozLog,$result_cancelSubscriptionSample);

$zoozLog->logInfo("Check Subscription:");
/**
 * CANCEL_SUBSCRIPTION_ID should be the unique identifier on ZooZÕs servers of the requested subscription you want to cancel.
 */
$CANCEL_SUBSCRIPTION_ID = "xxxxxxxxxxxxxx";
$checkSubscriptionSample = new CheckSubscription($CANCEL_SUBSCRIPTION_ID);
$result_checkSubscriptionSample = $checkSubscriptionSample->response();
displayTransactions($zoozLog,$result_checkSubscriptionSample);

$zoozLog->logInfo("Get Transaction Details By User ID:");
/**
 * USER_ID should be a unique user ID number.
 * START_DATE_ID will filter the results by dates
 * END_DATE_ID will filter the results by dates.
 */
$USER_ID = "xxxxxxxxxxxxxx";
$START_DATE_ID = "yyyy-MM-dd";
$END_DATE_ID = "yyyy-MM-dd";
$getTransactionDetailsByUserIDSample = new GetTransactionDetailsByUserID($USER_ID,$START_DATE_ID, $END_DATE_ID);
$result_getTransactionDetailsByUserIDSample = $getTransactionDetailsByUserIDSample->response();
displayTransactions($zoozLog,$result_getTransactionDetailsByUserIDSample);
# coding=utf-8
import json
import logging
from zooz.Commands.CancelSubscription import CancelSubscription
from zooz.Commands.CancelTransaction import CancelTransaction
from zooz.Commands.CheckSubscription import CheckSubscription
from zooz.Commands.CommitTransaction import CommitTransaction
from zooz.Commands.GetSubscriptionDetails import GetSubscriptionDetails
from zooz.Commands.GetTransactionDetailsByParameters import GetTransactionDetailsByParameters
from zooz.Commands.GetTransactionDetailsByPayerEmail import GetTransactionDetailsByPayerEmail
from zooz.Commands.GetTransactionDetailsByTransactionID import GetTransactionDetailsByTransactionID
from zooz.Commands.GetTransactionDetailsByUserID import GetTransactionDetailsByUserID
from zooz.Commands.ZooZQueries import *
from zooz.Commands.RefundTransaction import RefundTransaction
from zooz.ZooZExtendedServerAPI import ZooZExtendedServerAPI

__author__ = 'Roy Keynan'

'''
 ZooZ Extended server API allows you to extend your control and manageability of your payment
 transactions.
 With the Extended Server API you can:
 1. Defer payments -­‐approve your users’ purchases after they authorize ZooZ transactions
 2. Get full details on transactions by transaction ID or payee email address.
 3. Refund transactions Prior to initiating any forms of integration,
 it will be necessary for you to sign up for ZooZ at http://www.ZooZ.com
 The purpose of this guide is to provide you with all necessary information for integration, however if you have
 any questions, please feel free to contact us at support@ZooZ.com
'''

logging.basicConfig(level=logging.INFO)
ZooZ_Logger = logging.getLogger(__name__)

DEVELOPER_ID = "developer@email.here"
API_KEY = "api-key.here"
IS_SANDBOX = True

def main():
    handler = logging.FileHandler('ZooZExtendedServerAPI.log')
    handler.setLevel(logging.INFO)
    FORMAT = '%(asctime)-15s %(clientip)s %(user)-8s %(message)s'
    logging.basicConfig(format=FORMAT)
    handler.setFormatter(FORMAT)
    ZooZ_Logger.addHandler(handler)

    zooz_extended_server_api = ZooZExtendedServerAPI(DEVELOPER_ID, API_KEY, IS_SANDBOX)
    ZooZ_Logger.info("---------------------------------------")

    ZooZ_Logger.info("Get Transaction Details By Transaction ID:")

    # get_transaction_id should be the unique identifier on ZooZ’s servers of the requested transaction.
    get_transaction_id = "xxxxxxxxxxxxxx"
    get_transaction_by_id_sample = GetTransactionDetailsByTransactionID(get_transaction_id)
    result_get_transaction_by_id_sample = get_transaction_by_id_sample.response(zooz_extended_server_api)
    display_transactions(result_get_transaction_by_id_sample)

    ZooZ_Logger.info("Get Transaction Details By Payer Email:")

    # e_mail should be the payer e-mail you want to query.
    # start_date_email will filter the results by dates.
    # end_date_email will filter the results by dates, fill null if you want it filltered until certain date.
    e_mail = " jdoe@domain.com";
    start_date_email = "yyyy-mm-dd";
    end_date_email = "yyyy-mm-dd";
    get_transaction_by_payee_email_sample = GetTransactionDetailsByPayerEmail(e_mail, start_date_email, end_date_email)
    result_get_transaction_by_payee_email_sample = get_transaction_by_payee_email_sample.response(zooz_extended_server_api)
    display_transactions(result_get_transaction_by_payee_email_sample)

    ZooZ_Logger.info("Get Transaction Details By Parameters:")
    #  invoice_number should be the invoice number you want to query.
    invoice_number = "12345";
    invoice_number_query = InvoiceNumberQuery(invoice_number)

    # start_date_cbd will filter the results by dates.
    # end_date_cbd will filter the results by dates.
    start_date_cbd = "yyyy-mm-dd";
    end_date_cbd = "yyyy-mm-dd";
    closed_by_dates_query = ClosedBetweenDatesQuery(start_date_cbd, end_date_cbd)

    # payment_status - please select one of the following:
    #  [pending / tpcpending / authorizationprocess / succeed / failed / userreject / poscanceled  / timeout]
    # start_date_sad will filter the results by dates.
    # end_date_sad will filter the results by dates.
    payment_status = "xxxxxxxxxxxxxx";
    start_date_sad = "yyyy-mm-dd";
    end_date_sad = "yyyy-mm-dd";
    status_and_dates_query = StatusAndDatesQuery(payment_status, start_date_sad, end_date_sad)

    #  customer_login_id - the customer login id on the merchant's app
    customer_login_id = "xxxxxxxxxxxxxx";
    customer_login_id_query = CustomerLoginIDQuery(customer_login_id)

    #  customer_login_name - the customer login name on the merchant's app
    customer_login_name = "xxxxxxxxxxxxxx";
    customer_login_name_query = CustomerLoginNameQuery(customer_login_name)

    # query should be one of the queries:
    #  [invoicequerysample / closedbetweendatesquerysample / statusanddatesquerysample / customerloginidquerysample / customerloginnamequerysample]
    query = invoice_number_query
    get_transaction_details_by_parameters_sample = GetTransactionDetailsByParameters(query)
    result_get_transaction_details_by_parameters_sample = get_transaction_details_by_parameters_sample.response(zooz_extended_server_api)
    display_transactions(result_get_transaction_details_by_parameters_sample)

    ZooZ_Logger.info("Commit Transaction:")
    # commit_transaction_id should be the transaction id you want to commit.
    # commit_amount should be the amount you want to partially commit, sending null will do a full commit.
    # commit_incoive if you wish to commit the transaction on a different invoice.
    commit_transaction_id = "xxxxxxxxxxxxxx";
    commit_amount = 50.50
    commit_invoice = None;
    commit_transaction_sample = CommitTransaction(commit_transaction_id, commit_amount, commit_invoice)
    result_commit_transaction_sample = commit_transaction_sample.response(zooz_extended_server_api)
    display_transactions(result_commit_transaction_sample)

    ZooZ_Logger.info("Refund Transaction:")
    # ref_transaction_id  should be the transaction id you want to refund.
    # ref_amount should be the amount you want to partially refund, sending null will do a full refund.
    ref_transaction_id = "xxxxxxxxxxxxxx";
    ref_amount = 50.50
    refund_transaction_sample = RefundTransaction(ref_transaction_id, ref_amount)
    result_refund_transaction_sample = refund_transaction_sample.response(zooz_extended_server_api)
    display_transactions(result_refund_transaction_sample)

    ZooZ_Logger.info("Cancel Transaction:")
    #  cancel_transaction_id = should be the transaction id you want to cancel.
    cancel_transaction_id = "xxxxxxxxxxxxxx";
    cancel_transaction_sample = CancelTransaction(cancel_transaction_id)
    result_cancel_transaction_sample = cancel_transaction_sample.response(zooz_extended_server_api)
    display_transactions(result_cancel_transaction_sample)

    ZooZ_Logger.info("Get SubscriptionDetails:")
    # get_subscription_id should be the unique identifier on zooz’s servers of the requested subscription you want to get.
    get_subscription_id = "xxxxxxxxxxxxxx";
    get_subscription_details_sample = GetSubscriptionDetails(get_subscription_id)
    result_get_subscription_details_sample = get_subscription_details_sample.response(zooz_extended_server_api)
    display_transactions(result_get_subscription_details_sample)

    ZooZ_Logger.info("Check Subscription:")
    # check_subscription_id should be the unique identifier on zooz’s servers of the requested subscription you want to check.
    check_subscription_id = "xxxxxxxxxxxxxx";
    check_subscription_sample = CheckSubscription(check_subscription_id)
    result_check_subscription_sample = check_subscription_sample.response(zooz_extended_server_api)
    display_transactions(result_check_subscription_sample)

    ZooZ_Logger.info("Cancel Subscription:")
    # cancel_subscription_id should be the unique identifier on zooz’s servers of the requested subscription you want to cancel.
    cancel_subscription_id = "xxxxxxxxxxxxxx";
    cancel_subscription_sample = CancelSubscription(cancel_subscription_id)
    result_cancel_subscription_sample = cancel_subscription_sample.response(zooz_extended_server_api)
    display_transactions(result_cancel_subscription_sample)

    ZooZ_Logger.info("Get Transaction Details By User ID:")
    # user_id should be a unique user id number.
    # start_date_id will filter the results by dates
    # end_date_id will filter the results by dates.
    #/
    user_id = "xxxxxxxxxxxxxx";
    start_date_id = "yyyy-mm-dd";
    end_date_id = "yyyy-mm-dd";
    get_transaction_details_by_user_id_sample = GetTransactionDetailsByUserID(user_id, start_date_id, end_date_id)
    result_get_transaction_details_by_user_id_sample = get_transaction_details_by_user_id_sample.response(zooz_extended_server_api)
    display_transactions(result_get_transaction_details_by_user_id_sample)


def display_transactions(to_display):
    if to_display is None or to_display["ResponseStatus"] != 0:
        ZooZ_Logger.error(json.dumps(to_display, indent=2, separators=(',', ': ')))
    else:
        ZooZ_Logger.info(json.dumps(to_display, indent=2, separators=(',', ': ')))
    ZooZ_Logger.info("---------------------------------------")


if __name__ == "__main__":
    main()
from zooz.QueryType import QueryType, add_dates_to_plist

__author__ = 'Roy Keynan'


class InvoiceNumberQuery(QueryType):
    """
    Get all the transactions details regarding the same invoice number.
    """
    def __init__(self, invoice_number):
        """
        :param invoice_number:  The invoice number of the requested transaction
        """
        super(InvoiceNumberQuery, self).__init__()
        self.invoice_number = invoice_number

    def add_query_parameters_to_the_list(self, plist):
        plist["invoiceNumber"] = self.invoice_number

    def get_query_type(self):
        return "invoiceNumber"


class ClosedBetweenDatesQuery(QueryType):
    """
    Get all the transactions details between specific dates
    """
    def __init__(self, start_date, end_date):
        """
        :param start_date:  The earliest date for the requested transactions
        :param end_date:    The latest date for the requested transactions
        """
        super(ClosedBetweenDatesQuery, self).__init__()
        self.start_date = start_date
        self.end_date = end_date

    def add_query_parameters_to_the_list(self, plist):
        add_dates_to_plist(plist, self.start_date, self.end_date)

    def get_query_type(self):
        return "closedBetweenDates"


class StatusAndDatesQuery(QueryType):
    """
    Get all the transactions details between specific dates followed by a specific status
    """
    def __init__(self, payment_status, start_date, end_date):
        """
        :param payment_status:  can be one of the following: Pending, TPCPending, AuthorizationProcess, Succeed, Failed,
                                UserReject, POSCanceled , Timeout
        :param start_date:      The earliest date for the requested transactions
        :param end_date:        The latest date for the requested transactions
        """
        super(StatusAndDatesQuery, self).__init__()
        self.payment_status = payment_status
        self.start_date = start_date
        self.end_date = end_date

    def add_query_parameters_to_the_list(self, plist):
        plist["paymentStatus"] = self.payment_status
        add_dates_to_plist(plist, self.start_date, self.end_date)

    def get_query_type(self):
        return "statusAndDates"


class CustomerLoginIDQuery(QueryType):
    """
    Get all the transactions details followed by a specific customer login id
    """
    def __init__(self, customer_login_id):
        """
        :param customer_login_id: The customer login Id on the merchant's app
        """
        super(CustomerLoginIDQuery, self).__init__()
        self.customer_login_id = customer_login_id

    def add_query_parameters_to_the_list(self, plist):
        plist["customerLoginID"] = self.customer_login_id

    def get_query_type(self):
        return "customerLoginID"


class CustomerLoginNameQuery(QueryType):
    """
    Get all the transactions details followed by a specific customer login name
    """
    def __init__(self, customer_login_name):
        """
        :param customer_login_name:The customer login name on the merchant's app
        """
        super(CustomerLoginNameQuery, self).__init__()
        self._customer_login_name = customer_login_name

    def add_query_parameters_to_the_list(self, plist):
        plist["customerLoginName"] = self._customer_login_name

    def get_query_type(self):
        return "customerLoginName"
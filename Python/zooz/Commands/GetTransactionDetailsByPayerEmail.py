# coding=utf-8
from zooz.AbstractClasses import AbstractCommand

__author__ = 'Roy Keynan'


class GetTransactionDetailsByPayerEmail(AbstractCommand):
    """
    Getting transactions details by payer’s email address API allows you to retrieve transaction
    full details and transaction status before or/and after commit or refund for all transactions
    associated with the above email. This call does not change the transaction state.
    """

    def __init__(self, email, from_date, to_date):
        """

        :param email:       Payer email address.
        :param from_date:   Filter the results by dates. Expected format: yyyy-mm-dd
        :param to_date:     Filter the results by dates. Expected format: yyyy-mm-dd
        """
        super(GetTransactionDetailsByPayerEmail, self).__init__()
        self.list["email"] = email
        if from_date is not None:
            self.list["fromDate"] = from_date
            if to_date is not None:
                self.list["toDate"] = to_date

    def get_command_name(self):
        return "getTransactionDetailsByPayerEmail"



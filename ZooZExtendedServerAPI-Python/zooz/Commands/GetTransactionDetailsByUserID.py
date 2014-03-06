# coding=utf-8
from zooz.AbstractClasses import AbstractCommand

__author__ = 'Roy Keynan'


class GetTransactionDetailsByUserID(AbstractCommand):
    """
     Getting transactions details by user ID API allows you to retrieve transaction full details and
     transaction status before or/and after commit or refund for all transactions associated with
     the above email. This call does not change the transaction state.
     """

    def __init__(self, user_id, from_date, to_date):
        """
        :param user_id:     Unique identifier on ZooZ’s servers for the user who processed this transaction.
                            This value is returned in the Callback API response.
        :param from_date:   Filter the results by dates. Expected format: yyyy-mm-dd
        :param to_date:     Filter the results by dates. Expected format: yyyy-mm-dd
        """
        super(GetTransactionDetailsByUserID, self).__init__()
        self.list["userId"] = user_id
        if from_date is not None:
            self.list["fromDate"] = from_date
        if to_date is not None:
            self.list["toDate"] = to_date

    def get_command_name(self):
        return "getTransactionDetailsByUserId";
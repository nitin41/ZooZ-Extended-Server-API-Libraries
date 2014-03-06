# coding=utf-8
from zooz.AbstractClasses import *

__author__ = 'Roy Keynan'


class GetTransactionDetailsByTransactionID(AbstractTransactionIDCommand):
    """
    Get transaction details with the transaction ID API.	This allows you to retrieve complete
    transaction details and transaction statuses before and/or after commit or refund. This call
    does not change the transaction state.
    """

    def __init__(self, transaction_id):
        """
        :param transaction_id:  Transaction ID is a unique identifier on ZooZ’s servers as you get from the response
                            whether it’s from ZooZ’s SDK response or callback response, after the user authorized
                            or commit a transaction.
        """
        super(GetTransactionDetailsByTransactionID, self).__init__(transaction_id)

    def get_command_name(self):
        return "getTransactionDetails"
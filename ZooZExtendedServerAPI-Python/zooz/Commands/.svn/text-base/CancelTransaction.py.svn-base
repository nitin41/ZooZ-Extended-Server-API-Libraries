# coding=utf-8
from zooz.AbstractClasses import AbstractTransactionIDCommand

__author__ = 'Roy Keynan'


class CancelTransaction(AbstractTransactionIDCommand):
    """
    The cancel transaction API is enabled only if your app is set to deferred payments.
    It allows you to cancel a specific pending transaction.
    """

    def __init__(self, transaction_id):
        """
        :param transaction_id:  Transaction ID is unique identifier on ZooZ’s servers as you get from the response
                                whether it’s from ZooZ’s SDK response or callback response, after the user authorized or
                                commit a transaction.
        """
        super(CancelTransaction, self).__init__(transaction_id)

    def get_command_name(self):
        return "cancelPayment"
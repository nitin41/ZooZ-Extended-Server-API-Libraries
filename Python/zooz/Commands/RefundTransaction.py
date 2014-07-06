# coding=utf-8
from zooz.AbstractClasses import AbstractCommand, AbstractTransactionIDCommand

__author__ = 'Roy Keynan'


class RefundTransaction(AbstractTransactionIDCommand):
    """
    The Refund Transaction API allows you to refund a specific transaction.
    You can call this API up to 60 days after the transaction was executed.
    In case you want to do partial refund, send the amount parameter.

    :param transaction_id:  Transaction ID is unique identifier on ZooZ’s servers as you get from the response
                            whether it’s from ZooZ’s SDK response or callback response, after the user authorized or
                            commit a transaction.
    :param amount:          Optional value.
                            If you wish to refund the transaction on a smaller amount than the original amount the
                            transaction	was authorized.		Expected format: dddddd.cc (e.g. 105.15)
    """
    def __init__(self, transaction_id, amount):
        """
        :param transaction_id:  Transaction ID is unique identifier on ZooZ’s servers as you get from the response
                                whether it’s from ZooZ’s SDK response or callback response, after the user authorized or
                                commit a transaction.
        :param amount:          Optional value.
                                If you wish to refund the transaction on a smaller amount than the original amount the
                                transaction was authorized, or if you were approved by ZooZ to commit the transaction on

        """
        super(RefundTransaction, self).__init__(transaction_id)

        if amount is not None:
            self.list["amount"] = amount

    def get_command_name(self):
        return "refundTransaction"
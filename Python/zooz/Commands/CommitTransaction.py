# coding=utf-8
from zooz.AbstractClasses import AbstractTransactionIDCommand

__author__ = 'Roy Keynan'


class CommitTransaction(AbstractTransactionIDCommand):
    """
    Commit Transaction API – If your app is set to the deferred payments setting (App setting in
    the ZooZ portal) then the flow of payments is separated to the following two phases:
    1. User authorizes the transaction with ZooZ (Over Mobile Device)
    2. Your server approves the purchase
    This flexibility allows merchants to review the user order before making the actual charge.
    Using ZooZ developer’s portal or using command API, you can choose to commit or
    ignore that transaction after the user authorizes it.
    You can call this API up to 14 days after the transaction	was	authorized.
    In case you want to do partial commit, send the amount parameter.
    """
    def __init__(self, transaction_id, amount, invoice):
        """
        :param transaction_id:  Transaction ID is unique identifier on ZooZ’s servers as you get from the response
                                whether it’s from ZooZ’s SDK response or callback response, after the user authorized or
                                commit a transaction.
        :param amount:          Optional value. If you wish to commit the transaction on a smaller amount than the
                                original amount the transaction was authorized, or if you were approved by ZooZ to
                                commit the transaction on higher amount than the original amount.
                                Expected format: dddddd.cc	(e.g.	105.15)
        :param invoice:         If you wish to commit the transaction on a different invoice.
        """
        super(CommitTransaction, self).__init__(transaction_id)

        if amount is not None:
            self.list["amount"] = amount
        if invoice is not None:
            self.list["invoice"] = invoice

    def get_command_name(self):
        return "commitTransaction"

# coding=utf-8
from zooz.AbstractClasses import AbstractCommand

__author__ = 'Roy Keynan'


class GetTransactionDetailsByParameters(AbstractCommand):
    """
    Getting transactions details by parameters API allows you to retrieve transaction full details
    and transaction status before or/and after commit or refund for all transactions
    corresponding to the selected parameters. This call does not change the transaction state.
    """

    def __init__(self, query):
        """
        :param query: One of the queries available in the API
        """
        super(GetTransactionDetailsByParameters, self).__init__()
        query.add_parameters_to_the_list(self.list)

    def get_command_name(self):
        return "getTransactionDetailsByParameters"
__author__ = 'Roy Keynan'

import abc
from abc import ABCMeta


def add_dates_to_plist(plist, start_date, end_date):
    if start_date is not None:
        plist["startDate"] = start_date
        if end_date is not None:
            plist["endDate"] = end_date


class QueryType(object):
    __metaclass__ = ABCMeta

    @abc.abstractmethod
    def __init__(self):
        pass

    @abc.abstractmethod
    def get_query_type(self):
        pass

    @abc.abstractmethod
    def add_query_parameters_to_the_list(self, plist):
        pass

    def add_parameters_to_the_list(self, plist):
        plist["queryType"] = self.get_query_type()
        self.add_query_parameters_to_the_list(plist)


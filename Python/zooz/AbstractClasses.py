__author__ = 'Roy Keynan'

import abc
from abc import ABCMeta

VERSION_NUMBER = "1.1.3"


def backoff_retry(retries=1, delay=1, backoff=2):
    if backoff <= 1:
        raise ValueError("backoff must be 0 or greater")
    if retries < 0:
        raise ValueError("retries must be greater than 0")
    if delay <= 0:
        raise ValueError("delay must be greater than 0")

    def wrapper(f):
        def retry_f(*args, **kwargs):
            try:
                return f(*args, **kwargs)  # first attempt
            except ValueError, e:
                for t in xrange(retries):
                    try:
                        wait = delay * backoff * (t + 1)
                        #   time.sleep(wait)
                        return f(*args, **kwargs)  # new attempt
                    except ValueError:
                        pass
                print ("")

        return retry_f

    return wrapper


class AbstractCommand(object):
    __metaclass__ = ABCMeta

    @abc.abstractmethod
    def __init__(self):
        self._list = {'cmd': self.get_command_name(),
                      'ver': VERSION_NUMBER
        }


    @abc.abstractmethod
    def get_command_name(self):
        pass


    @property
    def list(self):
        return self._list

    @backoff_retry(retries=5)
    def post(self, payload, zooz_extended_server_api):
        """
            Add authentication headers to the request
        """

        headers = {
            'ZooZDeveloperId': zooz_extended_server_api.developer_id,
            'ZooZServerAPIKey': zooz_extended_server_api.api_key,
        }

        response = zooz_extended_server_api.requests.post(zooz_extended_server_api.get_url, data=payload,
                                                          headers=headers)
        try:
            return response.json()
        except ValueError, e:
            from ZooZExtendedServerAPISample import ZooZ_Logger
            ZooZ_Logger.error(response._content)

    def response(self, zooz_extended_server_api):
        return AbstractCommand.post(self, self.list, zooz_extended_server_api)


class AbstractTransactionIDCommand(AbstractCommand):
    __metaclass__ = ABCMeta

    @abc.abstractmethod
    def __init__(self, transaction_id):
        super(AbstractTransactionIDCommand, self).__init__()
        self.list["transactionID"] = transaction_id

    @abc.abstractmethod
    def get_command_name(self):
        pass


class AbstractSubscriptionIDCommand(AbstractCommand):
    __metaclass__ = ABCMeta

    @abc.abstractmethod
    def __init__(self, subscription_id):
        super(AbstractSubscriptionIDCommand, self).__init__()
        self.list["subscriptionID"] = subscription_id

    @abc.abstractmethod
    def get_command_name(self):
        pass



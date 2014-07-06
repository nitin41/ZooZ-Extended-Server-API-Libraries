__author__ = 'Roy Keynan'

import requests

_zooz_urls = {
    'production': 'https://app.zooz.com/',
    'sandbox': 'https://sandbox.zooz.co/',
}


class ZooZExtendedServerAPI:
    """
    Initialize the ZooZExtendedServerAPI to enable communication with your account
    """

    def __init__(self, developer_id, api_key, is_sandbox):
        """
        :param developer_id: Developer email as entered in ZooZ Developer portal.
        :param api_key: ZooZ Server API Key assigned to you upon registration. Can be found on the "Account" section of the ZooZ Developer Portal.
        :param is_sandbox: True to use sandbox environment, false to use live environment.
        """
        self._developer_id = developer_id
        self._api_key = api_key
        self._is_sandbox = is_sandbox
        self._requests = requests.Session()

    @property
    def developer_id(self):
        return self._developer_id

    @property
    def api_key(self):
        return self._api_key

    @property
    def zooz_server(self):
        return self._is_sandbox

    @property
    def requests(self):
        return self._requests


    @property
    def get_url(self):
        if self.zooz_server:
            return _zooz_urls['sandbox'] + 'mobile/ExtendedServerAPI'
        else:
            return _zooz_urls['production'] + 'mobile/ExtendedServerAPI'

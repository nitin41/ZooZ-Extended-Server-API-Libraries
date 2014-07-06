# coding=utf-8
from zooz.AbstractClasses import AbstractSubscriptionIDCommand

__author__ = 'Roy Keynan'


class CancelSubscription(AbstractSubscriptionIDCommand):
    """
    This allows you to cancel a subscription.
    The subscription status will be “CanceledByMerchant”.
    """
    def __init__(self, subscription_id):
        """
        :param subscription_id: Subscription ID is a unique identifier on ZooZ’s servers as you get from the response
                                whether it’s from ZooZ’s SDK response or callback response, after the user subscribes
                                to your plan.
        """
        super(CancelSubscription, self).__init__(subscription_id)

    def get_command_name(self):
        return "cancelSubscription"

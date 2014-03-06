<?php

require_once './AbstractClasses/AbstractSubscriptionIDCommand.php';
require_once './AbstractClasses/EnumCommands.php';

/**
 * Cancel Subscription API
 * 
 * This allows you to cancel a subscription.
 * The subscription status will be “CanceledByMerchant”.
 */
class CancelSubscription extends AbstractSubscriptionIDCommand{
    /**
     * 
     * @param String $subscriptionId - Subscription ID is a unique identifier 
     *     on ZooZ’s servers as you get from the response whether it’s from 
     *     ZooZ’s SDK response or callback response, after the user subscribes 
     *     to your plan.
     */
    function __construct($subscriptionId) {
        parent::__construct($subscriptionId);
    }

    protected function getCommand() {
        return EnumCommands::cancelSubscription;
    }

}

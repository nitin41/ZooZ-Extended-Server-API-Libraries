<?php

require_once './AbstractClasses/AbstractSubscriptionIDCommand.php';
require_once './AbstractClasses/EnumCommands.php';

/**
 * Get Subscription Details API
 * 
 * Get subscription details with the subscription ID API. This allows you to retrieve complete
 * subscription details and its transactions details. This call does not change the subscription
 * state.
 */
class GetSubscriptionDetails extends AbstractSubscriptionIDCommand {
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
        return EnumCommands::getSubscriptionDetails;
    }

}

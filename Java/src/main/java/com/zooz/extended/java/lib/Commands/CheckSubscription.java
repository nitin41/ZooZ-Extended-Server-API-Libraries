package com.zooz.extended.java.lib.Commands;

import com.zooz.extended.java.lib.AbstractClasses.AbstractSubscriptionIDCommand;
import com.zooz.extended.java.lib.model.enums.Commands;

/**
 * Check Subscription API
 * <p/>
 * This allows you to check a subscription’s status.
 */
public class CheckSubscription extends AbstractSubscriptionIDCommand {
    /**
     * @param subscriptionId - Subscription	ID is a unique identifier on ZooZ’s	servers	as you get from the response
     *                       whether it’s from ZooZ’s SDK response or callback response, after the user subscribes to your plan.
     */
    public CheckSubscription(String subscriptionId) {
        super(subscriptionId);
    }

    @Override
    protected Commands getCommand() {
        return Commands.checkSubscription;
    }

}

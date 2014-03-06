package com.zooz.extended.java.lib.Commands;

import com.zooz.extended.java.lib.AbstractClasses.AbstractSubscriptionIDCommand;
import com.zooz.extended.java.lib.model.enums.Commands;

/**
 * Get Subscription Details API
 * <p/>
 * Get subscription details with the subscription ID API. This allows you to retrieve complete
 * subscription details and its transactions details. This call does not change the subscription
 * state.
 */
public class GetSubscriptionDetails extends AbstractSubscriptionIDCommand {
    /**
     * @param subscriptionID -  Subscription ID is a unique identifier on ZooZ’s servers as you get from the response
     *                       whether it’s from ZooZ’s SDK response or callback response, after the user subscribes
     *                       to your plan.
     */
    public GetSubscriptionDetails(String subscriptionID) {
        super(subscriptionID);
    }

    @Override
    protected Commands getCommand() {
        return Commands.getSubscriptionDetails;
    }

}

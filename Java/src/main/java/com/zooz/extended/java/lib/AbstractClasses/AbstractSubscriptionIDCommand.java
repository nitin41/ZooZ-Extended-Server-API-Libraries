package com.zooz.extended.java.lib.AbstractClasses;

import com.zooz.extended.java.lib.exception.ZooZException;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

/**
 * Developer: Roy Keynan
 */
public abstract class AbstractSubscriptionIDCommand extends AbstractCommand {

    protected AbstractSubscriptionIDCommand(String subscriptionId) {
        super();
        nvps.add("subscriptionID", subscriptionId);
    }
}

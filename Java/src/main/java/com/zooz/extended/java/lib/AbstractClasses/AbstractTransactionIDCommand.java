package com.zooz.extended.java.lib.AbstractClasses;

/**
 * Developer: Roy Keynan
 */
public abstract class AbstractTransactionIDCommand extends AbstractCommand {


    protected AbstractTransactionIDCommand(String transactionID) {
        super();
        nvps.add("transactionID", transactionID);
    }
}

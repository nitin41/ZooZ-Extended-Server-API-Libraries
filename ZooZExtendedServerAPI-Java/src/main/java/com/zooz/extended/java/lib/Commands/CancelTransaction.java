package com.zooz.extended.java.lib.Commands;

import com.zooz.extended.java.lib.AbstractClasses.AbstractTransactionIDCommand;
import com.zooz.extended.java.lib.model.enums.Commands;

/**
 * Cancel Transaction API
 * <p/>
 * The cancel transaction API is enabled only if your app is set to deferred payments.
 * It allows you to cancel a specific pending transaction.
 */
public class CancelTransaction extends AbstractTransactionIDCommand {
    /**
     * @param transactionID -   Transaction ID is unique identifier on ZooZ’s servers as you get from the
     *                      response whether it’s from ZooZ’s SDK response or callback response,
     *                      after the user authorized or commit a transaction.
     */
    public CancelTransaction(String transactionID) {
        super(transactionID);
    }

    @Override
    protected Commands getCommand() {
        return Commands.cancelPayment;
    }

}

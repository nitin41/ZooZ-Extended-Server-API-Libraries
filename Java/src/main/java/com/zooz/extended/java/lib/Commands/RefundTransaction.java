package com.zooz.extended.java.lib.Commands;

import com.zooz.extended.java.lib.AbstractClasses.AbstractTransactionIDCommand;
import com.zooz.extended.java.lib.model.enums.Commands;

/**
 * Refund Transaction API
 * <p/>
 * The Refund Transaction API allows you to refund a specific transaction.
 * You can call this API up to 60 days after the transaction was executed.
 * In case you want to do partial refund, send the amount parameter.
 */
public class RefundTransaction extends AbstractTransactionIDCommand {
    /**
     * @param transactionID -   Transaction ID is unique identifier on ZooZ’s servers as you get from the response
     *                      whether it’s from ZooZ’s SDK response or callback response, after the user authorized
     *                      or commit a transaction.
     * @param amount        -   Optional value. If you wish to refund the transaction on a smaller amount than the
     *                      original amount the	transaction	was authorized.	Expected format: dddddd.cc (e.g. 105.15)
     */
    public RefundTransaction(String transactionID, Double amount) {
        super(transactionID);

        if (amount != null) {
            nvps.add("amount", String.valueOf(amount));
        }
    }

    @Override
    protected Commands getCommand() {
        return Commands.refundTransaction;
    }
}

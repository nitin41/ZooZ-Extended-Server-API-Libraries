package com.zooz.extended.java.lib.Commands;

import com.zooz.extended.java.lib.AbstractClasses.AbstractTransactionIDCommand;
import com.zooz.extended.java.lib.model.enums.Commands;

/**
 * Get Transaction Details By Transaction ID API
 * <p/>
 * Get transaction details with the transaction ID API.	This allows you to retrieve complete
 * transaction details and transaction statuses before and/or after commit or refund. This call
 * does not change the transaction state.
 */

public class GetTransactionDetailsByTransactionID extends AbstractTransactionIDCommand {

    /**
     * @param transactionID: Transaction ID is a unique identifier on ZooZ’s servers as you get from the response
     *                       whether it’s from ZooZ’s SDK response or callback response, after the user authorized or
     *                       commit a transaction.
     */
    public GetTransactionDetailsByTransactionID(String transactionID) {
        super(transactionID);
    }

    @Override
    protected Commands getCommand() {
        return Commands.getTransactionDetails;
    }
}

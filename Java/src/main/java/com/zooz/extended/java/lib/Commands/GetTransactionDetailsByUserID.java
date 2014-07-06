package com.zooz.extended.java.lib.Commands;

import com.zooz.extended.java.lib.AbstractClasses.AbstractCommand;
import com.zooz.extended.java.lib.model.enums.Commands;
import com.zooz.extended.java.lib.utils.ZooZStringUtils;

import java.util.Date;

/**
 * Get Transaction Details By User ID API
 * <p/>
 * Getting transactions details by user ID API allows you to retrieve transaction full details and
 * transaction status before or/and after commit or refund for all transactions associated with
 * the above email. This call does not change the transaction state.
 */
public class GetTransactionDetailsByUserID extends AbstractCommand {

    /**
     * @param userId   -    Unique identifier on ZooZÕs servers for the user who processed this transaction.
     *                 This value is returned in the Callback API response.
     * @param fromDate -    Filter the results by dates.
     * @param toDate   -    Filter the results by dates.
     */
    public GetTransactionDetailsByUserID(String userId, String fromDate, String toDate) {
        super();
        nvps.add("userId", userId);

        if (fromDate != null) {
            nvps.add("fromDate", fromDate);
            if (toDate != null) {
                nvps.add("toDate", toDate);
            }
        }

    }

    @Override
    protected Commands getCommand() {
        return Commands.getTransactionDetailsByUserId;
    }
}

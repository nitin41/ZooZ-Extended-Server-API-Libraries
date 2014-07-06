package com.zooz.extended.java.lib.Commands;

import com.zooz.extended.java.lib.AbstractClasses.AbstractCommand;
import com.zooz.extended.java.lib.model.enums.Commands;
import com.zooz.extended.java.lib.utils.ZooZStringUtils;

import java.util.Date;

/**
 * Get Transaction Details By Payer Email API
 * <p/>
 * Getting transactions details by payer’s email address API allows you to retrieve transaction
 * full details and transaction status before or/and after commit or refund for all transactions
 * associated with the above email. This call does not change the transaction state.
 */
public class GetTransactionDetailsByPayerEmail extends AbstractCommand {

    /**
     * @param email    Payer email address.
     * @param fromDate Filter the results by dates. Expected format: yyyy-mm-dd
     * @param toDate   Filter the results by dates. Expected format: yyyy-mm-dd
     */
    public GetTransactionDetailsByPayerEmail(String email, String fromDate, String toDate) {
        super();
        nvps.add("email", email);

        if (fromDate != null) {
            nvps.add("fromDate", fromDate);
            if (toDate != null) {
                nvps.add("toDate", toDate);
            }
        }
    }

    @Override
    protected Commands getCommand() {
        return Commands.getTransactionDetailsByPayerEmail;
    }

}

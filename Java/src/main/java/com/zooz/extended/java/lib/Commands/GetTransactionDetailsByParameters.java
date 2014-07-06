package com.zooz.extended.java.lib.Commands;

import com.zooz.extended.java.lib.AbstractClasses.AbstractCommand;
import com.zooz.extended.java.lib.model.QueryType;
import com.zooz.extended.java.lib.model.enums.Commands;

/**
 * GetTransaction Details By Parameters API
 * <p/>
 * Getting transactions details by parameters API allows you to retrieve transaction full details
 * and transaction status before or/and after commit or refund for all transactions
 * corresponding to the selected parameters. This call does not change the transaction state.
 */
public class GetTransactionDetailsByParameters extends AbstractCommand {

    /**
     * @param requestedQuery - One of the queries available in the API
     */
    public GetTransactionDetailsByParameters(QueryType requestedQuery) {
        super();
        requestedQuery.addParametersToNVP(nvps);
    }


    @Override
    protected Commands getCommand() {
        return Commands.getTransactionDetailsByParameters;
    }
}
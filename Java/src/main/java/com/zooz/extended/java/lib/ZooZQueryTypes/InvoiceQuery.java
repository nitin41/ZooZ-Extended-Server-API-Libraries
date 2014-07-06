package com.zooz.extended.java.lib.ZooZQueryTypes;

import com.zooz.extended.java.lib.model.NVPs;
import com.zooz.extended.java.lib.model.QueryType;
import com.zooz.extended.java.lib.model.enums.Queries;

/**
 * Get all the transaction details regarding the same invoice number.
 */
public class InvoiceQuery extends QueryType{

    private String invoiceNumber;

    /**
     * @param invoiceNumber -  The invoice number of the requested transaction.
     */
    public InvoiceQuery(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    protected void addQueryParametersToNVP(NVPs nvps) {
        nvps.add("invoiceNumber",invoiceNumber);
    }

    @Override
    protected Queries getQuery() {
        return Queries.invoiceNumber;
    }
}

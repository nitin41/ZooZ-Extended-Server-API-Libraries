package com.zooz.extended.java.lib.ZooZQueryTypes;

import com.zooz.extended.java.lib.model.NVPs;
import com.zooz.extended.java.lib.model.QueryType;
import com.zooz.extended.java.lib.model.enums.Queries;

/**
 * Get all the transactions details followed by a specific customer login id
 */
public class CustomerLoginIDQuery extends QueryType {

    private String customerLoginID;

    /**
     * @param customerLoginID: The customer login Id on the merchant's app
     */
    public CustomerLoginIDQuery(String customerLoginID) {
        this.customerLoginID = customerLoginID;
    }

    @Override
    protected void addQueryParametersToNVP(NVPs nvps) {
        nvps.add("customerLoginID", customerLoginID);
    }

    @Override
    protected Queries getQuery() {
        return Queries.customerLoginID;
    }
}

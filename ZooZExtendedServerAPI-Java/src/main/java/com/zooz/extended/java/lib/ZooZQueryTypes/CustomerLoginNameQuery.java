package com.zooz.extended.java.lib.ZooZQueryTypes;

import com.zooz.extended.java.lib.model.NVPs;
import com.zooz.extended.java.lib.model.QueryType;
import com.zooz.extended.java.lib.model.enums.Queries;

/**
 * Get all the transactions details followed by a specific customer login name
 */
public class CustomerLoginNameQuery extends QueryType {

    private String customerLoginName;

    /**
     * @param customerLoginName: The customer login name on the merchant's app
     */
    public CustomerLoginNameQuery(String customerLoginName) {
        this.customerLoginName = customerLoginName;
    }

    @Override
    protected void addQueryParametersToNVP(NVPs nvps) {
        nvps.add("customerLoginName", customerLoginName);
    }

    @Override
    protected Queries getQuery() {
        return Queries.customerLoginName;
    }
}

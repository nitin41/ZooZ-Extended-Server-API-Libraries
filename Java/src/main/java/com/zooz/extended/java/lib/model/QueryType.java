package com.zooz.extended.java.lib.model;

import com.zooz.extended.java.lib.model.enums.Queries;
import com.zooz.extended.java.lib.utils.ZooZStringUtils;

/**
 * Developer: Roy Keynan
 */
public abstract class QueryType {

    public void addParametersToNVP(NVPs nvps) {
        nvps.add("queryType", getQuery().name());
        addQueryParametersToNVP(nvps);
    }

    protected abstract void addQueryParametersToNVP(NVPs nvps);

    protected abstract Queries getQuery();

    protected void addDatesToNVP(NVPs nvps, String startDate, String endDate) {
        nvps.add("startDate", startDate);
        nvps.add("endDate", endDate);
    }
}

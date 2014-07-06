package com.zooz.extended.java.lib.ZooZQueryTypes;

import com.zooz.extended.java.lib.model.NVPs;
import com.zooz.extended.java.lib.model.QueryType;
import com.zooz.extended.java.lib.model.enums.Queries;

import java.util.Date;

/**
 * Get all the transactions details between specific dates followed by a specific status
 */
public class StatusAndDatesQuery extends QueryType {
    private String paymentStatus;
    private String startDate, endDate;

    /**
     * @param paymentStatus:    can be one of the following: Pending, TPCPending, AuthorizationProcess, Succeed, Failed,
     *                          UserReject, POSCanceled , Timeout
     * @param startDate:        The earliest date for the requested transactions
     * @param endDate:          The latest date for the requested transactions
     */
    public StatusAndDatesQuery(String paymentStatus, String startDate, String endDate) {
        this.paymentStatus = paymentStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    protected void addQueryParametersToNVP(NVPs nvps) {
        nvps.add("paymentStatus", paymentStatus);
        addDatesToNVP(nvps, startDate, endDate);
    }

    @Override
    protected Queries getQuery() {
        return Queries.statusAndDates;
    }
}

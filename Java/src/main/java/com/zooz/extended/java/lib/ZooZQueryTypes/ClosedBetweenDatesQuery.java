package com.zooz.extended.java.lib.ZooZQueryTypes;

import com.zooz.extended.java.lib.model.NVPs;
import com.zooz.extended.java.lib.model.QueryType;
import com.zooz.extended.java.lib.model.enums.Queries;
import java.util.Date;

/**
 * Get all the transactions details between specific dates.
 */
public class ClosedBetweenDatesQuery extends QueryType{
    private String startDate, endDate;

    /**
     *@param startDate:  Filter the results by dates.
     *@param endDate:    Filter the results by dates.
     */
    public ClosedBetweenDatesQuery(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    protected void addQueryParametersToNVP(NVPs nvps) {
        addDatesToNVP(nvps,startDate,endDate);
    }

    @Override
    protected Queries getQuery() {
        return Queries.closedBetweenDates;
    }
}

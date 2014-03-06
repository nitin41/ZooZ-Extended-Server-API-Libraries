<?php

require_once 'lib/QueryType.php';
require_once './AbstractClasses/EnumQueries.php';

/**
 * Get all the transactions details between specific dates followed by a specific status
 */
class StatusAndDatesQuery extends QueryType{

    private $paymentStatus, $startDate, $endDate;
    /**
     *
     * @param String $paymentStatus - can be one of the following: Pending,
     *  TPCPending, AuthorizationProcess, Succeed, Failed, UserReject,
     *  POSCanceled , Timeout.
     * @param String $startDate - Filter the results by dates
     * @param String $endDate - Filter the results by dates
     */
    function __construct($paymentStatus, $startDate ,$endDate) {
        parent::__construct();
        $this->paymentStatus = $paymentStatus;
        $this->startDate = $startDate;
        $this->endDate = $endDate;
    }

    protected function addQueryParametersToTheList($nvps) {
       $nvps->add("paymentStatus", $this->paymentStatus);
       parent::addDatesToNvps($nvps,$this->startDate,$this->endDate);
    }

    protected function getQueryType() {
        return EnumQueries::statusAndDates;
    }

}

<?php

require_once 'lib/QueryType.php';
require_once './AbstractClasses/EnumQueries.php';

/**
 * Get all the transactions details between specific dates.
 */
class ClosedBetweenDatesQuery extends QueryType{

    private $startDate, $endDate;
    /**
     *
     * @param String $startDate - Filter the results by dates
     * @param String $endDate - Filter the results by dates
     */
    function __construct($startDate,$endDate) {
        parent::__construct();
        $this->startDate = $startDate;
        $this->endDate = $endDate;
    }

    protected function addQueryParametersToTheList($nvps) {
        parent::addDatesToNvps($nvps,$this->startDate,$this->endDate);
    }

    protected function getQueryType() {
        return EnumQueries::closedBetweenDates;

    }
}

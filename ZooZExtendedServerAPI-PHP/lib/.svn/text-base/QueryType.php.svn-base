<?php

require_once 'lib/nvps.php';
/**
 * Description of QueryType
 *
 * @author Roy Keynan
 */
abstract class QueryType {

    function __construct() {
    }

    abstract protected function getQueryType();

    abstract protected function addQueryParametersToTheList($nvps);

    public function addParametersToTheNvps($nvps){
        $nvps->add("queryType", $this->getQueryType());
        $this->addQueryParametersToTheList($nvps);
    }

    protected function addDatesToNvps($nvps , $startDate , $endDate){
        if ($startDate != NULL){
            $nvps->add("startDate", $startDate);
            if($endDate != NULL){
                $nvps->add("endDate", $endDate);
            }
        }
    }
}

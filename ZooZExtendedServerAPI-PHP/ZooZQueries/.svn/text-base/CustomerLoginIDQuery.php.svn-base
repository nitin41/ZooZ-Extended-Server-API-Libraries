<?php

require_once 'lib/QueryType.php';
require_once './AbstractClasses/EnumQueries.php';

/**
 * Get all the transactions details followed by a specific customer login id
 */
class CustomerLoginIDQuery extends QueryType{
    
    private $customerLoginID;
    /**
     * 
     * @param String $customerLoginID - The customer login Id on 
     *  the merchant's app
     */
    function __construct($customerLoginID) {
        parent::__construct();
        $this->customerLoginID = $customerLoginID;
    }
    
    protected function addQueryParametersToTheList($nvps) {
        $nvps->add("customerLoginID", $this->customerLoginID);
    }

    protected function getQueryType() {
        return EnumQueries::customerLoginID;
    }
}

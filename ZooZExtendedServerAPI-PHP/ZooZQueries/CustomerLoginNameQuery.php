<?php

require_once 'lib/QueryType.php';
require_once './AbstractClasses/EnumQueries.php';

/**
 * Get all the transactions details followed by a specific customer login name
 */
class CustomerLoginNameQuery extends QueryType{
    
    private $customerLoginName;
    /**
     * 
     * @param type $customerLoginName - The customer login name on 
     *  the merchant's app
     */
    function __construct($customerLoginName) {
        parent::__construct();
        $this->customerLoginName = $customerLoginName;
    }
    
    protected function addQueryParametersToTheList($nvps) {
        $nvps->add("customerLoginName", $this->customerLoginName);
    }

    protected function getQueryType() {
        return EnumQueries::customerLoginName;
    }
}

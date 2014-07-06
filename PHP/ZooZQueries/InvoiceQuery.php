<?php

require_once 'lib/QueryType.php';
require_once './AbstractClasses/EnumQueries.php';

/**
 * Get all the transaction details regarding the same invoice number.
 */
class InvoiceQuery extends QueryType{
    
    private $invoiceNumber;
    /**
     * 
     * @param string $invoiceNumber - The invoice number of the requested 
     *  transaction.
     */
    function __construct($invoiceNumber) {
        parent::__construct();
        $this->invoiceNumber = $invoiceNumber;
    }
    
    protected function addQueryParametersToTheList($nvps) {
        $nvps->add("invoiceNumber", $this->invoiceNumber);
    }

    protected function getQueryType() {
        return EnumQueries::invoiceNumber;
    }
}

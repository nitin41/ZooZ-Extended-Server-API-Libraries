<?php

require_once './AbstractClasses/AbstractTransactionIDCommand.php';
require_once './AbstractClasses/EnumCommands.php';

/**
 * Get Transaction Details By Transaction ID API 
 *
 * Get transaction details with the transaction ID API.	This allows you to retrieve complete
 * transaction details and transaction statuses before and/or after commit or refund. This call
 * does not change the transaction state.
 */
class GetTransactionDetailsByTransactionID extends AbstractTransactionIDCommand {
    /**
     * 
     * @param String $transactionID - Transaction ID is unique identifier on
     *     ZooZ’s servers as you get from the response whether it’s from ZooZ’s
     *     SDK response or callback response, after the user authorized or 
     *     commit a transaction.
     */
    function __construct($transactionID) {
        parent::__construct($transactionID);
    }
    
    protected function getCommand() {
        return EnumCommands::getTransactionDetails;
        
    }

//put your code here
}

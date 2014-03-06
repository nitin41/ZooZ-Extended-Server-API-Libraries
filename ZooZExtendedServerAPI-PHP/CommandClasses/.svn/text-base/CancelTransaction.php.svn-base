<?php

require_once './AbstractClasses/AbstractTransactionIDCommand.php';
require_once './AbstractClasses/EnumCommands.php';

/**
 * Cancel Transaction API
 * 
 * The cancel transaction API is enabled only if your app is set
 * to deferred payments. 
 * It allows you to cancel a specific pending transaction.
 */
class CancelTransaction extends AbstractTransactionIDCommand{
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
        return EnumCommands::cancelPayment;       
    }

}

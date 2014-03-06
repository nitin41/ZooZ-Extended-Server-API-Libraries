<?php

require_once './AbstractClasses/AbstractTransactionIDCommand.php';
require_once './AbstractClasses/EnumCommands.php';

/**
 * Refund Transaction API
 * 
 * The Refund Transaction API allows you to refund a specific transaction.
 * You can call this API up to 60 days after the transaction was executed.
 * In case you want to do partial refund, send the amount parameter.
 */
class RefundTransaction extends AbstractTransactionIDCommand{
   /**
    * 
    * @param String $transactionID - Transaction ID is unique identifier on
    *   ZooZ’s servers as you get from the response whether it’s from ZooZ’s SDK 
    *   response or callback response, after the user authorized or commit a 
    *   transaction.
    * @param double $amount - Optional value. If you wish to refund the 
    *   transaction on a smaller amount than the original amount the transaction
    *   was authorized. Expected format: dddddd.cc (e.g. 105.15)
    */ 
   function __construct($transactionID , $amount=NULL) {
        parent::__construct($transactionID);
        
        if (!empty($amount)) {
            $this->nvps->add("amount", $amount);
        }
    }
    
    
    protected function getCommand() {
        return EnumCommands::refundTransaction;
    }
    
}

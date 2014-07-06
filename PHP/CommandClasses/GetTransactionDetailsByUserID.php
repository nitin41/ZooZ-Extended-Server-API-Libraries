<?php

require_once './AbstractClasses/AbstractCommand.php';
require_once './AbstractClasses/EnumCommands.php';

/**
 * Get Transaction Details By User ID API
 *
 * Getting transactions details by user ID API allows you to retrieve transaction full details and
 * transaction status before or/and after commit or refund for all transactions associated with
 * the above email. This call does not change the transaction state.
 */
class GetTransactionDetailsByUserID extends AbstractCommand {
    /**
     *
     * @param String $userId - Unique identifier on ZooZ’s servers for the user
     *  who processed this transaction. This value is returned in the Callback
     *  API response.
     * @param String $fromDate - Filter the results by dates.
     * @param String $toDate- Filter the results by dates.
     */
    function __construct($userId , $fromDate=NULL , $toDate=NULL) {
        parent::__construct();
        $this->nvps->add("userId", $userId);
        if (!empty($fromDate)) {
            $this->nvps->add("fromDate", $fromDate);
            if (!empty($toDate)) {
                $this->nvps->add("toDate", $toDate);
            }
        }
    }

    protected function getCommand() {
        return EnumCommands::getTransactionDetailsByUserId;
    }

}

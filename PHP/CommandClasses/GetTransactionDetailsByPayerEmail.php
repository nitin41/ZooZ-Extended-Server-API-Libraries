<?php

require_once './AbstractClasses/AbstractCommand.php';
require_once './AbstractClasses/EnumCommands.php';

/**
 * Get Transaction Details By Payer Email API
 *
 * Getting transactions details by payer’s email address API allows you to retrieve transaction
 * full details and transaction status before or/and after commit or refund for all transactions
 * associated with the above email. This call does not change the transaction state.
 */
class GetTransactionDetailsByPayerEmail extends AbstractCommand{
    /**
     *
     * @param String $email - Payer email address.
     * @param String $fromDate - Filter the results by dates.
     * @param String $toDate - Filter the results by dates.
     */
    function __construct($email , $fromDate=NULL , $toDate=NULL) {
        parent::__construct();
        $this->nvps->add("email", $email);
        if (!empty($fromDate)) {
            $this->nvps->add("fromDate", $fromDate);
            if (!empty($toDate)) {
                $this->nvps->add("toDate", $toDate);
            }
        }
    }
    protected function getCommand() {
        return EnumCommands::getTransactionDetailsByPayerEmail;
    }
}

<?php

require_once './AbstractClasses/AbstractCommand.php';
require_once './AbstractClasses/EnumCommands.php';

/**
 * GetTransaction Details By Parameters API
 *
 * Getting transactions details by parameters API allows you to retrieve transaction full details
 * and transaction status before or/and after commit or refund for all transactions
 * corresponding to the selected parameters. This call does not change the transaction state.
 */
class GetTransactionDetailsByParameters extends AbstractCommand{
    /**
     * 
     * @param QueryType $requestedQuery -   One of the queries available in 
     *                                      the API
     */
    function __construct($requestedQuery) {
        parent::__construct();
        $requestedQuery->addParametersToTheNvps($this->nvps);        
    }
    
    protected function getCommand() {
        return EnumCommands::getTransactionDetailsByParameters;
    }
}

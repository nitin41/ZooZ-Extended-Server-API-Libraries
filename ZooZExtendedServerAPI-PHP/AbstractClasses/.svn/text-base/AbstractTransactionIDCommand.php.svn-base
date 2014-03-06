<?php

require_once './AbstractClasses/AbstractCommand.php';
/**
 * Description of AbstractTransactionIDCommand
 *
 * @author roykey
 */
abstract class AbstractTransactionIDCommand extends AbstractCommand{
    function __construct($transactionID) {
        parent::__construct();
        $this->nvps->add("transactionID", $transactionID);
    }
}

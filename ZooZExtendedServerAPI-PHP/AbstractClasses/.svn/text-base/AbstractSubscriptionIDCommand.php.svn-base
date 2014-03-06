<?php

require_once './AbstractClasses/AbstractCommand.php';
/**
 * Description of AbstractSubscriptionIDCommand
 *
 * @author Roy Keynan
 */
abstract class AbstractSubscriptionIDCommand extends AbstractCommand{
    function __construct($subscriptionID) {
        parent::__construct();
        $this->nvps->add("subscriptionID", $subscriptionID);
    }
}

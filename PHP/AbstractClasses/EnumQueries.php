<?php

require_once 'lib/QueryType.php';

/**
 * Description of TypeOfQuery
 *
 * @author Roy Keynan
 */
abstract class EnumQueries {

    const invoiceNumber = "invoiceNumber";
    const closedBetweenDates = "closedBetweenDates";
    const statusAndDates = "statusAndDates";
    const customerLoginID = "customerLoginID";
    const customerLoginName = "customerLoginName";
    
}

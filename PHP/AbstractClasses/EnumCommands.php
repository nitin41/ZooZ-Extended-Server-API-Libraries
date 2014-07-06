<?php

/**
 * Description of EnumCommands
 *
 * @author Roy Keynan
 */
abstract class EnumCommands {
    
    const getTransactionDetails = "getTransactionDetails";
    const cancelPayment = "cancelPayment";
    const commitTransaction = "commitTransaction";
    const refundTransaction = "refundTransaction";
    const getSubscriptionDetails = "getSubscriptionDetails";
    const checkSubscription = "checkSubscription";
    const cancelSubscription = "cancelSubscription";
    const getTransactionDetailsByPayerEmail = "getTransactionDetailsByPayerEmail";
    const getTransactionDetailsByParameters = "getTransactionDetailsByParameters";
    const getTransactionDetailsByUserId = "getTransactionDetailsByUserId";
 
}

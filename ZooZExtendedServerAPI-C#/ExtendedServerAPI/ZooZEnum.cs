using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ZooZEnums
{
        enum Commands 
        {
            getTransactionDetails,
            getTransactionDetailsByPayerEmail,
            getTransactionDetailsByParameters,
            commitTransaction,
            refundTransaction,
            cancelPayment,
            getSubscriptionDetails,
            cancelSubscription,
            checkSubscription,
            getTransactionDetailsByUserId
               
        };

        enum TypeOfQuery
        {
            invoiceNumber,
            closedBetweenDates,
            statusAndDates,
            customerLoginID,
            customerLoginName
        };

}

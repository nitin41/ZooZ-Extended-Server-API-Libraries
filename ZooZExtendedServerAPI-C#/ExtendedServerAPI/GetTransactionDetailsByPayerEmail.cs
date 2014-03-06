using AbstractClasses;
using ZooZEnums;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CommandClasses
{
    /// <summary>
    /// Get Transaction Details By Payer Email API.
    /// </summary>
    /// <remarks>
    /// Getting transactions details by payer's email address API allows you to retrieve transaction
    /// full details and transaction status before or/and after commit or refund for all transactions
    /// associated with the above email. This call does not change the transaction state. </remarks>
    class GetTransactionDetailsByPayerEmail : AbstractCommand
    {
        /// <summary>
        /// Class constructor.
        /// </summary>
        /// <param name="email">
        /// Payer e-mail address. </param>
        /// <param name="fromDate">
        /// Filter the results by dates. Expected format: DateTime object or null. </param>
        /// <param name="toDate">
        /// Filter the results by dates. Expected format: DateTime object or null. </param>
        public GetTransactionDetailsByPayerEmail(string email, DateTime? fromDate, DateTime? toDate)
            : base()
        {
            kvpList.Add(new KeyValuePair<string, Object>("&email=", email));

            if (fromDate != null)
            {
                kvpList.Add(new KeyValuePair<string, Object>("&fromDate=", ((DateTime)fromDate).ToString(pattern)));

                if (toDate != null)
                {
                    kvpList.Add(new KeyValuePair<string, Object>("&toDate=", ((DateTime)toDate).ToString(pattern)));
                }

            }
        }
        public override string getCommand()
        {
            return Commands.getTransactionDetailsByPayerEmail.ToString();
        }

        /// <summary> 
        /// Get the transactions details</summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action.</returns>
        public JObject getTransactionDetailsByPayerEmail()
        {
            return postToZooZ();
        }
    }

}

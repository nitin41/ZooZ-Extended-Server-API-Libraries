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
    /// Get Transaction Details By User Id API
    /// </summary>
    /// <remarks>
    /// Getting transactions details by user ID API allows you to retrieve transaction full details and
    /// transaction status before or/and after commit or refund for all transactions associated with
    /// the above email. This call does not change the transaction state. </remarks>
    class GetTransactionDetailsByUserId : AbstractCommand
    {
        /// <summary>
        /// Class constructor
        /// </summary>
        /// <param name="userId">
        /// Unique identifier on ZooZÕs servers for the user who processed this transaction.
        /// This value is returned in the Callback API response.</param>
        /// <param name="fromDate">
        /// Filter the results by dates. Expected format: DateTime object or null. </param>
        /// <param name="toDate">
        /// Filter the results by dates. Expected format: DateTime object or null. </param>
        public GetTransactionDetailsByUserId(string userId, DateTime? fromDate, DateTime? toDate)
            : base()
        {
            kvpList.Add(new KeyValuePair<string, Object>("&userId=", userId));

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
            return Commands.getTransactionDetailsByUserId.ToString();
        }

        /// <summary> 
        /// Get the transactions details</summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action.</returns>
        public JObject getTransactionDetailsByUserId()
        {
            return postToZooZ();
        }
    }
}

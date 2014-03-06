using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AbstractClasses;
using Newtonsoft.Json.Linq;
using ZooZEnums;

namespace CommandClasses
{
    /// <summary>
    /// Get Transaction Details By Transaction ID API.
    /// </summary>
    /// <remarks>
    /// Get transaction details with the transaction ID API.	This allows you to retrieve complete
    /// transaction details and transaction statuses before and/or after commit or refund. This call
    /// does not change the transaction state. </remarks>
    class GetTransactionDetailsByTransactionID : AbstractTransactionIDCommand
    {
        /// <summary>
        /// Class Constructor. </summary>
        /// <param name="transactionID"> 
        /// Transaction ID is unique identifier on ZooZ's servers as you get from the response whether it's from ZooZ's SDK response or callback response,
        /// after the user authorized or commit a transaction. </param>
        public GetTransactionDetailsByTransactionID(string transactionID) : base(transactionID) { }

        public override string getCommand()
        {
            return Commands.getTransactionDetails.ToString();
        }

        /// <summary> 
        /// Get the transactions details</summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action.</returns>
        public JObject getTransactionDetailsByTransactionID()
        {
            return postToZooZ();
        }
    }
}


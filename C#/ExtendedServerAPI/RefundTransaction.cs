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
    /// Refund Transaction API
    /// </summary>
    /// <remarks>
    /// The Refund Transaction API allows you to refund a specific transaction.
    /// You can call this API up to 60 days after the transaction was executed.
    /// In case you want to do partial refund, send the amount parameter.</remarks>
    class RefundTransaction : AbstractTransactionIDCommand
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="transactionID">
        /// Transaction ID is unique identifier on ZooZ's servers as you get from the response
        /// whether it's from ZooZ's SDK response or callback response, after the user authorized
        /// or commit a transaction.</param>
        /// <param name="amount"> 
        /// Optional value. If you wish to commit the transaction on a smaller amount than the original amount the transaction was authorized,
        /// or if you were approved by ZooZ to commit the transaction on higher amount than the original amount.
        /// Expected format: dddddd.cc	(e.g 105.15) </param>
        public RefundTransaction(string transactionID, double? amount)
            : base(transactionID)
        {
            if (amount != null)
            {
                kvpList.Add(new KeyValuePair<string, Object>("&amount=", amount));
            }
        }
        public override string getCommand()
        {
            return Commands.refundTransaction.ToString();
        }
        /// <summary> 
        /// Refund the transaction.  </summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action. </returns>
        public JObject refundTransaction()
        {
            return postToZooZ();
        }
    }
}
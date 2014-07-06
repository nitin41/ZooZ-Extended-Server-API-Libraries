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
    /// Commit Transaction API </summary>
    /// <remarks>
    /// If your app is set to the deferred payments setting (App setting in
    /// the ZooZ portal) then the flow of payments is separated to the following two phases:
    /// 1. User authorizes the transaction with ZooZ (Over Mobile Device)
    /// 2. Your server approves the purchase
    /// This flexibility allows merchants to review the user order before making the actual charge.
    /// Using ZooZ developerÕs portal or using command API, you can choose to commit or
    /// ignore that transaction after the user authorizes it.
    /// You can call this API up to 14 days after the transaction was authorized.
    /// In case you want to do partial commit, send the amount parameter. </remarks>
    class CommitTransaction : AbstractTransactionIDCommand
    {

        /// <summary>
        /// Class constructor </summary>
        /// <param name="transactionID">
        /// Transaction ID is unique identifier on ZooZ's servers as you get from the response whether it's from ZooZ's SDK response  or callback response, 
        /// after the user authorized or commit a transaction.</param>
        /// <param name="amount"> 
        /// Optional value. If you wish to commit the transaction on a smaller amount than the original amount the transaction was authorized,
        /// or if you were approved by ZooZ to commit the transaction on higher amount than the original amount.
        /// Expected format: dddddd.cc	(e.g 105.15) </param>
        /// <param name="invoice">
        /// If you wish to commit the transaction on a different invoice. </param>
        public CommitTransaction(string transactionID, double? amount, JObject invoice)
            : base(transactionID)
        {
            if (amount != null)
            {
                kvpList.Add(new KeyValuePair<string, Object>("&amount=", amount));
            }
            if (invoice != null)
            {
                kvpList.Add(new KeyValuePair<string, Object>("&invoice=", invoice));
            }
        }
        public override string getCommand()
        {
            return Commands.commitTransaction.ToString();
        }

        /// <summary> 
        /// Commit the transaction  </summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action. </returns>
        public JObject commitTransaction()
        {
            return postToZooZ();
        }
    }
}

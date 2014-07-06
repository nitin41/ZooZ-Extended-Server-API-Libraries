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
    /// Cancel Transaction API </summary>
    /// <remarks>
    /// The cancel transaction API is enabled only if your app is set to deferred payments.
    /// It allows you to cancel a specific pending transaction. </remarks>
    class CancelTransaction : AbstractTransactionIDCommand
    {
        /// <summary>
        /// Class Constructor. </summary>
        /// <param name="transactionID"> 
        /// Transaction ID is unique identifier on ZooZ's servers as you get from the response whether it's from ZooZ's SDK response or callback response,
        /// after the user authorized or commit a transaction. </param>
        public CancelTransaction(string transactionID) : base(transactionID) { }

        public override string getCommand()
        {
            return Commands.cancelPayment.ToString();
        }

        /// <summary> 
        /// Cancel the transaction  </summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action.</returns>
        public JObject cancelTransaction()
        {
            return postToZooZ();
        }
    }
}

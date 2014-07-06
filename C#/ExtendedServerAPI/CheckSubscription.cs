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
    /// Check Subscription API </summary>
    /// <remarks>
    /// This allows you to check a subscription's status. </remarks>
    class CheckSubscription : AbstractSubscriptionIDCommand
    {
        /// <summary>
        /// Class constructor </summary>
        /// <param name="subscriptionID">
        /// Subscription ID is a unique identifier on ZooZ's servers as you get from the response whether it's from ZooZ's SDK response or callback response, 
        /// after the user subscribes to your plan. </param>
        public CheckSubscription(string subscriptionID) : base(subscriptionID) { }

        public override string getCommand()
        {
            return Commands.checkSubscription.ToString();
        }

        /// <summary> 
        /// Check the subscription status</summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action.</returns>
        public JObject checkSubscription()
        {
            return postToZooZ();
        }
    }
}

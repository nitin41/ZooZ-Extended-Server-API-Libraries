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
    /// Cancel Subscription API </summary>
    /// <remarks>
    /// This allows you to cancel a subscription.
    /// The subscription status will be "CanceledByMerchant".  </remarks>
    class CancelSubscription : AbstractSubscriptionIDCommand
    {
        /// <summary> 
        /// Class constructor </summary> 
        /// <param name="SubscriptionID">  
        /// SubscriptionID is a unique identifier on ZooZ's servers as you get from the response
        /// whether itÕs from ZooZ's SDK response or callback response, after the user subscribes to your plan. </param>
        public CancelSubscription(string SubscriptionID) : base(SubscriptionID) { }

        public override string getCommand()
        {
            return Commands.cancelSubscription.ToString();
        }

        /// <summary> 
        /// Cancel the subscription  </summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action. </returns>
        public JObject cancelSubscription()
        {
            return postToZooZ();
        }
    }

}

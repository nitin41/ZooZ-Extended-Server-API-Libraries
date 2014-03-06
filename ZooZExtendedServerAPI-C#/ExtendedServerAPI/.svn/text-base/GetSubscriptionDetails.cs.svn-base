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
    /// Get Subscription Details API </summary>
    /// <remarks>
    /// Get subscription details with the subscription ID API. This allows you to retrieve complete
    /// subscription details and its transactions details. This call does not change the subscription </remarks>
    class GetSubscriptionDetails: AbstractSubscriptionIDCommand
    {
        /// <summary>
        /// Class constructor
        /// </summary>
        /// <param name="subscriptionID">
        /// Subscription ID is a unique identifier on ZooZ's servers as you get from the response whether it's from ZooZ's SDK response or callback response, 
        /// after the user subscribes to your plan. </param>
        public GetSubscriptionDetails(string subscriptionID) : base(subscriptionID) { }

        public override string getCommand()
        {
            return Commands.getSubscriptionDetails.ToString();
        }
        /// <summary> 
        /// Get the subscription Details</summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action.</returns>
        public JObject getSubscriptionDetails()
        {
            return postToZooZ();
        }
    }
    
}


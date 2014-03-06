using AbstractClasses;
using ZooZEnums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ZooZQueryTypes
{
    /// <summary>
    /// Get all the transactions followed by a specific customer login mame  </summary>
    class CustomerLoginNameQuery : QueryType
    {

        public string customerLoginName { get; private set; }

        /// <summary>
        /// Class constructor.
        /// </summary>
        /// <param name="customerLoginName">
        /// The	customer login name on the merchant's app. </param>
        public CustomerLoginNameQuery(string customerLoginName)
            : base()
        {
            this.customerLoginName = customerLoginName;

        }

        protected override void addQueryParametersToKvpList(List<KeyValuePair<string, object>> kvpList)
        {
            kvpList.Add(new KeyValuePair<string, Object>("&customerLoginName=", customerLoginName));
        }

        protected override TypeOfQuery getQueryType()
        {
            return TypeOfQuery.customerLoginName;
        }

    }
}

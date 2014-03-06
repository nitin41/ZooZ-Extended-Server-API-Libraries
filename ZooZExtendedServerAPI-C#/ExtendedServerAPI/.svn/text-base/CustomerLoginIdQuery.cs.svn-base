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
    /// Get all the transactions followed by a specific customer login Id  </summary>
    class CustomerLoginIDQuery: QueryType
    {     
        private string customerLoginID { get; set; }

        /// <summary>
        /// Class constructor
        /// </summary>
        /// <param name="customerLoginID">
        /// The	customer login ID on the merchant's	app. </param>
        public CustomerLoginIDQuery(string customerLoginID)
            : base()
        {
            this.customerLoginID = customerLoginID;

        }

        protected override void addQueryParametersToKvpList(List<KeyValuePair<string, object>> kvpList)
        {
            kvpList.Add(new KeyValuePair<string, Object>("&customerLoginID=", customerLoginID));
        }

        protected override TypeOfQuery getQueryType()
        {
            return TypeOfQuery.customerLoginID;
        }

    }
}

using ZooZEnums;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ZooZQueryTypes;

namespace AbstractClasses
{
    /// <summary>
    /// Queries for the " Get Transaction Details By Parameters API " </summary>
    /// <remarks>
    /// Queries availbe:
    /// InvoiceNumberQuery , ClosedBetweenDatesQuery , StatusAndDatesQuery , CustomerLoginIdQuery , CustomerLoginNameQuery </remarks>
    abstract class QueryType
    {
        public string pattern { get { return "yyyy-MM-dd"; } }
        internal void addParametersToKvpList(List<KeyValuePair<string, object>> kvpList)
        {
            kvpList.Add(new KeyValuePair<string, Object>("&queryType=", getQueryType().ToString()));
            addQueryParametersToKvpList(kvpList);
        }

        protected abstract TypeOfQuery getQueryType();

        protected abstract void addQueryParametersToKvpList(List<KeyValuePair<string, object>> kvpList);

        protected void addDatesToKvp(List<KeyValuePair<string, object>> kvpList, DateTime? startDate, DateTime? endDate)
        {
            if (startDate != null)
            {
                kvpList.Add(new KeyValuePair<string, Object>("&startDate=", ((DateTime)startDate).ToString(pattern)));
                if (endDate != null)
                {
                    kvpList.Add(new KeyValuePair<string, Object>("&endDate=", ((DateTime)endDate).ToString(pattern)));
                }
            }
        }

    }
}

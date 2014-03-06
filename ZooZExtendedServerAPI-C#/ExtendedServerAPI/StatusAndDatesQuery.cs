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
    /// Get all the transactions details between specific dates followed by a specific status  </summary>
    class StatusAndDatesQuery : QueryType
    {
        private string paymentStatus { get; set; }
        private DateTime? startDate { get; set; }
        private DateTime? endDate { get; set; }

        /// <summary>
        /// Class constructor.
        /// </summary>
        /// <param name="paymentStatus">
        /// Can be one of the following:
        /// Pending, TPCPending, AuthorizationProcess, Succeed,	Failed, UserRejected, POSCanceled, Timeout </param>
        /// <param name="startDate">
        /// The earliest date for the requested transactions. </param>
        /// <param name="endDate">
        /// The latest date for the requested transactions. </param>
        public StatusAndDatesQuery(string paymentStatus, DateTime? startDate, DateTime? endDate)
            : base()
        {
            this.paymentStatus = paymentStatus;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        protected override void addQueryParametersToKvpList(List<KeyValuePair<string, object>> kvpList)
        {
            kvpList.Add(new KeyValuePair<string, Object>("&paymentStatus=", paymentStatus));
            addDatesToKvp(kvpList, startDate, endDate);
        }

        protected override TypeOfQuery getQueryType()
        {
            return TypeOfQuery.statusAndDates;
        }


    }
}

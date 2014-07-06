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
    /// Get all the transactions details between specific dates. </summary>
    class ClosedBetweenDatesQuery : QueryType
    {
        private DateTime? startDate {get; set;}
        private DateTime? endDate { get; set; }

        /// <summary>
        /// Class constructor.
        /// </summary>
        /// <param name="startDate">
        /// The earliest date for the requested transactions. </param>
        /// <param name="endDate">
        /// The latest date for the requested transactions. </param>
        public ClosedBetweenDatesQuery(DateTime? startDate , DateTime? endDate)
            : base()
        {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        protected override void addQueryParametersToKvpList(List<KeyValuePair<string, object>> kvpList)
        {
            addDatesToKvp(kvpList ,startDate, endDate);
        }

        protected override TypeOfQuery getQueryType()
        {
            return TypeOfQuery.closedBetweenDates;
        }
    }
}

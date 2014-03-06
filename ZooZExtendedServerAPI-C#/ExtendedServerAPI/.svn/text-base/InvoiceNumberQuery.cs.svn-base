using AbstractClasses;
using ZooZEnums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace ZooZQueryTypes
{
    /// <summary>
    /// Get all the transactions details regarding the same invoice number. </summary>
    class InvoiceNumberQuery : QueryType
    {

        private string invoiceNumber { get; set; }

        /// <summary>
        /// Class constructor
        /// </summary>
        /// <param name="invoiceNumber">
        /// The invoice number of the requested transaction.</param>
        public InvoiceNumberQuery(string invoiceNumber)
            : base()
        {
            this.invoiceNumber = invoiceNumber;

        }

        protected override void addQueryParametersToKvpList(List<KeyValuePair<string, object>> kvpList)
        {
            kvpList.Add(new KeyValuePair<string, Object>("&invoiceNumber=", invoiceNumber));
        }

        protected override TypeOfQuery getQueryType()
        {
            return TypeOfQuery.invoiceNumber;
        }

    }
}

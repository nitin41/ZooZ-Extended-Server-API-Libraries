using AbstractClasses;
using ZooZEnums;
using Newtonsoft.Json.Linq;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CommandClasses
{
    /// <summary>
    /// Get Transaction Details By Parameters API
    /// </summary>
    /// <remarks>
    /// Getting transactions details by parameters API allows you to retrieve transaction full details
    /// and transaction status before or/and after commit or refund for all transactions
    /// corresponding to the selected parameters. This call does not change the transaction state. </remarks>
    class GetTransactionDetailsByParameters : AbstractCommand
    {
        /// <summary>
        /// Class constructor - adding the specific query parametres to the generated key-value pair list.
        /// </summary>
        /// <param name="requestedQuery"> One of the queries available in the API </param>
        public GetTransactionDetailsByParameters(QueryType requestedQuery)
            : base()
        {
            requestedQuery.addParametersToKvpList(kvpList);
        }

        public override string getCommand()
        {
            return Commands.getTransactionDetailsByParameters.ToString();
        }

        /// <summary> 
        /// Get the transactions details</summary> 
        /// <returns>
        /// A Json object which contains the result from the ZooZ Servers regards this action.</returns>
        public JObject getTransactionDetailsByParameters()
        {
            return postToZooZ();
        }

    }
}

























//            //Parameters = requestedQuery.parametersList;
//            //TypeOfQuery querySwitch = requestedQuery.typeOfQuery;

//            //switch (querySwitch)
//            //{
//            //    case TypeOfQuery.invoiceNumber:
//            //        kvpList.Add(new KeyValuePair<string, Object>("&invoiceNumber=", (string)Parameters.Dequeue()));
//            //        break;
//            //    case TypeOfQuery.closedBetweenDates:
//            //        AddDatesToKvp();
//            //        break;
//            //    case TypeOfQuery.statusAndDates:
//            //        kvpList.Add(new KeyValuePair<string, Object>("&paymentStatus=", (string)Parameters.Dequeue()));
//            //        AddDatesToKvp();
//            //        break;
//            //    case TypeOfQuery.customerLoginId:
//            //        kvpList.Add(new KeyValuePair<string, Object>("&customerLoginId=", (string)Parameters.Dequeue()));
//            //        break;
//            //    case TypeOfQuery.customerLoginName:
//            //        kvpList.Add(new KeyValuePair<string, Object>("&customerLoginName=", (string)Parameters.Dequeue()));
//            //        break;
//            //}
//        }

//        private void AddDatesToKvp()
//        {
//            Object checkIfNull = Parameters.Peek();
//            if (checkIfNull != null)
//            {
//                kvpList.Add(new KeyValuePair<string, Object>("&startDate=", ((DateTime)Parameters.Dequeue()).ToString(pattern)));
//                checkIfNull = Parameters.Peek();
//                if (checkIfNull != null)
//                {
//                    kvpList.Add(new KeyValuePair<string, Object>("&endDate=", ((DateTime)Parameters.Dequeue()).ToString(pattern)));
//                }
//            }
//        }

//        public override string getCommand()
//        {
//            return Commands.getTransactionDetailsByParameters.ToString();
//        }

//        /// <summary> 
//        /// Get the transactions details</summary> 
//        /// <returns>
//        /// A Json object which contains the result from the ZooZ Servers regards this action.</returns>
//        public JObject getTransactionDetailsByParameters()
//        {
//            return postToZooZ();
//        }
//    }
//}

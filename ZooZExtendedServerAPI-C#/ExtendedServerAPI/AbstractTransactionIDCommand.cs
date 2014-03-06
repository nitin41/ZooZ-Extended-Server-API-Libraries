using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbstractClasses
{
    abstract class AbstractTransactionIDCommand : AbstractCommand
    {
        protected AbstractTransactionIDCommand(string transactionID) : base() 
        {
            kvpList.Add(new KeyValuePair<string, Object>("&transactionID=", transactionID));     
        }

    }
}

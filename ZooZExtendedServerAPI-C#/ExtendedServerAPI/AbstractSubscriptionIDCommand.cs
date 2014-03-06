using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbstractClasses
{
    abstract class AbstractSubscriptionIDCommand : AbstractCommand
    {
        protected AbstractSubscriptionIDCommand(string subscriptionID) : base()
        {
            kvpList.Add(new KeyValuePair<string, Object>("&subscriptionID=", subscriptionID));
        }

    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExtendedSeverAPI
{
    class ZooZExtendedServerAPI
    {
        private static readonly string PRODUCTION_URL = "https://app.zooz.com/";
        private static readonly string SANDBOX_URL = "https://sandbox.zooz.co/";

        public static string zoozDeveloperId { get; private set; }

        public static string zoozServerAPIKey { get; private set; }

        public static string zoozServer { get; private set; }


        /// <summary>
        ///  Initialize the ZooZExtendedServerAPI to enable communication with your account
        /// </summary>
        /// <param name="zooz_Developer_Id">
        /// Developer email as entered in ZooZ Developer portal. </param>
        /// <param name="zooz_Server_API_Key">
        /// ZooZ Server API Key assigned to you upon registration. Can be found on the "Account" section of the ZooZ Developer Portal. </param>
        /// <param name="is_Sandbox">
        /// True to use sandbox environment, false to use live environment. </param>
        public static void init(string zooz_Developer_Id, string zooz_Server_API_Key, bool is_Sandbox)
        {
            if ((zooz_Developer_Id == "") || (zooz_Server_API_Key == ""))
            {
                //throw error this is empty
            }

            ZooZExtendedServerAPI.zoozDeveloperId = zooz_Developer_Id;
            ZooZExtendedServerAPI.zoozServerAPIKey = zooz_Server_API_Key;

            if (is_Sandbox)
            {
                ZooZExtendedServerAPI.zoozServer = SANDBOX_URL;
            }
            else
            {
                ZooZExtendedServerAPI.zoozServer = PRODUCTION_URL;
            }

        }
    }
}

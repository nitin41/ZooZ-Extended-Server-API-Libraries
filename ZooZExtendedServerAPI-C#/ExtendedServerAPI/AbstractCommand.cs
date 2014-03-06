using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using ExtendedSeverAPI;
using System.IO;
using System.Runtime.Serialization.Json;
using System.Diagnostics;
using Newtonsoft.Json.Linq;

namespace AbstractClasses
{
    abstract class AbstractCommand
    {
        private JObject result;
        private readonly string VERSION_NUMBER = "1.1.1";
        private List<KeyValuePair<string, Object>> kvp = new List<KeyValuePair<string, Object>>();
        public string pattern { get { return "yyyy-MM-dd"; } }
            
        public List<KeyValuePair<string, Object>> kvpList
        {
            get { return kvp; }
        }

        public AbstractCommand()
        {
            kvpList.Add(new KeyValuePair<string, Object>("cmd=", getCommand()));
            kvpList.Add(new KeyValuePair<string, Object>("&ver=", VERSION_NUMBER));
        }

        public abstract string getCommand();

        public string parseCommand()
        {
            StringBuilder trxData = new StringBuilder();

            foreach (KeyValuePair<string, Object> kvp in kvpList)
            {
                trxData.Append(kvp.Key);
                trxData.Append(kvp.Value);
            }

            return trxData.ToString();
        }

        public JObject postToZooZ()
        {

            string receiveToken = "";
            HttpWebRequest myRequest = (HttpWebRequest)WebRequest.Create(ZooZExtendedServerAPI.zoozServer + "mobile/ExtendedServerAPI");
            myRequest.ContentType = "application/x-www-form-urlencoded";
            byte[] byteArray = Encoding.UTF8.GetBytes(this.parseCommand());
            myRequest.ContentLength = byteArray.Length;
            myRequest.Method = "POST";
            myRequest.Headers.Add("ZooZDeveloperId", ZooZExtendedServerAPI.zoozDeveloperId);
            myRequest.Headers.Add("ZooZServerAPIKey", ZooZExtendedServerAPI.zoozServerAPIKey);
            myRequest.Timeout = 30000;

            Stream dataStream = myRequest.GetRequestStream();
            dataStream.Write(byteArray, 0, byteArray.Length);

            try
            {
                HttpWebResponse response = (HttpWebResponse)myRequest.GetResponse();
                Stream receiveStream = response.GetResponseStream();
                StreamReader readStream = new StreamReader(receiveStream, Encoding.UTF8);
                receiveToken = readStream.ReadToEnd();
                result = (JObject)Newtonsoft.Json.JsonConvert.DeserializeObject(receiveToken);

            }
            catch (Exception ex)
            {
                Trace.TraceError("Error Contacting Zooz Server, error: " + ex.Message);
            }

            return result;
        }

        public void writeToLogger()
        {
            if (result.Last.ToString().Equals("\"ResponseStatus\": -1"))
                Trace.TraceError(result.ToString());
            else
                Trace.TraceInformation(result.ToString());
            Trace.TraceInformation("// -------------------------------");
        }
    }
}
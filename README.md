ZooZ-Extended-Server-API-Libraries
==================================

ZooZ Extended Server API Libraries

ZooZ Extended server API allows you to extend your control and manageability of your payment transactions. 
With the Extended Server API you can: 
  1. Defer payments -­‐ approve your users’ purchases after they authorize ZooZ transactions
  2. Get full details on transactions by transaction ID or payee email address 
  3. Refund transactions Prior to initiating any forms of integration, 
  
it will be necessary for you to sign up for ZooZ at http://www.ZooZ.com 
The purpose of this guide is to provide you with all necessary information for integration, 
however if you have any questions, please feel free to contact us at support@ZooZ.com 

Version The version of this API is: 1.1.1 
Notice: Please make sure to pass this version number to the API. 

To Get Started with ZooZ:

1. Register and create app at ZooZ 
2. Integrate the ZooZ SDK in your App 
3. Generate transactions using ZooZ SDK 

Quick java example:

    private static final String DEVELOPER_ID = "developer@email.here";   // fill in your ZooZ Developer Id
    private static final String API_KEY = "api-key.here";                // can be found in My Account-> Server API Key.
    private static final boolean IS_SANDBOX = true;                      // select the mode you want to integrate with, sandbox or production

    ZooZExtendedServerAPI.init(DEVELOPER_ID, API_KEY, IS_SANDBOX);       // set-up a connection to ZooZ servers
    
    String GET_TRANSACTION_ID = "7JU3VMGBXC4XJE343ASWF3W6C4";            // fill the transaaction id you like to get it result.
                                                                                can be found in Reports->Transaction Details->Transaction ID
    
    GetTransactionDetailsByTransactionID sample = new GetTransactionDetailsByTransactionID(GET_TRANSACTION_ID);
    JSONObject result = sample.postToZooZ();
    
the result will be in a Json format, simmiler to this:
    
    {
      "ResponseObject":
        {"currencyCode":"USD",
        "fundSourceType":"MasterCard",
        "invoice":{"items":[{"id":"100101","price":12.5,"name":"Coca
        Cola","additionalDetails":"Can","quantity":2},
              {"id":"100102","price":10,"name":"Sprite","additionalDetails":"Can","quantity":2}],
           "additionalDetails":"Invoice
           additional details",
           "number":"Invoice Number"},
         "transactionID":"7JU3VMGBXC4XJE343ASWF3W6C4",
         "appName":"Kartis",
         "amount":45,
         "isSandbox":"false",
         "lastFourDigits":"4444",
         "paidAmount":45,
         "transactionFee":0.17,
         "transactionTimestamp":1344953560718,
         "mobileDeviceId": 287153,
         "mobileDeviceName": "GT-­‐N7000",
         "mobileDeviceOsVersion": "10",
         "userId": 287239,
         “riskScore”: 1.5,
        "ipAddress": "127.255.255.255",
             "addresses":[{"billing.street":"Main St. 1 ",
             "billing.city":"New York",
             "billing.state":"New York",
             "billing.zip":"643321", 
             "billing.country":"USA"}],
         "transactionStatus":"Succeed",
         "user":{"lastName":"Jones",
           "phone":{"phoneNumber":"05481234567",
             "countryCode":"001"},
         "email":"support@zooz.com",
         "additionalDetails":"Additional User Details 1234",
       "firstName":"Tom"}
       },
     "ResponseStatus": 0 
     }

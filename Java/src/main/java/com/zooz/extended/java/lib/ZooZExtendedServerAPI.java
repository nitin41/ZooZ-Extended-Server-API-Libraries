package com.zooz.extended.java.lib;

import com.zooz.extended.java.lib.exception.ZooZException;
import com.zooz.extended.java.lib.utils.ZooZStringUtils;

/**
 * Developer: Roy Keynan
 */
public class ZooZExtendedServerAPI {

    private static String zoozDeveloperId;
    private static String zoozServerAPIKey;
    private static String zoozServer;

    /**
     * Initialize the ZooZExtendedServerAPI to enable communication with your account
     *
     * @param zoozDeveloperId  - Developer email as entered in ZooZ Developer portal.
     * @param zoozServerAPIKey - ZooZ Server API Key assigned to you upon registration. Can be found on the "Account" section of the ZooZ Developer Portal.
     * @param zoozServer       - ZooZ Server which we want to connect to (PRODUCTION , SANDBOX)
     */
    public static void init(String zoozDeveloperId, String zoozServerAPIKey, String zoozServer) throws ZooZException {

        if (ZooZStringUtils.isEmpty(zoozDeveloperId)) {
            throw new ZooZException("Please enter your developer email as registered in ZooZ's developer portal");
        }

        if (ZooZStringUtils.isEmpty(zoozServerAPIKey)) {
            throw new ZooZException("Please enter ZooZ Server API Key as diaplayed in ZooZ's developer portal under \'My Account\'");
        }

        ZooZExtendedServerAPI.zoozDeveloperId = zoozDeveloperId;
        ZooZExtendedServerAPI.zoozServerAPIKey = zoozServerAPIKey;
        ZooZExtendedServerAPI.zoozServer = zoozServer;
    }

    /**
     * Get getZoozDeveloperId
     *
     * @return zoozDeveloperId
     */
    public static String getZoozDeveloperId() {
        return zoozDeveloperId;
    }

    /**
     * Get zoozServerAPIKey
     *
     * @return zoozServerAPIKey
     */
    public static String getZoozServerAPIKey() {
        return zoozServerAPIKey;
    }

    /**
     * Get zoozServer
     *
     * @return zoozServer
     */
    public static String getZoozServer() {
        return zoozServer;
    }

}

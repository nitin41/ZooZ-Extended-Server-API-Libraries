package com.zooz.extended.java.lib;

import com.zooz.extended.java.lib.exception.ZooZException;
import com.zooz.extended.java.lib.utils.ZooZStringUtils;

/**
 * Developer: Roy Keynan
 */
public class ZooZExtendedServerAPI {

    private static final String PRODUCTION_URL = "https://app.zooz.com/";
    private static final String SANDBOX_URL = "https://sandbox.zooz.co/";

    private static String zoozDeveloperId;
    private static String zoozServerAPIKey;
    private static String zoozServer;

    /**
     * Initialize the ZooZExtendedServerAPI to enable communication with your account
     *
     * @param zoozDeveloperId - Developer email as entered in ZooZ Developer portal.
     * @param zoozServerKey   - ZooZ Server API Key assigned to you upon registration. Can be found on the "Account" section of the ZooZ Developer Portal.
     * @param isSandbox       - True to use sandbox environment, false to use live environment.
     */
    public static void init(String zoozDeveloperId, String zoozServerKey, boolean isSandbox) throws ZooZException {

        if (ZooZStringUtils.isEmpty(zoozDeveloperId)) {
            throw new ZooZException("Please enter your developer email as registered in ZooZ's developer portal");
        }

        if (ZooZStringUtils.isEmpty(zoozServerKey)) {
            throw new ZooZException("Please enter ZooZ Server API Key as diaplayed in ZooZ's developer portal under \'My Account\'");
        }

        ZooZExtendedServerAPI.zoozDeveloperId = zoozDeveloperId;
        ZooZExtendedServerAPI.zoozServerAPIKey = zoozServerKey;
        if (isSandbox) {
            ZooZExtendedServerAPI.zoozServer = SANDBOX_URL;
        } else {
            ZooZExtendedServerAPI.zoozServer = PRODUCTION_URL;
        }
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

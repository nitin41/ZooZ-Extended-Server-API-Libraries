<?php

/**
 * Initialize the ZooZExtendedServerAPI to enable
 * communication with your account.
 *
 * @author Roy Keynan
 */

class ZooZExtendedServerAPI {
    public static $developerId, $apiKey, $zoozServer;
    const PRODUCTION_URL = "https://app.zooz.com/";
    const SANDBOX_URL = "https://sandbox.zooz.co/";
    /**
     *
     * @param String $developerId - Developer email as entered in ZooZ Developer
     *  portal.
     * @param String $apiKey - ZooZ Server API Key assigned to you upon
     *  registration. Can be found on the "Account" section of the ZooZ
     *  Developer Portal.
     * @param boolean $isSandbox -True to use sandbox environment,
     *  false to use live environment.
     */
    function __construct($developerId, $apiKey, $isSandbox) {
        self::$developerId = $developerId;
        self::$apiKey = $apiKey;

        if ($isSandbox) {
            self::$zoozServer = ZooZExtendedServerAPI::SANDBOX_URL;
            curl_setopt($this->ch, CURLOPT_SSL_VERIFYPEER, 0);
        } else {
            self::$zoozServer = ZooZExtendedServerAPI::PRODUCTION_URL;
        }
        self::$zoozServer .= "mobile/ExtendedServerAPI";

    }
}

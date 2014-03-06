package com.zooz.extended.java.lib.AbstractClasses;

import com.zooz.extended.java.lib.ZooZExtendedServerAPI;
import com.zooz.extended.java.lib.exception.ZooZException;
import com.zooz.extended.java.lib.model.NVPs;
import com.zooz.extended.java.lib.model.enums.Commands;
import com.zooz.extended.java.lib.sample.ZooZExtendedServerAPISample;
import com.zooz.extended.java.lib.utils.ZooZJSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Developer: Roy Keynan
 */
public abstract class AbstractCommand {

    private static final String VERSION_NUMBER = "1.1.1";
    private JSONObject responseFromZooZ = null;
    protected NVPs nvps = new NVPs();

    protected AbstractCommand() {
        nvps.add("cmd", getCommand().name());
        nvps.add("ver", VERSION_NUMBER);
    }

    protected abstract Commands getCommand();

    public JSONObject postToZooZ() throws ZooZException {

        Writer writer = null;
        BufferedReader reader = null;
        StringBuilder resultSB = new StringBuilder();
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) new URL(ZooZExtendedServerAPI.getZoozServer() + "mobile/ExtendedServerAPI")
                    .openConnection();
            conn.setDoOutput(true);

            // set bundleId and apiKey for authentication to ZooZ secured server
            conn.setRequestProperty("ZooZDeveloperId", ZooZExtendedServerAPI.getZoozDeveloperId());
            conn.setRequestProperty("ZooZServerAPIKey", ZooZExtendedServerAPI.getZoozServerAPIKey());

            conn.setReadTimeout(30000);
            conn.setConnectTimeout(30000);

            // Send data
            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(nvps.toString());
            writer.flush();

            // Get the response
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                resultSB.append(line);
            }

        } catch (IOException ex) {
            throw new ZooZException("Error communicating with ZooZ server, please check your network connection and servers URLs");
        } finally {
            try {
                if (writer != null)
                    writer.close();
                if (reader != null)
                    reader.close();
            } catch (IOException ignored) {
            }
        }

        String res = resultSB.toString();

        try {
            responseFromZooZ = new JSONObject(res);
            return responseFromZooZ;
        } catch (JSONException e) {
            throw new ZooZException(res);
        }
    }


    /**
     * Writing the transactions into the generated log file.
     */
    public void writeToLogger() {
        int responseStatus = responseFromZooZ.getInt("ResponseStatus");
        JSONObject responseObjectJson = ZooZJSONUtils.getJSONObject(responseFromZooZ, "ResponseObject");
        if (responseStatus != 0)
            ZooZExtendedServerAPISample.LOGGER.severe(responseFromZooZ.toString(4));
        else
            ZooZExtendedServerAPISample.LOGGER.info(responseFromZooZ.toString(4));
        ZooZExtendedServerAPISample.LOGGER.info("// -------------------------------");
    }

}

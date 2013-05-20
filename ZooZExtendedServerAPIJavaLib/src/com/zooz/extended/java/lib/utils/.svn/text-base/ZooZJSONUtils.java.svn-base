package com.zooz.extended.java.lib.utils;

import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class ZooZJSONUtils {
	
	
	public static String getDecodedString(JSONObject jsonObject, String key) throws JSONException {
		try {
			return URLDecoder.decode(getString(jsonObject, key), "UTF-8");
		} catch (Exception e) {
			// do nothing
		}
		return null;
	}
	
	public static String getString(JSONObject jsonObject, String key) throws JSONException {
		if (!jsonObject.isNull(key)) {
			return jsonObject.getString(key);
		}
		return null;
	}
	
	public static double getDouble(JSONObject jsonObject, String key) throws JSONException {
		if (!jsonObject.isNull(key)) {
			return jsonObject.getDouble(key);
		}
		return 0;
	}

	public static JSONObject getJSONObject(JSONObject jsonObject, String key) throws JSONException {
		if (!jsonObject.isNull(key)) {
			return jsonObject.getJSONObject(key);
		}
		return null;
	}
	
	public static boolean getBoolean(JSONObject jsonObject, String key) throws JSONException {
		if (!jsonObject.isNull(key)) {
			return jsonObject.getBoolean(key);
		}
		return false;
	}
}

package com.zooz.mobileweb.java.lib.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.zooz.mobileweb.java.lib.utils.ZooZStringUtils;


public class NVPs {

	private List<NameValuePair> nameValuePairs;
	
	public NVPs() {
		this.nameValuePairs = new ArrayList<NVPs.NameValuePair>();
	}
	
	public List<NameValuePair> getNameValuePairs() {
		return nameValuePairs;
	}

	public void add(String name, String value) {
		if (!ZooZStringUtils.isEmpty(name) && !ZooZStringUtils.isEmpty(value)) {
			nameValuePairs.add(new NameValuePair(name, value));
		}
	}
	
	public void addDouble(String name, double doubleValue) {
		add(name, String.valueOf(doubleValue));
	}
	
	public void addAll(NVPs nvps) {
		nameValuePairs.addAll(nvps.getNameValuePairs());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (NameValuePair nameValuePair : nameValuePairs) {
			try {
				sb.append('&').append(nameValuePair.getName()).append('=').append(URLEncoder.encode(nameValuePair.getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// Do nothing
			}
		}
		
		return sb.toString();
	}
	
	private class NameValuePair{
		private String name;
		private String value;
		
		public NameValuePair(String name, String value) {
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		
		public String getValue() {
			return value;
		}
	}

}

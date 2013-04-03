package com.zooz.mobileweb.java.lib.exception;

public class ZooZException extends Exception {

	private static final long serialVersionUID = 6144431696368169486L;
	
	public ZooZException() {
		super();
	}
	
	public ZooZException(Throwable e) {
		super(e);
	}
	
	public ZooZException(String message) {
		super(message);
	}

}

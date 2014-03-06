package com.zooz.extended.java.lib.exception;

public class ZooZException extends Exception {

	private static final long serialVersionUID = 6144431696368169486L;
	
	private int errorCode;
	
	public ZooZException() {
		super();
		this.errorCode = -1;
	}
	
	public ZooZException(Throwable e) {
		super(e);
		this.errorCode = -1;
	}
	
	public ZooZException(String message) {
		this(message, -1);
	}
	
	public ZooZException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

}

package com.configapi.configuration.exceptions;


public class ConfigNotFoundException extends Exception{
	
	static String message = "Config file not found.";
	static final long serialVersionUID = 1L;

	public ConfigNotFoundException() {
		super(message);
	}
}

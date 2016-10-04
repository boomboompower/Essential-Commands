package com.configapi.configuration.exceptions;

import net.md_5.bungee.api.ChatColor;

public class ConfigNotFoundException extends Exception{
	
	static String message = ChatColor.RED + "Config file not found.";
	static final long serialVersionUID = 1L;

	public ConfigNotFoundException() {
		super(message);
	}
}

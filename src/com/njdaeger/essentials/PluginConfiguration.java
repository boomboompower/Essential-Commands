package com.njdaeger.essentials;

import com.configapi.configuration.PluginConfig;

public class PluginConfiguration {
	
	public static void generateNewConfig() {
		if (PluginConfig.isFound() == true) {
			PluginConfig.getConfig().set("test", true);
			PluginConfig.save();
		}
		else {
			PluginConfig.newConfig();
			PluginConfig.getConfig().set("test", false);
			PluginConfig.save();
		}
	}
	
}

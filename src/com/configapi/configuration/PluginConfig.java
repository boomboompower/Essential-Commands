package com.configapi.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.configapi.configuration.exceptions.ConfigNotFoundException;

public class PluginConfig{
	
	static Plugin plug = Bukkit.getPluginManager().getPlugin("EssentialCommands");
	
	public static void newConfig() {
		File dir = new File("plugins"+File.separator+plug.getName());
		File file = new File("plugins"+File.separator+plug.getName()+File.separator+"config.yml");
		if (!file.exists()) {
			dir.mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else Bukkit.getLogger().info("EssentialCommands config file found.");
	}
	public static YamlConfiguration getConfig() {
		File file = new File("plugins"+File.separator+plug.getName()+File.separator+"config.yml");
		if (!file.exists()) {
			newConfig();
		}
		else {
			YamlConfiguration pluginConfiguration = YamlConfiguration.loadConfiguration(file);
			return pluginConfiguration;
		}
		return null;
	}
	public static void save() {
		File file = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"config.yml");
		YamlConfiguration pluginConfiguration = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			try {
				throw new ConfigNotFoundException();
			} catch (ConfigNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				pluginConfiguration.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.configapi.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.configapi.configuration.exceptions.ConfigExistsException;
import com.configapi.configuration.exceptions.ConfigNotFoundException;

public class PlayerConfig {
	
	
	public static void newPlayerConfig(String directory, Player p) {
		File file = new File(directory+File.separator+p.getUniqueId());
		File dir = new File(directory);
		if (!file.exists()) {
			dir.mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else throw new ConfigExistsException();
	}
	public static YamlConfiguration getPlayerConfig(Player p, String directory) {
		/*
		 * throw exception somewhere
		 */
		File file = new File(directory+File.separator+p.getUniqueId());
		if (!file.exists()) {
			try {
				throw new ConfigNotFoundException();
			} catch (ConfigNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			return config;
		}
		return null;
		
	}
	public static void set(Player p, String directory, String path, String value) {
		getPlayerConfig(p, directory).set(path, value);
	}
}

	

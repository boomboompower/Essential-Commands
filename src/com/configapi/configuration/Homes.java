package com.configapi.configuration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.configapi.configuration.exceptions.HomeNotFoundException;

public class Homes {
	
	public static void createHome(String name, Player player) {
		UUID userID = player.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID);
		File dir1 = new File(dir+File.separator+"homes");
		File dir2 = new File(dir1+name+".yml");
		if (dir.exists()) {
			if (dir1.exists()) {
				if (dir2.exists()) {
					return;
				}
				else {
					try {
						dir2.createNewFile();
						YamlConfiguration home = YamlConfiguration.loadConfiguration(dir2);
						home.set("x", player.getLocation().getX());
						home.set("y", player.getLocation().getY());
						home.set("z", player.getLocation().getZ());
						home.set("pitch", player.getLocation().getPitch());
						home.set("yaw", player.getLocation().getYaw());
						home.set("world", player.getLocation().getWorld());
						home.save(dir2);
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				dir1.mkdirs();
				try {
					dir2.createNewFile();
					YamlConfiguration home = YamlConfiguration.loadConfiguration(dir2);
					home.set("x", player.getLocation().getX());
					home.set("y", player.getLocation().getY());
					home.set("z", player.getLocation().getZ());
					home.set("pitch", player.getLocation().getPitch());
					home.set("yaw", player.getLocation().getYaw());
					home.set("world", player.getLocation().getWorld());
					home.save(dir2);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			dir.mkdirs();
			dir1.mkdirs();
			try {
				dir2.createNewFile();
				YamlConfiguration home = YamlConfiguration.loadConfiguration(dir2);
				home.set("x", player.getLocation().getX());
				home.set("y", player.getLocation().getY());
				home.set("z", player.getLocation().getZ());
				home.set("pitch", player.getLocation().getPitch());
				home.set("yaw", player.getLocation().getYaw());
				home.set("world", player.getLocation().getWorld());
				home.save(dir2);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static YamlConfiguration getHome(String name, Player player) {
		UUID userID = player.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID+File.separator+"homes"+File.separator+name+".yml");
		if (dir.exists()) {
			YamlConfiguration home = YamlConfiguration.loadConfiguration(dir);
			return home;
		}
		else {
			return null;
		}
	}
	public static void removeHome(String name, Player player) {
		UUID userID = player.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID+File.separator+"homes"+File.separator+name+".yml");
		if (dir.exists()) {
			dir.delete();
			return;
		}
		else {
			throw new HomeNotFoundException();
		}
		
	}
	public static String listHomes(String name, Player player) {
		UUID userID = player.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID+File.separator+"homes");
		if (dir.exists()) {
			File[] homes = dir.listFiles();
			for (File file : homes) {
				if (file.isFile()) {
					return file.getName();
				}
				else return null;
			}
		}
		else {
			throw new HomeNotFoundException();
		}
		return null;
	}
}

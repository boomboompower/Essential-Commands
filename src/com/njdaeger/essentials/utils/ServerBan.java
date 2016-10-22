package com.njdaeger.essentials.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Permission;

public class ServerBan {
	
	/**
	 * @param target - Target player to ban
	 * @param reason - Ban reason
	 * @param bancreator - Creator of the ban, if null then it defaults to the console.
	 * @param kickmessage - Player kick message.
	 */
	public static void newPermBan(Player target, String reason, String bancreator, String kickmessage) {
		UUID userID = target.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID);
		File dir1 = new File(dir+File.separator+"user.yml");
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(dir1);
		if (!dir.exists()) {
			return;
		}
		if (!dir1.exists()) {
			return;
		}
		if (reason == null) {
			reason += " The ban hammer has spoken!";
		}
		if(bancreator == null) {
			bancreator += " CONSOLE";
		}
		Bukkit.getServer().getBanList(Type.NAME).addBan(target.getName(), reason, null, bancreator);
		configuration.set("banned", true);
		try {
			configuration.save(dir1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		target.kickPlayer(kickmessage);
		Bukkit.broadcast(ChatColor.RED + target.getName() + ChatColor.GRAY + " has been banned for:" + reason , Permission.ESS_BAN_NOTIFY.getPermission());
	}
	/**
	 * @param target - Target player to ban
	 * @param reason - Ban reason
	 * @param bancreator - Creator of the ban, if null then it defaults to the console.
	 * @param time - Temp ban time in days
	 * @param kickmessage - Player kick message.
	 */
	public static void newTempBan(Player target, String reason, String bancreator, double time, String kickmessage) {
		UUID userID = target.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID);
		File dir1 = new File(dir+File.separator+"user.yml");
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(dir1);
		if (!dir.exists()) {
			return;
		}
		if (!dir1.exists()) {
			return;
		}
		if (reason == null) {
			reason += " The ban hammer has spoken!";
		}
		if(bancreator == null) {
			bancreator += " CONSOLE";
		}
		Bukkit.getServer().getBanList(Type.NAME).addBan(target.getName(), reason, null, bancreator);
		double basetime = Double.parseDouble(Util.getCurrentTime().toString());
		double bantime = time + (60000*60*24);
		double bantimefinal = basetime + bantime;
		configuration.set("unbantime", bantimefinal);
		configuration.set("banned", true);
		try {
			configuration.save(dir1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		target.kickPlayer(kickmessage);
		Bukkit.broadcast(reason, Permission.ESS_BAN_NOTIFY.getPermission());
	}
	public static void unban(Player player) {
		UUID userID = player.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID);
		File dir1 = new File(dir+File.separator+"user.yml");
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(dir1);
		if (!dir.exists()) {
			return;
		}
		if (!dir1.exists()) {
			return;
		}
		if (configuration.get("banned").equals(true) && !configuration.get("unbantime").equals(null)) {
			configuration.set("banned", false);
			configuration.set("unbantime", null);
			try {
				configuration.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (configuration.get("banned").equals(false) && !configuration.get("unbantime").equals(null)) {
			configuration.set("unbantime", null);
			try {
				configuration.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (configuration.get("banned").equals(true) && configuration.get("unbantime").equals(null)) {
			configuration.set("banned", false);
			try {
				configuration.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			return;
		}
	}
	
}

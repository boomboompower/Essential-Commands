package com.njdaeger.essentials.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.BanMessage;
import com.njdaeger.essentials.enums.Error;
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
			reason += BanMessage.BANNED_NOREASON.banNoReason();
		}
		if(bancreator == null) {
			bancreator += "CONSOLE";
		}
		configuration.set("banned", true);
		try {
			configuration.save(dir1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		target.kickPlayer(kickmessage);
		Bukkit.broadcast(ChatColor.RED + target.getName() + ChatColor.GRAY + " has been perm-banned by " + bancreator + " for: " + ChatColor.RED + reason , Permission.ESS_BAN_NOTIFY.getPermission());
	}
	/**
	 * @param target - Target player to ban
	 * @param reason - Ban reason
	 * @param bancreator - Creator of the ban, if null then it defaults to the console.
	 * @param time - Temp ban time with proper format.
	 */
	public static void newTempBan(Player target, String reason, CommandSender bancreator, String time) {
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
		if (!time.contains(":")) {
			bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
			return;
		}
		String units = "";
		
		
		
		if (time.contains("d")) {
			String[] split = time.split(":");
			units += "day(s)";
			if (!Util.isNumber(split[0])) {
				bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
				return;
			}
			if (Util.isNumber(split[1])) {
				bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
				return;
			}
			long a = Long.parseLong(split[0]);
			long bantime = TimeUnit.DAYS.toMillis(a) + System.currentTimeMillis();
			configuration.set("unbantime", bantime);
			configuration.set("banned", true);
			try {
				configuration.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			target.kickPlayer(ServerBan.freason(target, bancreator, reason, split[0], units));
			Bukkit.broadcast(ServerBan.freason(target, bancreator, reason, split[0], units), Permission.ESS_BAN_NOTIFY.getPermission());
			return;
		}
		
		
		if (time.contains("h")) {
			String[] split = time.split(":");
			units += "hours(s)";
			if (!Util.isNumber(split[0])) {
				bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
				return;
			}
			if (Util.isNumber(split[1])) {
				bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
				return;
			}
			long a = Long.parseLong(split[0]);
			long bantime = TimeUnit.HOURS.toMillis(a) + System.currentTimeMillis();
			configuration.set("unbantime", bantime);
			configuration.set("banned", true);
			try {
				configuration.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			target.kickPlayer(ServerBan.freason(target, bancreator, reason, split[0], units));
			Bukkit.broadcast(ServerBan.freason(target, bancreator, reason, split[0], units), Permission.ESS_BAN_NOTIFY.getPermission());
			return;
		}
		
		
		if (time.contains("m")) {
			String[] split = time.split(":");
			units += "minute(s)";
			if (!Util.isNumber(split[0])) {
				bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
				return;
			}
			if (Util.isNumber(split[1])) {
				bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
				return;
			}
			long a = Long.parseLong(split[0]);
			long bantime = TimeUnit.MINUTES.toMillis(a) + System.currentTimeMillis();
			configuration.set("unbantime", bantime);
			configuration.set("banned", true);
			try {
				configuration.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			target.kickPlayer(ServerBan.freason(target, bancreator, reason, split[0], units));
			Bukkit.broadcast(ServerBan.freason(target, bancreator, reason, split[0], units), Permission.ESS_BAN_NOTIFY.getPermission());
			return;
		}
		
		
		if (time.contains("s")) {
			String[] split = time.split(":");
			units += "second(s)";
			if (!Util.isNumber(split[0])) {
				bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
				return;
			}
			if (Util.isNumber(split[1])) {
				bancreator.sendMessage(Error.BAN_WRONG_FORMAT.sendError());
				return;
			}
			long a = Long.parseLong(split[0]);
			long bantime = TimeUnit.SECONDS.toMillis(a) + System.currentTimeMillis();
			configuration.set("unbantime", bantime);
			configuration.set("banned", true);
			try {
				configuration.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			target.kickPlayer(ServerBan.freason(target, bancreator, reason, split[0], units));
			Bukkit.broadcast(ServerBan.freason(target, bancreator, reason, split[0], units), Permission.ESS_BAN_NOTIFY.getPermission());
			return;
		}
		else {
			bancreator.sendMessage(Error.UNKNOWN_BAN_TYPE.sendError());
			return;
		}
		/*
		 * Add a compressing algorithm that when the player is banned it writes down the duration until unban. Then when the player joins it then 
		 */
	}
	
	
	/**
	 * @param player -  Target player to unban.
	 */
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
	private static String freason(Player target, CommandSender bancreator, String reason, String time, String units) {
		String freason1 = "";
		if (reason == null) {
			freason1 += ChatColor.RED + target.getName() + 
					ChatColor.GRAY + " has been temp-banned by " +
					ChatColor.GREEN + bancreator.getName() + ChatColor.GRAY + " for: " + 
					ChatColor.RED + BanMessage.TEMP_NOREASON.banNoReason() + 
					ChatColor.GRAY + ". Expires in: " + 
					ChatColor.RED + time + ChatColor.GRAY + " " + units;
			return freason1;
		}
		else {
			freason1 += ChatColor.RED + target.getName() + 
					ChatColor.GRAY + " has been temp-banned by " +
					ChatColor.GREEN + bancreator.getName() + ChatColor.GRAY + " for: " + 
					ChatColor.RED + BanMessage.TEMP_REASON.banReason(reason) + 
					ChatColor.GRAY + ". Expires in: " + 
					ChatColor.RED + time + ChatColor.GRAY + " " + units;
			return freason1;
		}
	}
}

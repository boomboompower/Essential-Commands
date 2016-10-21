package com.njdaeger.essentials.utils;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Permission;

public class ServerBan {
	
	public static void newPermBan(Player target, String reason, String bancreator) {
		if (reason == null) {
			reason += " The ban hammer has spoken!";
		}
		if(bancreator == null) {
			bancreator += " CONSOLE";
		}
		Bukkit.getServer().getBanList(Type.NAME).addBan(target.getName(), reason, null, bancreator);
		Bukkit.broadcast(ChatColor.RED + target.getName() + ChatColor.GRAY + " has been banned for:" + reason , Permission.ESS_BAN_NOTIFY.getPermission());
	}
	public static void newTempBan(Player target, String reason, String bancreator) {
		
	}
	
}

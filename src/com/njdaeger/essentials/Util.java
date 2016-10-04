package com.njdaeger.essentials;


import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import com.njdaeger.essentials.enums.Permission;

public class Util {
	public static void register(Permission permission) {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.addPermission(permission.registerPermission());
	}
	public static boolean isAfk(Player p) {
		if (Groups.afk.contains(p)) {
			return true;
		}
		else return false;
	}
	public static void setAfk(Player p) {
		if (Groups.afk.contains(p)) {
			Groups.afk.remove(p);
			Groups.afkloc.remove(p.getName(), p.getLocation());
			p.setCollidable(true);
			Bukkit.broadcastMessage(ChatColor.GRAY + "* " + p.getDisplayName() + ChatColor.GRAY + " is no longer AFK.");
			return;
		}
		else {
			Groups.afk.add(p);
			Groups.afkloc.put(p.getName(), p.getLocation());
			p.setCollidable(false);
			Bukkit.broadcastMessage(ChatColor.GRAY + "* " + p.getDisplayName() + ChatColor.GRAY + " is now AFK.");
			return;
		}
	}
	public static boolean isHidden(Player p) {
		if (Groups.vanish.contains(p)) {
			return true;
		}
		else return false;
	}
	public static void setHidden(Player p) {
		if (Groups.vanish.contains(p)) {
			Groups.vanish.remove(p);
			return;
		}
		else Groups.vanish.add(p);
	}
	public static boolean hasFullInventory(Player p) {
		if (p.getInventory().firstEmpty() == -1) {
			return true;
		}
		else return false;
	}
}

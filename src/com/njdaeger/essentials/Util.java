package com.njdaeger.essentials;


import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import com.njdaeger.essentials.enums.Permission;

public class Util {
	
	private static ChatColor gy = ChatColor.GRAY;
	private static ChatColor gr = ChatColor.GREEN;
	
	public static void generatePermissions() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		for (Permission perm : Permission.values()) {
			Bukkit.getLogger().info("Registered permission: " + perm.getPermission());
			pm.addPermission(perm.registerPermission());
		}
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
	public static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	public static boolean allowsMessaging(Player p) {
		if (Groups.nomessaging.contains(p)) {
			return false;
		}
		else return true;
	}
	public static void sendPM(Player target, CommandSender player, String message, boolean allowChatColor, boolean isPlayer) {
		if (isPlayer == true) {
			Player sender = (Player) player;
			if (allowChatColor == true) {
				target.sendMessage(gy + "[" + gr + sender.getDisplayName() + gy + " -> " + gr + "me" + gy + "] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', message));
				target.playSound(target.getLocation(), Sound.BLOCK_NOTE_HARP, 2, 1);
				sender.sendMessage(gy + "[" + gr + "me" + gy + " -> " + gr + target.getDisplayName() + gy + "] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', message));
				return;
			}
			else {
				target.sendMessage(gy + "[" + gr + sender.getDisplayName() + gy + " ->" + gr + "me" + gy + "] " + ChatColor.RESET + message);
				target.playSound(target.getLocation(), Sound.BLOCK_NOTE_HARP, 2, 1);
				sender.sendMessage(gy + "[" + gr + "me" + gy + " -> " + gr + target.getDisplayName() + gy + "] " + ChatColor.RESET + message);
				return;
			}
		}
		else {
			target.sendMessage(gy + "[" + gr + player.getName() + gy + " -> " + gr + "me" + gy + "] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', message));
			player.sendMessage(gy + "[" + gr + "me" + gy + " -> " + gr + target.getDisplayName() + gy + "] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', message));
			return;
		}
	}
}

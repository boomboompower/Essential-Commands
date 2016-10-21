package com.njdaeger.essentials.utils;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.njdaeger.essentials.Groups;
import com.njdaeger.essentials.enums.Permission;

public class Util {
	
	private static ChatColor gy = ChatColor.GRAY;
	private static ChatColor gr = ChatColor.GREEN;
	
	//#####MISC#####//
	public static void generatePermissions() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		for (Permission perm : Permission.values()) {
			Bukkit.getLogger().info("Registered permission: " + perm.getPermission());
			pm.addPermission(perm.registerPermission());
		}
	}
	public static boolean hasFullInventory(Player p) {
		if (p.getInventory().firstEmpty() == -1) {
			return true;
		}
		else return false;
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
	public static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	//#####CHECK_GROUPS#####//
	public static boolean isAfk(Player p) {
		if (Groups.afk.contains(p)) {
			return true;
		}
		else return false;
	}
	public static boolean isHidden(Player p) {
		if (Groups.vanish.contains(p)) {
			return true;
		}
		else return false;
	}
	public static boolean allowsMessaging(Player p) {
		if (Groups.nomessaging.contains(p)) {
			return false;
		}
		else return true;
	}
	public static boolean canTP(Player p) {
		if (Groups.tptoggled.contains(p)) {
			return false;
		}
		else return true;
	}
	public static boolean isMuted(Player p) {
		if (Groups.muted.contains(p)) {
			return true;
		}
		else return false;
	}
	public static boolean isSpying(Player p) {
		if (Groups.socialspy.contains(p)) {
			return true;
		}
		else return false;
	}
	public static boolean isGod(Player p) {
		if (Groups.god.contains(p)) {
			return true;
		}
		else return false;
	}
	
	/*
	 * 
	 * 
	 * ####################
	 * NICKNAME
	 * ####################
	 * 
	 * 
	 */
	public static void setNick(Player p, String nickname) {
		UUID userID = p.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID);
		File dir1 = new File(dir+File.separator+"user.yml");
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(dir1);
		if (!dir.exists()) {
			return;
		}
		if (!dir1.exists()) {
			return;
		}
		else {
			p.setDisplayName(ChatColor.translateAlternateColorCodes('&', nickname) + ChatColor.WHITE);
			configuration.set("displayname", nickname);
			try {
				configuration.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/*
	 * 
	 * 
	 * ####################
	 * HIDDENSTATUS
	 * ####################
	 * 
	 * 
	 */
	public static void setHidden(Player p) {
		if (Groups.vanish.contains(p)) {
			Groups.vanish.remove(p);
			p.showPlayer(p);
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
			return;
		}
		else {
			Groups.vanish.add(p);
			p.hidePlayer(p);
			PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1, false, false);
			p.addPotionEffect(effect);
		}
	}
	public static void getPlayerTime(Player target) {
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
		Object time = configuration.get("logout");
	}
}

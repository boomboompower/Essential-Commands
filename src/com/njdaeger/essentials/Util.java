package com.njdaeger.essentials;


import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import com.njdaeger.essentials.enums.Permission;
import com.njdaeger.essentials.exceptions.UnknownStatusException;

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
	 * ####################
	 * AFKSTATUS
	 * ####################
	 */
	public static void setAfk(Player p, AfkStatus status) {
		if (status.equals(AfkStatus.AUTO)) {
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
		if (status.equals(AfkStatus.TRUE)) {
			if (!Groups.afk.contains(p)) {
				Groups.afk.add(p);
				return;
			}
			else return;
		}
		if (status.equals(AfkStatus.FALSE)) {
			if (Groups.afk.contains(p)) {
				Groups.afk.remove(p);
				return;
			}
			else return;
		}
		else throw new UnknownStatusException();
	}
	
	/*
	 * ####################
	 * MUTESTATUS
	 * ####################
	 */
	public static void setMuted(Player p, MuteStatus status) {
		if (status.equals(MuteStatus.AUTO)) {
			if (Groups.muted.contains(p)) {
				Groups.muted.remove(p);
				p.sendMessage(ChatColor.GRAY + "You are no longer muted.");
				return;
			}
			else {
				Groups.muted.add(p);
				p.sendMessage(ChatColor.GRAY + "You have been muted.");
				return;
			}
		}
		if (status.equals(MuteStatus.TRUE)) {
			if (!Groups.muted.contains(p)) {
				Groups.muted.add(p);
				return;
			}
			else return;
		}
		if (status.equals(MuteStatus.FALSE)) {
			if (Groups.muted.contains(p)) {
				Groups.muted.remove(p);
				return;
			}
			else return;
		}
		else throw new UnknownStatusException();
	}
	
	/*
	 * ####################
	 * SPYSTATUS
	 * ####################
	 */
	public static void setSpying(Player p, SpyStatus status) {
		/*
		 * need to create a check to see if the method sender was either the plugin or a player issued command. 
		 */
		if (status.equals(SpyStatus.AUTO)) {
			if (Groups.socialspy.contains(p)) {
				Groups.socialspy.remove(p);
				p.sendMessage(ChatColor.GRAY + "You are no longer muted.");
				return;
			}
			else {
				Groups.socialspy.add(p);
				p.sendMessage(ChatColor.GRAY + "You have been muted.");
				return;
			}
		}
		if (status.equals(SpyStatus.TRUE)) {
			
		}
		if (status.equals(SpyStatus.FALSE)) {
			
		}
		else throw new UnknownStatusException();
	}
	
	/*
	 * ####################
	 * HIDDENSTATUS
	 * ####################
	 */
	public static void setHidden(Player p) {
		if (Groups.vanish.contains(p)) {
			Groups.vanish.remove(p);
			p.showPlayer(p);
			return;
		}
		else {
			Groups.vanish.add(p);
			p.hidePlayer(p);
		}
	}
	
	/*
	 * ####################
	 * GODSTATUS
	 * ####################
	 */
	public static void setGod(Player p, CommandSender sndr) {
		if (Groups.god.contains(p)) {
			Groups.god.remove(p);
			p.setInvulnerable(false);
			if (p.equals(sndr)) {
				p.sendMessage(ChatColor.GRAY + "You are no longer in God mode.");
			}
			else {
				sndr.sendMessage(ChatColor.GRAY + "You turned off " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + "'s God mode.");
				p.sendMessage(ChatColor.GRAY + "You are no longer in God mode.");
			}
			
		}
		else {
			Groups.god.add(p);
			p.setInvulnerable(true);
			if (p.equals(sndr)) {
				p.sendMessage(ChatColor.GRAY + "You are now in God mode.");
			}
			else {
				sndr.sendMessage(ChatColor.GRAY + "You set " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + " to God mode.");
				p.sendMessage(ChatColor.GRAY + "You are now in God mode.");
			}
		}
	}
	
	/*
	 * ####################
	 * MESSAGINGSTATUS
	 * ####################
	 */
	public static void setMessaging(Player p, boolean allow) {
		if (allow == true) {
			if (Groups.nomessaging.contains(p)) {
				Groups.nomessaging.remove(p);
			}
			else return;
		}
		else {
			if (!Groups.nomessaging.contains(p)) {
				Groups.nomessaging.add(p);
			}
			else return;
		}
	}
	
	
	/*
	 * 
	 * StatusTypes and possible values.
	 * 
	 */
	public enum AfkStatus {
		AUTO, 
		TRUE, 
		FALSE;
	}
	public enum MuteStatus {
		AUTO, 
		TRUE,
		FALSE;
	}
	public enum SpyStatus {
		AUTO,
		TRUE,
		FALSE;
	}
}

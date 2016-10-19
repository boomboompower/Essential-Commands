package com.njdaeger.essentials.utils;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.Groups;
import com.njdaeger.essentials.exceptions.UnknownStatusException;

/**
 * Socialspy enable or disable for player.
 *
 */
public class SpyStatus {
	
	/**
	 * For command usage, sends a message to the player and the sender. 
	 * @param p - Target to effect.	
	 * @param status - Auto, True, or False.
	 * @param sender - The command sender.
	 * @see Status
	 */
	public static void setSpying(Player p, Status status, CommandSender sender) { //For Commands
		if (status.equals(Status.AUTO)) {
			if (p.equals(sender)) {
				if (Groups.socialspy.contains(p)) {
					Groups.socialspy.remove(p);
					p.sendMessage("Socialspy is now disabled.");
					return;
				}
				else {
					Groups.socialspy.add(p);
					p.sendMessage(ChatColor.GRAY + "Socialspy is now enabled.");
					return;
				}
			}
			else {
				if (Groups.socialspy.contains(p)) {
					Groups.socialspy.remove(p);
					sender.sendMessage(ChatColor.GRAY + "Socialspy is now disabled for " + ChatColor.GREEN + p.getName());
					p.sendMessage(ChatColor.GRAY + "Socialspy is now disabled.");
					return;
				}
				else {
					Groups.socialspy.add(p);
					sender.sendMessage(ChatColor.GRAY + "Socialspy is now enabled for " + ChatColor.GREEN + p.getName());
					p.sendMessage(ChatColor.GRAY + "Socialspy is now enabled.");
					return;
				}
			}	
		}
		if (status.equals(Status.TRUE)) {
			if (p.equals(sender)) {
				if (!Groups.socialspy.contains(p)) {
					Groups.socialspy.add(p);
					p.sendMessage(ChatColor.GRAY + "Socialspy is now enabled.");
					return;
				}
				else return;
			}
			else {
				if (!Groups.socialspy.contains(p)) {
					Groups.socialspy.add(p);
					sender.sendMessage(ChatColor.GRAY + "Socialspy is now enabled for " + ChatColor.GREEN + p.getName());
					p.sendMessage(ChatColor.GRAY + "Socialspy is now enabled.");
					return;
				}
				else return;
			}
		}
		if (status.equals(Status.FALSE)) {
			if (p.equals(sender)) {
				if (Groups.socialspy.contains(p)) {
					Groups.socialspy.remove(p);
					p.sendMessage(ChatColor.GRAY + "Socialspy is now disabled.");
					return;
				}
				else return;
			}
			else {
				if (Groups.socialspy.contains(p)) {
					Groups.socialspy.remove(p);
					sender.sendMessage(ChatColor.GRAY + "Socialspy is now disabled for " + ChatColor.GREEN + p.getName());
					p.sendMessage(ChatColor.GRAY + "Socialspy is now disabled.");
					return;
				}
				else return;
			}
		}
		else throw new UnknownStatusException();
	}
	/**
	 * For plugin use. Sets them silently.
	 * @param p - Target to effect.	
	 * @param status - Auto, True, or False.
	 * @see Status
	 */
	public static void setSpying(Player p, Status status) { //For Plugin
		if (status.equals(Status.AUTO)) {
			if (Groups.socialspy.contains(p)) {
				Groups.socialspy.remove(p);
				return;
			}
			else {
				Groups.socialspy.add(p);
				return;
			}
		}
		if (status.equals(Status.TRUE)) {
			if (!Groups.socialspy.contains(p)) {
				Groups.socialspy.add(p);
				return;
			}
			else return;
		}
		if (status.equals(Status.FALSE)) {
			if (Groups.socialspy.contains(p)) {
				Groups.socialspy.remove(p);
				return;
			}
			else return;
		}
		else throw new UnknownStatusException();
	}
}

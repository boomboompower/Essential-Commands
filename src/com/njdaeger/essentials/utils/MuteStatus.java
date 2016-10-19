package com.njdaeger.essentials.utils;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.Groups;
import com.njdaeger.essentials.exceptions.UnknownStatusException;

 /**
 * MuteStatus sets the player muted or not. 
 */

public class MuteStatus { 
	 
	/**
	 * For regular command usage, sends a message to sender and target.
	 * @param target - Target to effect.
	 * @param status - Auto, True, or False.
	 * @param sender - The command sender.
	 * @see Status 
	 */
	public static void setMuted(Player target, Status status, CommandSender sender) { //For commands.
		if (status.equals(Status.AUTO)) {
			if (target.equals(sender)) {
				if (Groups.muted.contains(target)) {
					Groups.muted.remove(target);
					target.sendMessage(ChatColor.GRAY + "You are no longer muted.");
					return;
				}
				else {
					Groups.muted.add(target);
					target.sendMessage(ChatColor.GRAY + "You have been muted.");
					return;
				}
			}
			else {
				if (Groups.muted.contains(target)) {
					Groups.muted.remove(target);
					sender.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " is no longer muted.");
					target.sendMessage(ChatColor.GRAY + "You are no longer muted.");
					return;
				}
				else {
					Groups.muted.add(target);
					sender.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " is now muted.");
					target.sendMessage(ChatColor.GRAY + "You have been muted.");
					return;
				}
			}
		}
		if (status.equals(Status.TRUE)) {
			if(target.equals(sender)) {
				if (!Groups.muted.contains(target)) {
					Groups.muted.add(target);
					target.sendMessage(ChatColor.GRAY + "You are now muted.");
					return;
				}
				else return;
			}
			else {
				if (!Groups.muted.contains(target)) {
					Groups.muted.add(target);
					sender.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " is now muted.");
					target.sendMessage(ChatColor.GRAY + "You are now muted.");
					return;
				}
				else return;
			}
		}
		if (status.equals(Status.FALSE)) {
			if(target.equals(sender)) {
				if (Groups.muted.contains(target)) {
					Groups.muted.remove(target);
					target.sendMessage(ChatColor.GRAY + "You are now unmuted.");
					return;
				}
				else return;
			}
			else {
				if (Groups.muted.contains(target)) {
					Groups.muted.remove(target);
					target.sendMessage(ChatColor.GRAY + "You are now unmuted.");
					sender.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " is no longer muted.");
					return;
				}
				else return;
			}
		}
		else throw new UnknownStatusException();
	}
	/**
	 * For plugin backend use. Meant for silent switching. 
	 * @param target - Target to effect.
	 * @param status - Auto, True, or False. 
	 * @see Status 
	 */
	public static void setMuted(Player target, Status status) { //For plugin
		if (status.equals(Status.AUTO)) {
			if (Groups.muted.contains(target)) {
				Groups.muted.remove(target);
				return;
			}
			else {
				Groups.muted.add(target);
				return;
			}
		}
		if (status.equals(Status.TRUE)) {
			if (!Groups.muted.contains(target)) {
				Groups.muted.add(target);
				return;
			}
			else return;
		}
		if (status.equals(Status.FALSE)) {
			if (Groups.muted.contains(target)) {
				Groups.muted.remove(target);
				return;
			}
			else return;
		}
		else throw new UnknownStatusException();
	}
}

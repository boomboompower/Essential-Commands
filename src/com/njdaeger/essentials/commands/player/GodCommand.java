package com.njdaeger.essentials.commands.player;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;

public class GodCommand extends BukkitCommand{
	
	public GodCommand() {
		super("god");
		this.description = "Make yourself unkillable.";
		this.usageMessage = "/god [player]";
		this.setPermission(Permission.ESS_GOD.getPermission());
		this.setPermission(Permission.ESS_GOD_OTHER.getPermission());
		this.setPermission(Permission.ESS_ALL.getPermission());
		this.setPermissionMessage(Error.NO_PERMISSION.sendError());
	}

	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		if (sndr instanceof Player) {
			if (args.length == 1) {
				if (sndr.hasPermission(Permission.ESS_GOD_OTHER.getPermission()) || sndr.isOp() || sndr.hasPermission(Permission.ESS_ALL.getPermission())) {
					if (Bukkit.getPlayer(args[0]) == null) {
						sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
						return true;
					}
					Player target = Bukkit.getPlayer(args[0]);
					if (!target.isInvulnerable()) {
						sndr.sendMessage(ChatColor.GRAY + "You set " + ChatColor.GREEN + target.getName() + ChatColor.GRAY + " to God mode.");
						target.sendMessage(ChatColor.GRAY + "You are now in God mode.");
						target.setInvulnerable(true);
						return true;
					}
					else {
						sndr.sendMessage(ChatColor.GRAY + "You turned off " + ChatColor.GREEN + target.getName() + ChatColor.GRAY + "'s God mode.");
						target.sendMessage(ChatColor.GRAY + "You are no longer in God mode.");
						target.setInvulnerable(false);
						return true;
					}
				}
				else {
					sndr.sendMessage(Error.NO_PERMISSION.sendError());
					return true;
				}
			}
			if (args.length == 0) {
				Player player = (Player) sndr;
				if (!player.isInvulnerable()) {
					sndr.sendMessage(ChatColor.GRAY + "You are now in God mode.");
					player.setInvulnerable(true);
					return true;
				}
				else {
					sndr.sendMessage(ChatColor.GRAY + "You are no longer in God mode.");
					player.setInvulnerable(false);
					return true;
				}
			}
			else {
				sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
				return true;
			}
		}
		else {
			if (args.length == 0) {
				sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
				return true;
			}
			if (args.length == 1) {
				if (Bukkit.getPlayer(args[0]) == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				Player target = Bukkit.getPlayer(args[0]);
				if (!target.isInvulnerable()) {
					sndr.sendMessage(ChatColor.GRAY + "You set " + ChatColor.GREEN + target.getName() + ChatColor.GRAY + " to God mode.");
					target.sendMessage(ChatColor.GRAY + "You are now in God mode.");
					target.setInvulnerable(true);
					return true;
				}
				else {
					sndr.sendMessage(ChatColor.GRAY + "You turned off " + ChatColor.GREEN + target.getName() + ChatColor.GRAY + "'s God mode.");
					target.sendMessage(ChatColor.GRAY + "You are no longer in God mode.");
					target.setInvulnerable(false);
					return true;
				}
			}
			else {
				sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
				return true;
			}
		}
	}	
}

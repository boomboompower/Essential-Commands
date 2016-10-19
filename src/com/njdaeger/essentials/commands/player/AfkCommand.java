package com.njdaeger.essentials.commands.player;


import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;
import com.njdaeger.essentials.utils.Util;
import com.njdaeger.essentials.utils.Util.AfkStatus;

public class AfkCommand extends BukkitCommand{

	public AfkCommand() {
		super("afk");
		List<String> a = Arrays.asList("akf", "away", "brb");
		this.description = "Mark yourself as away from keyboard.";
		this.usageMessage = "/afk [player]";
		this.setPermission(Permission.ESS_AFK.getPermission());
		this.setPermission(Permission.ESS_AFK_OTHER.getPermission());
		this.setPermission(Permission.ESS_ALL.getPermission());
		this.setPermissionMessage(Error.NO_PERMISSION.sendError());
		this.setAliases(a);
	}
	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		
		if (!(sndr instanceof Player)) {
			if (args.length == 1) {
				if (Bukkit.getPlayer(args[0]) == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				else {
					Player player = Bukkit.getPlayer(args[0]);
					Util.setAfk(player, AfkStatus.AUTO);
					return true;
				}
			} 
			if (args.length == 0) {
				sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
				return true;
			} 
			else {
				sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
				return true;
			}
		}
		if (args.length == 1) {
			if(sndr.hasPermission(Permission.ESS_AFK_OTHER.getPermission()) || 
					sndr.hasPermission(Permission.ESS_ALL.getPermission()) || sndr.isOp()) {
				if (Bukkit.getPlayer(args[0]) == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				else {
					Player player = Bukkit.getPlayer(args[0]);
					Util.setAfk(player, AfkStatus.AUTO);
					return true;
				}
			} 
			else {
				sndr.sendMessage(Error.NO_PERMISSION.sendError());
				return true;
			}
		}
		if (args.length == 0) {
			Player sender = (Player) sndr;
			Util.setAfk(sender, AfkStatus.AUTO);
			return true;
		} 
		else {
			sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
			return true;
		}
	}	
}
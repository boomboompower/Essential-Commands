package com.njdaeger.essentials.commands;


import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.Util;
import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;

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
			sndr.sendMessage(Error.PLAYER_ONLY.sendError());
			return true;
		}
		if (args.length == 1) {
			Player player = Bukkit.getPlayer(args[0]);
			if((sndr.hasPermission(Permission.ESS_AFK.getPermission()) && sndr.hasPermission(Permission.ESS_AFK_OTHER.getPermission())) || 
					sndr.hasPermission(Permission.ESS_ALL.getPermission()) || sndr.isOp()) {
				if (player.isOnline()) {
					Util.setAfk(player);
					return true;
				}
				else {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
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
			if (sndr.hasPermission(Permission.ESS_AFK.getPermission()) || sndr.hasPermission(Permission.ESS_ALL.getPermission()) || sndr.isOp()) {
				Util.setAfk(sender);
				return true;
			} 
			else {
				sndr.sendMessage(Error.NO_PERMISSION.sendError());
				return true;
			}
		} 
		else {
			sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
			return true;
		}
	}	
}
/*
	 * time to start setting up the rest of the command and variables. 
	 * 1. have a check to see if the player sends a command it un afk's them
	 * 2. generate a player config file and test if it works
	 * 3. do a mile run tomorrow on the track to see what i can do.
	 * 4. add more commands
	 * 5. make errortype enum complete ish
	 * 6. remove some of the exceptions.
	 * 7. make the new file file in the configuration api
	 * 
	 */
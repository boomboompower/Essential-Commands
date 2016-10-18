package com.njdaeger.essentials.commands.player;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.Util;
import com.njdaeger.essentials.Util.GodStatus;
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
					Player target = Bukkit.getPlayer(args[0]);
					if (target == null) {
						sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
						return true;
					}
					Util.setGod(target, sndr, GodStatus.AUTO);
					return true;
					
				}
				else {
					sndr.sendMessage(Error.NO_PERMISSION.sendError());
					return true;
				}
			}
			if (args.length == 0) {
				Player player = (Player) sndr;
				Util.setGod(player, sndr, GodStatus.AUTO);
				return true;
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
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				Util.setGod(target, sndr, GodStatus.AUTO);
				return true;
			}
			else {
				sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
				return true;
			}
		}
	}	
}

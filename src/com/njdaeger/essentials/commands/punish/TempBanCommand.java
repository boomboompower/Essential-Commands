package com.njdaeger.essentials.commands.punish;

import java.util.Arrays;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;
import com.njdaeger.essentials.exceptions.UnknownException;
import com.njdaeger.essentials.utils.ServerBan;

public class TempBanCommand extends BukkitCommand{
	
	public TempBanCommand() {
		super("tempban");
		List<String> a = Arrays.asList("temp", "tb", "bantemp");
		this.description = "Temp ban a player.";
		this.usageMessage = "/tempban <player> <time> [reason]";
		this.setAliases(a);
	}

	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		if (sndr instanceof Player) {
			if (sndr.hasPermission(Permission.ESS_ALL.getPermission()) || sndr.hasPermission(Permission.ESS_TEMPBAN.getPermission()) || sndr.isOp()) {
				if (args.length <= 1) {
					sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
					return true;
				}
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				if (target.equals(sndr) || target.hasPermission(Permission.ESS_BAN_EXEMPT.getPermission()) || target.isOp() || target.hasPermission(Permission.ESS_ALL.getPermission())) {
					sndr.sendMessage(Error.CANNOT_BAN_TARGET.sendError());
					return true;
				}
				if (args.length == 2) {
					ServerBan.newTempBan(target, null, sndr, args[1]);
					return true;
				}
				if (args.length > 2) {
					String why = "";
					for (String reason : args) {
						why = (why + reason + " ");
					}
					ServerBan.newTempBan(target, ChatColor.translateAlternateColorCodes('&', why), sndr, args[1]);
					return true;
					
				}
				else {
					try {
						throw new UnknownException();
					} catch (UnknownException e) {
						e.printStackTrace();
						return true;
					}
				}
			}
			else {
				sndr.sendMessage(Error.NO_PERMISSION.sendError());
				return true;
			}
		}
		else {
			if (args.length <= 1) {
				sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
				return true;
			}
			if (args.length == 2) {
				ServerBan.newTempBan(target, null, sndr, args[1]);
				return true;
			}
			if (args.length > 2) {
				String why = "";
				for (String reason : args) {
					why = (why + reason + " ");
				}
				ServerBan.newTempBan(target, ChatColor.translateAlternateColorCodes('&', why), sndr, args[1]);
				return true;
				
			}
			else {
				try {
					throw new UnknownException();
				} catch (UnknownException e) {
					e.printStackTrace();
					return true;
				}
			}
		}
	}
}

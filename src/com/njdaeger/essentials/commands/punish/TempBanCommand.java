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
import com.njdaeger.essentials.utils.TargetHasPermission;

public class TempBanCommand extends BukkitCommand{
	
	public TempBanCommand() {
		super("tempban");
		List<String> a = Arrays.asList("temp", "tb", "bantemp");
		this.description = "Temp ban a player.";
		this.usageMessage = "/tempban <player> <time:<d/h/m/s>> [reason]";
		this.setAliases(a);
	}

	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		if (sndr instanceof Player) {
			Player player = (Player) sndr;
			if (TargetHasPermission.check(player, Permission.ESS_TEMPBAN)) {
				if (args.length <= 1) {
					sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
					return true;
				}
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				if (target.equals(sndr) || TargetHasPermission.check(player, Permission.ESS_BAN_EXEMPT)) {
					sndr.sendMessage(Error.CANNOT_BAN_TARGET.sendError());
					return true;
				}
				if (args.length == 2) {
					ServerBan.newTempBan(target, null, sndr, args[1]);
					return true;
				}
				if (args.length > 2) {
					String why = "";
					String finalreason = "";
					for (String reason : args) {
						why = (why + reason + " ");
						String split[] = why.split(" ", 2);
						finalreason = split[2].split(" ", 2).toString();
					}
					ServerBan.newTempBan(target, ChatColor.translateAlternateColorCodes('&', finalreason), sndr, args[1]);
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
				String a = "";
				String finalreason = "";
				for (String reason : args) {
					a = (a + reason + " ");
					String split[] = reason.split(" ");
					finalreason = split[3];
					
					
				}
				ServerBan.newTempBan(target, ChatColor.translateAlternateColorCodes('&', finalreason), sndr, args[1]);
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
	
	/**
     	* Used to get arguments from a command
   	*
   	* @param start the argument to start from.
   	* @param args command argument list
    	* @return the arguments after the specified point
   	*/
	private String getArguments(int start, String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < args.length; i++) {
            builder.append(args[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}

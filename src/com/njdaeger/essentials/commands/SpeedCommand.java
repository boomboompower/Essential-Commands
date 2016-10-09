package com.njdaeger.essentials.commands;

import java.util.Arrays;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.Util;
import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;

public class SpeedCommand extends BukkitCommand {
	
	public SpeedCommand() {
		super("speed");
		List<String> a = Arrays.asList("flyspeed", "walkspeed", "setspeed");
		this.description = "Set player speed.";
		this.usageMessage = "/speed <speed> [player] [type]";
		this.setPermission(Permission.ESS_SPEED.getPermission());
		this.setPermission(Permission.ESS_SPEED_OTHER.getPermission());
		this.setPermission(Permission.ESS_ALL.getPermission());
		this.setAliases(a);
		
	}

	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		if (sndr instanceof Player) {
			Player player = (Player) sndr;
			if (args.length == 0) {
				sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reset")) {
					if (!player.isFlying()) {
						player.setWalkSpeed(0.2f);
						sndr.sendMessage(ChatColor.GRAY + "Your walking speed is now reset.");
						return true;
					}
					else {
						player.setFlySpeed(0.1f);
						sndr.sendMessage(ChatColor.GRAY + "Your flying speed is now reset.");
						return true;
					}
				}
				if (Util.isNumber(args[0]) == false) {
					sndr.sendMessage(Error.INPUT_NOT_NUM.sendError());
					return true;
				}
				else {
					if (!player.isFlying()) {
						double x = Double.parseDouble(args[0]);
						if (x > 10) {
							sndr.sendMessage(Error.INPUT_TOO_LARGE.sendError());
							return true;
						}
						else {
							double e = ((19 * x) - Math.pow(x, 2)) / 90;
							String a = Double.toString(e);
							float speed = Float.parseFloat(a);
							player.setWalkSpeed(speed);
							sndr.sendMessage(ChatColor.GRAY + "Your walking speed is now " + ChatColor.GREEN + args[0] + ChatColor.GRAY + ".");
							return true;
						}
						
					}
					else {
						float fspeed = Float.parseFloat(args[0]) / 10;
						player.setFlySpeed(fspeed);
						sndr.sendMessage(ChatColor.GRAY + "Your flying speed is now " + ChatColor.GREEN + args[0] + ChatColor.GRAY + ".");
						return true;
					}
				}
			}
		}
		else {
			return true;
		}
		return true;
	}

}

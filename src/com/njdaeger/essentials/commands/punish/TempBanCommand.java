package com.njdaeger.essentials.commands.punish;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;

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
				
			}
			else {
				sndr.sendMessage(Error.NO_PERMISSION.sendError());
				return true;
			}
		}
		return false;
	}
	
	

}

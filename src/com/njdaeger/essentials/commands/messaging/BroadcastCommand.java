package com.njdaeger.essentials.commands.messaging;

import java.util.Arrays;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;

public class BroadcastCommand extends BukkitCommand {
	
	private ChatColor gold = ChatColor.GOLD;
	private ChatColor red = ChatColor.DARK_RED;
	private ChatColor green = ChatColor.GREEN;
	
	public BroadcastCommand() {
		super("broadcast");
		List<String> a = Arrays.asList("bc", "servermessage", "announce");
		this.description = "Send a message to the entire server.";
		this.usageMessage = "/broadcast <message>";
		this.setPermission(Permission.ESS_BROADCAST.getPermission());
		this.setPermission(Permission.ESS_ALL.getPermission());
		this.setPermissionMessage(Error.NO_PERMISSION.sendError());
		this.setAliases(a);
	}
	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		if (args.length < 1) {
			sndr.sendMessage("" + Error.NOT_ENOUGH_ARGS.sendError());
			return true;
		}
		else if (args.length >= 1) {
			String message = "";
			for (String bc : args) {
				message = (message + bc + " ");
			}
			Bukkit.broadcastMessage(gold + "[" + red + "Broadcast"+ gold + "] " + green + ChatColor.translateAlternateColorCodes('&', message));
			return true;
		}
		return true;
	}
}

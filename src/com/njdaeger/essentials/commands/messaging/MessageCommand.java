package com.njdaeger.essentials.commands.messaging;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.Util;
import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;

public class MessageCommand extends BukkitCommand {
	
	public MessageCommand() {
		super("message");
		List<String> a = Arrays.asList("msg", "pm", "write", "private");
		this.description = "Send a private message to a player.";
		this.usageMessage = "/message <player> <message>";
		this.setPermission(Permission.ESS_MESSAGE.getPermission());
		this.setPermission(Permission.ESS_MESSAGE_CHATCOLOR.getPermission());
		this.setPermission(Permission.ESS_ALL.getPermission());
		this.setAliases(a);
	}

	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		if (sndr instanceof Player) {
			Player player = (Player) sndr;
			if (args.length < 2) {
				sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
				return true;
			}
			else {
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				if (Util.isHidden(target) == true) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				if (Util.allowsMessaging(target) == false) {
					sndr.sendMessage(Error.MESSAGING_DISABLED_TARGET.sendError());
					return true;
				}
				if (Util.allowsMessaging(player) == false) {
					sndr.sendMessage(Error.MESSAGING_DISABLED_SENDER.sendError());
					return true;
				}
				String msg = "";
				String finalmsg = "";
				for (String message : args) {
					msg = (msg + message + " ");
					String split[] = msg.split(" ", 2);
					finalmsg = split[1];
				}
				if (sndr.hasPermission(Permission.ESS_MESSAGE_CHATCOLOR.getPermission()) || sndr.isOp() || sndr.hasPermission(Permission.ESS_ALL.getPermission())) {
					Util.sendPM(target, sndr, finalmsg, true, true);
					return true;
				}
				else {
					Util.sendPM(target, sndr, finalmsg, false, true);
					return true;
				}
			}
		}
		else {
			if (args.length < 2) {
				sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
				return true;
			}
			else {
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				if (Util.isHidden(target) == true) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				if (Util.allowsMessaging(target) == false) {
					sndr.sendMessage(Error.MESSAGING_DISABLED_TARGET.sendError());
					return true;
				}
				String msg = "";
				String finalmsg = "";
				for (String message : args) {
					msg = (msg + message + " ");
					String split[] = msg.split(" ", 2);
					finalmsg = split[1];
				}
				Util.sendPM(target, sndr, finalmsg, true, false);
				return true;
			}
		}
	}
}

package com.njdaeger.essentials.commands.player;

import java.util.Arrays;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;

public class NickCommand extends BukkitCommand {
	
	public NickCommand() {
		super("nick");
		List<String> a = Arrays.asList("nickname", "newname", "disguise");
		this.description = "Mark yourself as away from keyboard.";
		this.usageMessage = "/nick <Nickname> [Player]";
		this.setPermission(Permission.ESS_NICK.getPermission());
		this.setPermission(Permission.ESS_NICK_OTHER.getPermission());
		this.setPermission(Permission.ESS_ALL.getPermission());
		this.setPermissionMessage(Error.NO_PERMISSION.sendError());
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
				if (player.getDisplayName() != player.getName()) {
					if (args[0].length() > 30) {
						sndr.sendMessage(Error.NICKNAME_TOO_LONG.sendError());
						return true;
					}
					if (args[0].equals("off")) {
						player.setDisplayName(player.getName());
						player.sendMessage(ChatColor.GRAY + "You no longer have a nickname.");
						return true;
					}
					else {
						player.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.WHITE);
						player.sendMessage(ChatColor.GRAY + "Your nickname is now \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
						return true;
					}
				}
				else {
					player.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.WHITE);
					player.sendMessage(ChatColor.GRAY + "Your nickname is now \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
					return true;
				}
			}
			if (args.length == 2) {
				if (sndr.hasPermission(Permission.ESS_ALL.getPermission()) || sndr.hasPermission(Permission.ESS_NICK_OTHER.getPermission()) || sndr.isOp()) {
					if (Bukkit.getPlayer(args[1]) == null) {
						sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
						return true;
					}
					Player target = Bukkit.getPlayer(args[1]);
					if (args[0].length() > 30) {
						sndr.sendMessage(Error.NICKNAME_TOO_LONG.sendError());
						return true;
					}
					if (target.getDisplayName() != target.getName()) {
						if (args[0].equals("off")) {
							target.setDisplayName(target.getName());
							sndr.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " no longer has a nickname.");
							target.sendMessage(ChatColor.GRAY + "You no longer have a nickname.");
							return true;
						}
						else {
							target.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.WHITE);
							sndr.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + "'s nickname is now set too \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
							target.sendMessage(ChatColor.GRAY + "Your nickname is now \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
							return true;
						}
					}
					else {
						target.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.WHITE);
						target.sendMessage(ChatColor.GRAY + "Your nickname is now \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
						sndr.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + "'s nickname is now set too \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
						return true;
					}
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
		else {
			if (args.length <= 1) {
				sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
				return true;
			}
			if (args.length == 2) {
				if (Bukkit.getPlayer(args[1]) == null) {
					sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
					return true;
				}
				Player target = Bukkit.getPlayer(args[1]);
				if (args[0].length() > 30) {
					sndr.sendMessage(Error.NICKNAME_TOO_LONG.sendError());
					return true;
				}
				if (target.getDisplayName() != target.getName()) {
					if (args[0].equals("off")) {
						target.setDisplayName(target.getName());
						sndr.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " no longer has a nickname.");
						target.sendMessage(ChatColor.GRAY + "You no longer have a nickname.");
						return true;
					}
					else {
						target.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.WHITE);
						target.sendMessage(ChatColor.GRAY + "Your nickname is now \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
						sndr.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + "'s nickname is now set too \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
						return true;
					}
				}
				else {
					target.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.WHITE);
					target.sendMessage(ChatColor.GRAY + "Your nickname is now \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
					sndr.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + "'s nickname is now set too \"" + this.getNick(args[0]) + ChatColor.GRAY + "\".");
					return true;
				}
			}
			else {
				sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
				return true;
			}
		}
	}
	public String getNick(String nick) {
		if (nick.contains("&")) {
			return ChatColor.translateAlternateColorCodes('&', nick);
		}
		else return ChatColor.GREEN + nick;
	}
}

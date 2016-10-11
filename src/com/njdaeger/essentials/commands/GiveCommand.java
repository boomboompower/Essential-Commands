package com.njdaeger.essentials.commands;

import java.util.Arrays;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.njdaeger.essentials.Plugin;
import com.njdaeger.essentials.Util;
import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;
import com.njdaeger.essentials.exceptions.UnknownItemException;

public class GiveCommand extends BukkitCommand {

	public GiveCommand() {
		super("i");
		List<String> a = Arrays.asList("item", "give", "get", "take");
		this.description = "Give yourself items.";
		this.usageMessage = "/i <item:[data]> [amount] [player]";
		this.setPermission(Permission.ESS_GIVE.getPermission());
		this.setPermission(Permission.ESS_GIVE_OTHER.getPermission());
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
				if (Util.hasFullInventory(player)) {
					sndr.sendMessage(Error.INVENTORY_IS_FULL_P.sendError());
					return true;
				}
				if (Plugin.getItem(args[0]) == null) {
					sndr.sendMessage(Error.UNKNOWN_ITEM.sendError());
					return true;
				}
				else {
					sndr.sendMessage(ChatColor.GRAY + "Adding " + ChatColor.GREEN + "64 " + ChatColor.GRAY + "items of " + /*ChatColor.GREEN + this.getGivenItem(args[0]).name().toLowerCase() +*/ ChatColor.GRAY + " to your inventory.");
					this.giveItems(args[0], player, 64);
					return true;
				}
			}
			else if (args.length == 2) {
				if (Util.hasFullInventory(player)) {
					sndr.sendMessage(Error.INVENTORY_IS_FULL_P.sendError());
					return true;
				}
				if (!this.isNumber(args[1])) {
					sndr.sendMessage(Error.INPUT_NOT_NUM.sendError());
					return true;
				}
				if (Plugin.getItem(args[0]) == null) {
					sndr.sendMessage(Error.UNKNOWN_ITEM.sendError());
					return true;
				}
				else {
					int amount = Integer.parseInt(args[1]);
					sndr.sendMessage(ChatColor.GRAY + "Adding you " + ChatColor.GREEN + amount + ChatColor.GRAY + " items of " + ChatColor.GREEN + this.getGivenItem(args[0]).toLowerCase() + ChatColor.GRAY + " to your inventory.");
					this.giveItems(args[0], player, amount);
					return true;
				}
			}
			else if (args.length == 3) {
				if (sndr.hasPermission(Permission.ESS_GIVE_OTHER.getPermission()) || sndr.hasPermission(Permission.ESS_ALL.getPermission()) || sndr.isOp()) {
					if (!(Bukkit.getPlayer(args[2]) instanceof Player)) {
						sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
						return true;
					}
					Player target = Bukkit.getPlayer(args[2]);
					if (Util.hasFullInventory(target)) {
						sndr.sendMessage(Error.INVENTORY_IS_FULL_PO.sendError());
						return true;
					}
					if (!this.isNumber(args[1])) {
						sndr.sendMessage(Error.INPUT_NOT_NUM.sendError());
						return true;
					}
					if (Plugin.getItem(args[0]) == null) {
						sndr.sendMessage(Error.UNKNOWN_ITEM.sendError());
						return true;
					}
					else {
						int amount = Integer.parseInt(args[1]);
						target.sendMessage(ChatColor.GREEN + sndr.getName() + ChatColor.GRAY + " added " + ChatColor.GREEN + amount + ChatColor.GRAY + " items of " + ChatColor.GREEN + this.getGivenItem(args[0]).toLowerCase()+ ChatColor.GRAY + " to your inventory.");
						this.giveItems(args[0], target, amount);
						return true;
					}
				}
				else sndr.sendMessage(Error.NO_PERMISSION.sendError()); return true;
			
			}
			else {
				sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
				return true;
			}
		}
		else {
			if (args.length <= 2) {
				sndr.sendMessage(Error.NOT_ENOUGH_ARGS.sendError());
				return true;
			}
			if (args.length == 3) {
				if (sndr.hasPermission(Permission.ESS_GIVE_OTHER.getPermission()) || sndr.hasPermission(Permission.ESS_ALL.getPermission()) || sndr.isOp()) {
					if (!(Bukkit.getPlayer(args[2]) instanceof Player)) {
						sndr.sendMessage(Error.UNKNOWN_PLAYER.sendError());
						return true;
					}
					Player target = Bukkit.getPlayer(args[2]);
					if (Util.hasFullInventory(target)) {
						sndr.sendMessage(Error.INVENTORY_IS_FULL_C.sendError());
						return true;
					}
					if (!this.isNumber(args[1])) {
						sndr.sendMessage(Error.INPUT_NOT_NUM.sendError());
						return true;
					}
					if (Plugin.getItem(args[0]) == null) {
						sndr.sendMessage(Error.UNKNOWN_ITEM.sendError());
						return true;
					}
					else {
						int amount = Integer.parseInt(args[1]);
						target.sendMessage(ChatColor.GREEN + sndr.getName() + ChatColor.GRAY + " added " + ChatColor.GREEN + amount + ChatColor.GRAY + " items of " + ChatColor.GREEN + this.getGivenItem(args[0]).toLowerCase() + ChatColor.GRAY + " to your inventory.");
						this.giveItems(args[0], target, amount);
						return true;
					}
				}
				else sndr.sendMessage(Error.NO_PERMISSION.sendError()); return true;
			
			}
			else {
				sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
				return true;
			}
		}
	}
			
	public boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	@SuppressWarnings("deprecation")
	public void giveItems(String items, Player player, int amount) {
		if (items.contains(":")) {
			String[] splitter = items.split(":");
			if (splitter[1] == null) {
				player.sendMessage(Error.UNKNOWN_ITEM.sendError());
				return;
			}
			if (isNumber(splitter[0])) {
				if (isNumber(splitter[1])) {
					int id = 0;
					short damage = 0;
					damage = Short.parseShort(splitter[1]);
					id = Integer.parseInt(splitter[0]);
					player.getInventory().addItem(new ItemStack(id, amount, damage));
				}
				else {
					player.sendMessage(Error.UNKNOWN_ITEM.sendError());
					return;
				}
				
			}
			if (splitter[0].equalsIgnoreCase("minecraft")) {
				if (Plugin.getItem(splitter[1]) instanceof Material) {
					player.getInventory().addItem(new ItemStack(Plugin.getItem(splitter[1]), amount));
					return;
				}
				else player.sendMessage(Error.UNKNOWN_ITEM.sendError());
				return;
			}
			if (Plugin.getItem(splitter[0]) instanceof Material) {
				short damage = 0;
				damage = Short.parseShort(splitter[1]);
				player.getInventory().addItem(new ItemStack(Plugin.getItem(splitter[0]), amount, damage));
				return;
			}
			else {
				try {
					player.sendMessage(Error.UNKNOWN_ITEM.sendError());
					throw new UnknownItemException();
				} catch (UnknownItemException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			if (isNumber(items) == true) {
				int id = 0;
				id = Integer.parseInt(items);
				player.getInventory().addItem(new ItemStack(id, amount));
				return;
			}
			else {
				if (Plugin.getItem(items) != null) {
					player.getInventory().addItem(new ItemStack(Plugin.getItem(items), amount));
					return;
				}
				else {
					try {
						player.sendMessage(Error.UNKNOWN_ITEM.sendError());
						throw new UnknownItemException();
					} catch (UnknownItemException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	@SuppressWarnings("deprecation")
	public String getGivenItem(String input) {
		if (input.contains(":")) {
			String splitter[] = input.split(":");
			if (this.isNumber(splitter[0])) {
				if (this.isNumber(splitter[1])) {
					int id = Integer.parseInt(splitter[0]);
					short damage = Short.parseShort(splitter[1]);
					Material item = new ItemStack(id, 1, damage).getType();
					return item.toString();
				}
				else return null;	
			}
			if (splitter[0].equalsIgnoreCase("minecraft")) {
				if (Plugin.getItem(splitter[1]) instanceof Material) {
					Material item = new ItemStack(Plugin.getItem(splitter[0])).getType();
					return item.toString();
				}
				else return null;
			}
			if (Plugin.getItem(splitter[0]) instanceof Material) {
				if (this.isNumber(splitter[1])) {
					short damage = Short.parseShort(splitter[1]);
					Material item = new ItemStack(Plugin.getItem(splitter[0]), 1, damage).getType();
					return item.toString();
				}
				else return null;
			} 
			else try {
				throw new UnknownItemException();
			} 
			catch (UnknownItemException e) {
				e.printStackTrace();
			}
		}
		else {
			if (this.isNumber(input)) {
				int id = Integer.parseInt(input);
				return Material.getMaterial(id).toString();
			}
			else {
				return Material.getMaterial(input).toString();
			}
		}
		return null;
	}
}
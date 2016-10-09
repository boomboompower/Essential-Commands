package com.njdaeger.essentials.commands;

import java.util.HashSet;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;

public class BreakCommand extends BukkitCommand {
	
	private ChatColor green = ChatColor.GREEN;
	private ChatColor gray = ChatColor.GRAY;
	
	public BreakCommand() {
		super("break");
		this.description = "Break the block you are looking at.";
		this.usageMessage = "/break";
		this.setPermission(Permission.ESS_ALL.getPermission());
		this.setPermission(Permission.ESS_BREAK.getPermission());
	}

	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		if (!(sndr instanceof Player)) {
			sndr.sendMessage(Error.PLAYER_ONLY.sendError());
			return true;
		}
		if (args.length > 0) {
			sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
			return true;
		}
		Player player = (Player) sndr;
		HashSet<Material> tran = new HashSet<Material>(); 
		tran.add(Material.AIR);
		Block block = player.getTargetBlock(tran, 100).getLocation().getBlock();
		block.setType(Material.AIR);
		sndr.sendMessage(gray + "You broke block " + green + player.getTargetBlock(tran, 100).getType().toString().toLowerCase() +
				gray + " at x:" + green + block.getX() + 
				gray + " y:" + green + block.getY() + 
				gray + " z:" + green + block.getZ() + 
				gray + ".");;
		
		return true;
	}
}

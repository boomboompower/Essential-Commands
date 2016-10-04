package com.njdaeger.essentials.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

public class BanCommand extends BukkitCommand{
	
	public BanCommand() {
		super("ban");
		//List<String> a = Arrays.asList("gm", "mode");
		//this.description = "Switch between gamemodes.";
		//this.usageMessage = "/gamemode <creative/survivial/adventure/spectator> [player]";
		//this.setPermission(Permission.ESS_GAMEMODE.getPermission());
		//this.setPermission(Permission.ESS_GAMEMODE_OTHER.getPermission());
		//this.setPermission(Permission.ESS_ALL.getPermission());
		//this.setAliases(a);
		
		
	}

	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		return false;
	}
	
}

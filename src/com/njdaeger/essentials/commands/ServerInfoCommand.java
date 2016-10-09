package com.njdaeger.essentials.commands;

import java.util.Arrays;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import com.njdaeger.essentials.Server;
import com.njdaeger.essentials.enums.Error;
import com.njdaeger.essentials.enums.Permission;
import com.njdaeger.essentials.exceptions.UnsupportedOSException;

public class ServerInfoCommand extends BukkitCommand{
	
	private ChatColor g = ChatColor.GRAY;
	private ChatColor a = ChatColor.AQUA;
	
	public ServerInfoCommand() {
		super("serverinfo");
		List<String> alias = Arrays.asList("si", "server", "lag", "memory", "internal");
		this.setDescription("Get server information.");
		this.setUsage("/serverinfo");
		this.setPermission(Permission.ESS_SERVER_INFO.getPermission());
		this.setPermission(Permission.ESS_ALL.getPermission());
		this.setAliases(alias);
	}

	@Override
	public boolean execute(CommandSender sndr, String label, String[] args) {
		if (args.length != 0) {
			sndr.sendMessage(Error.TOO_MANY_ARGS.sendError());
			return true;
		}
		if (System.getProperty("os.name").startsWith("Windows")) {
			
			sndr.sendMessage(g + "=-=-=- " + a + "Server Information" + g + " -=-=-=");
			sndr.sendMessage(g + "Server Name: " + a + Server.getName());
			sndr.sendMessage(g + "Server TPS: " + a + this.formatTps(Server.getTPS()));
			sndr.sendMessage(g + "Server Operating System: " + a + Server.getOS());
			sndr.sendMessage(g + "Server Architecture: " + a + Server.getArchitecture());
			sndr.sendMessage(g + "Server CPU Cores: " + a + Server.getCPU());
			sndr.sendMessage(g + "Server CPU Usage: " + a + Server.getCPULoad());
			sndr.sendMessage(g + "Server max RAM: " + a + Server.getMaxMemory() + "Mb");
			sndr.sendMessage(g + "Server free RAM: " + a + Server.getFreeMemory() + "Mb");
			sndr.sendMessage(g + "Server allocated RAM: " + a + Server.getAllocatedMemory() + "Mb");
			sndr.sendMessage(g + "Server Port Number: " + a + Server.getPort());
			
			return true;
		} else
			try {
				throw new UnsupportedOSException();
			} catch (UnsupportedOSException e) {
				e.printStackTrace();
			}
		return true;
	}
	public String formatTps(String tps) {
		double ticks = Double.parseDouble(tps);
		if (ticks >= 18) {
			return ChatColor.GREEN + tps;
		}
		else if (ticks >= 15) {
			return ChatColor.YELLOW + tps;
		}
		else return ChatColor.RED + tps;
	}
}

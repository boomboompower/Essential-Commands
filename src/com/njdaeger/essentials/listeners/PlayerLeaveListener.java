package com.njdaeger.essentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import com.configapi.configuration.PlayerConfig;
import com.njdaeger.essentials.Core;

public class PlayerLeaveListener implements Listener{
	
	Plugin plugin = Bukkit.getPluginManager().getPlugin("EssentialCommands");
	public PlayerLeaveListener(Core plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		if (PlayerConfig.getPlayerFile(e.getPlayer()) == null) {
			PlayerConfig.create(e.getPlayer());
			Bukkit.getLogger().info("Config file for " + e.getPlayer().getName() + " is being created.");
			return;
		}
		else {
			PlayerConfig.logoutUpdate(e.getPlayer());
			Bukkit.getLogger().info("Config file for " + e.getPlayer().getName() + " saved.");
			return;
		}
	}
	
}

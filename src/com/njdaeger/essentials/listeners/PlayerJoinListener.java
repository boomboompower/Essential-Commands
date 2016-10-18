package com.njdaeger.essentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import com.configapi.configuration.PlayerConfig;
import com.njdaeger.essentials.Core;

public class PlayerJoinListener implements Listener{
	Plugin plugin = Bukkit.getPluginManager().getPlugin("EssentialCommands");
	public PlayerJoinListener(Core plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (PlayerConfig.getPlayerFile(e.getPlayer()) == null) {
			PlayerConfig.create(e.getPlayer());
			Bukkit.getLogger().info("Config file for " + e.getPlayer().getName() + " is being created.");
			return;
		}
		else {
			PlayerConfig.loginUpdate(e.getPlayer());
			Bukkit.getLogger().info("Config file for " + e.getPlayer().getName() + " loaded.");
			return;
		}
	}
	
	
	
	/*
	 * Check if player file and path exist on join.
	 * 
	 * Get all the values they had and set them. So, displayname, rank, etc..
	 * 
	 * Things to put in player file:
	 *  	- Playername: String
	 *  	- Displayname: String
	 *  	- AFK: boolean
	 *  	- Hidden: boolean
	 *  	- PMEnabled: boolean
	 *  	- Rank: String
	 *  	- Muted: boolean
	 *  	- Socialspy: boolean
	 *  	- tptoggled: boolean
	 *  	- ip: String
	 *  	- flying: boolean
	 *  	- gamemode: String
	 *  	- god: boolean
	 *  	- flyspeed: int
	 *  	- walkspeed: int
	 *  	- op: boolean
	 *  	- banned: boolean
	 *  	- login: int
	 *  	- logout: int
	 *  	- lastlocation:
	 *  		- world: String
	 *  		- x: double
	 *  		- y: double
	 *  		- z: double
	 *  		- yaw: double
	 *  		- pitch: double
	 * 		- logoutlocation:
	 * 			- world: String
	 * 			- x: double
	 * 			- y: double
	 * 			- z: double
	 * 			- yaw: double
	 * 			- pitch: double
	 * 
	 * 
	 * EssentialCommands/users/(UserUUID)/user.yml
	 * EssentialCommands/users/(UserUUID)/homes/homename.yml
	 * EssentialCommands/users/(UserUUID)/messages/#.yml 
	 * EssentialCommands/warps/warpname.yml
	 * EssentialCommands/motd.txt
	 * 
	 */

}

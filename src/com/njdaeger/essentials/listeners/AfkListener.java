package com.njdaeger.essentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import com.njdaeger.essentials.Core;
import com.njdaeger.essentials.Groups;
import com.njdaeger.essentials.exceptions.UnknownActionException;
import com.njdaeger.essentials.utils.Util;
import com.njdaeger.essentials.utils.Util.AfkStatus;

public class AfkListener implements Listener{
	Plugin plugin = Bukkit.getPluginManager().getPlugin("EssentialCommands");
	public AfkListener(Core plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onMove(PlayerInteractEvent e) throws UnknownActionException {
		if (Util.isAfk(e.getPlayer())) {
			if (
					e.getAction() == Action.LEFT_CLICK_AIR ||
					e.getAction() == Action.LEFT_CLICK_BLOCK ||
					e.getAction() == Action.PHYSICAL ||
					e.getAction() == Action.RIGHT_CLICK_AIR ||
					e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				Util.setAfk(e.getPlayer(), AfkStatus.AUTO);
				return;
			}
			else throw new UnknownActionException();
		}
		else return;
	}
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		String message = e.getMessage();
		if (Util.isAfk(e.getPlayer()) == true) {
			if (
					message.equalsIgnoreCase("msg") ||
					message.equalsIgnoreCase("r") ||
					message.startsWith("/reply") ||
					message.startsWith("/brb") ||
					message.startsWith("/afk") ||
					message.startsWith("/akf") ||
					message.startsWith("/away") ||
					message.startsWith("bc") ||
					message.startsWith("servermessage") ||
					message.startsWith("announce") || 
					message.startsWith("broadcast")) {
				return;
				
			}
			else {
				Util.setAfk(e.getPlayer(), AfkStatus.AUTO);
				return;
			}
			
		}
		else return;
	}
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Location loc = e.getTo();
		Location afk = Groups.afkloc.getOrDefault(e.getPlayer().getName(), e.getPlayer().getLocation());
		if (Util.isAfk(e.getPlayer())){
			if (afk.distance(loc) >= 5) {
				Util.setAfk(e.getPlayer(), AfkStatus.AUTO);
			}
			else return;
		}
		else return;
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if (Util.isAfk(e.getPlayer())) {
			Util.setAfk(e.getPlayer(), AfkStatus.AUTO);
			return;
		}
		else return;
	}
}

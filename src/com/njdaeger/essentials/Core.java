package com.njdaeger.essentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.chat.chatcolor.ChatHandler;
import com.njdaeger.essentials.commands.messaging.BroadcastCommand;
import com.njdaeger.essentials.commands.messaging.MeCommand;
import com.njdaeger.essentials.commands.messaging.MessageCommand;
import com.njdaeger.essentials.commands.player.AfkCommand;
import com.njdaeger.essentials.commands.player.BreakCommand;
import com.njdaeger.essentials.commands.player.BurnCommand;
import com.njdaeger.essentials.commands.player.ClearInvCommand;
import com.njdaeger.essentials.commands.player.GamemodeCommand;
import com.njdaeger.essentials.commands.player.GetPositionCommand;
import com.njdaeger.essentials.commands.player.GiveCommand;
import com.njdaeger.essentials.commands.player.GodCommand;
import com.njdaeger.essentials.commands.player.HealCommand;
import com.njdaeger.essentials.commands.player.NickCommand;
import com.njdaeger.essentials.commands.player.SpeedCommand;
import com.njdaeger.essentials.commands.punish.TempBanCommand;
import com.njdaeger.essentials.commands.world.ServerInfoCommand;
import com.njdaeger.essentials.listeners.AfkListener;
import com.njdaeger.essentials.listeners.PlayerJoinListener;
import com.njdaeger.essentials.listeners.PlayerLeaveListener;
import com.njdaeger.essentials.utils.Util;

public class Core extends JavaPlugin{
	
	public void generateConfig() {
		PluginConfiguration.generateNewConfig();
	}
	public void registerListeners() {
		new PlayerLeaveListener(this);
		new PlayerJoinListener(this);
		new AfkListener(this);
		new ChatHandler(this);
	}
	public void registerCommands() {
		Plugin.getCommand("afk", new AfkCommand()); //Finished
		Plugin.getCommand("broadcast", new BroadcastCommand()); //Finished
		Plugin.getCommand("serverinfo", new ServerInfoCommand()); //Finished
		Plugin.getCommand("gamemode", new GamemodeCommand()); //Finished
		Plugin.getCommand("i", new GiveCommand()); //Finished 
		Plugin.getCommand("god", new GodCommand()); //Finished 
		Plugin.getCommand("nick", new NickCommand()); //Finished
		Plugin.getCommand("break", new BreakCommand()); //Finished
		Plugin.getCommand("burn", new BurnCommand()); //Finished
		Plugin.getCommand("speed", new SpeedCommand()); //Finished
		Plugin.getCommand("clear", new ClearInvCommand()); //Finished
		Plugin.getCommand("position", new GetPositionCommand()); //Finished
		Plugin.getCommand("heal", new HealCommand()); //Finished
		Plugin.getCommand("me", new MeCommand()); //Finished
		Plugin.getCommand("message", new MessageCommand()); //Finished
		Plugin.getCommand("tempban", new TempBanCommand()); //Permission testing
		
	}
	public void registerPermissions() {
		Util.generatePermissions();
		Bukkit.getLogger().info("[EssentialCommands] Version " + this.getDescription().getVersion() + " by " + this.getDescription().getAuthors() + " is now Enabled!");
	}
	/*
	 * (non-Javadoc)
	 * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
	 * check if the plugin is enabled with a checkenabled method and call it in the onenable.
	 */
	@Override
	public void onEnable() {
		TPS.getTPSClass();
		generateConfig();
		registerListeners();
		registerCommands();
		registerPermissions();
	}
	
	@Override
	public void onDisable() {
		
	}
}

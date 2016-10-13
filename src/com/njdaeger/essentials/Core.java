package com.njdaeger.essentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.chat.chatcolor.ChatHandler;
import com.njdaeger.essentials.commands.AfkCommand;
import com.njdaeger.essentials.commands.BreakCommand;
import com.njdaeger.essentials.commands.BroadcastCommand;
import com.njdaeger.essentials.commands.BurnCommand;
import com.njdaeger.essentials.commands.ClearInvCommand;
import com.njdaeger.essentials.commands.GamemodeCommand;
import com.njdaeger.essentials.commands.GetPositionCommand;
import com.njdaeger.essentials.commands.GiveCommand;
import com.njdaeger.essentials.commands.GodCommand;
import com.njdaeger.essentials.commands.NickCommand;
import com.njdaeger.essentials.commands.ServerInfoCommand;
import com.njdaeger.essentials.commands.SpeedCommand;
import com.njdaeger.essentials.listeners.AfkListener;

public class Core extends JavaPlugin{
	
	public void generateConfig() {
		PluginConfiguration.generateNewConfig();
	}
	public void registerListeners() {
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

package com.njdaeger.essentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.chat.chatcolor.ChatHandler;
import com.configapi.configuration.PluginConfig;
import com.njdaeger.essentials.commands.AfkCommand;
import com.njdaeger.essentials.commands.BroadcastCommand;
import com.njdaeger.essentials.commands.GamemodeCommand;
import com.njdaeger.essentials.commands.GiveCommand;
import com.njdaeger.essentials.commands.GodCommand;
import com.njdaeger.essentials.commands.NickCommand;
import com.njdaeger.essentials.commands.ServerInfoCommand;
import com.njdaeger.essentials.enums.Permission;
import com.njdaeger.essentials.listeners.AfkListener;

public class Core extends JavaPlugin{
	
	public void generateConfig() {
		PluginConfig.newConfig();
		PluginConfig.getConfig().addDefault("working", true);
		PluginConfig.save();
	}
	public void registerListeners() {
		new AfkListener(this);
		new ChatHandler(this);
	}
	public void registerCommands() {
		Plugin.getCommand("afk", new AfkCommand()); //Finished ###NOTE### ADD CONSOLE SUPPORT
		Plugin.getCommand("broadcast", new BroadcastCommand()); //Finished
		Plugin.getCommand("serverinfo", new ServerInfoCommand()); //Finished
		Plugin.getCommand("gamemode", new GamemodeCommand()); //Finished ###NOTE### ADD CONSOLE SUPPORT
		Plugin.getCommand("i", new GiveCommand()); //Finished ###NOTE### ADD CONSOLE SUPPORT
		Plugin.getCommand("god", new GodCommand()); //Finished ###NOTE### ADD CONSOLE SUPPORT
		Plugin.getCommand("nick", new NickCommand()); //FINISHED
		
	}
	public void registerPermissions() {
		Util.register(Permission.ESS_AFK);
		Util.register(Permission.ESS_AFK_OTHER);
		Util.register(Permission.ESS_ALL);
		Util.register(Permission.ESS_BACK);
		Util.register(Permission.ESS_BAN);
		Util.register(Permission.ESS_BREAK);
		Util.register(Permission.ESS_BROADCAST);
		Util.register(Permission.ESS_CHATCOLOR);
		Util.register(Permission.ESS_FLY);
		Util.register(Permission.ESS_FLY_OTHER);
		Util.register(Permission.ESS_GAMEMODE);
		Util.register(Permission.ESS_GAMEMODE_OTHER);
		Util.register(Permission.ESS_SERVER_INFO);
		Util.register(Permission.ESS_SPEED);
		Util.register(Permission.ESS_SPEED_OTHER);
		Util.register(Permission.ESS_GIVE);
		Util.register(Permission.ESS_GIVE_OTHER);
		Util.register(Permission.ESS_GOD);
		Util.register(Permission.ESS_GOD_OTHER);
		Util.register(Permission.ESS_NICK);
		Util.register(Permission.ESS_NICK_OTHER);
		
		
	}
	public void Runnable() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TPS(), 100L, 1L);
	}
	
	@Override
	public void onEnable() {
		generateConfig();
		registerCommands();
		registerPermissions();
		registerListeners();
	}
	
	@Override
	public void onDisable() {
		
	}
}

package com.configapi.configuration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.configapi.configuration.exceptions.ConfigNotFoundException;
import com.njdaeger.essentials.Util;
import com.njdaeger.essentials.Util.MuteStatus;
import com.njdaeger.essentials.exceptions.UnknownStatusException;

public class PlayerConfig {
	
	public static void create(Player player) {
		UUID userID = player.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID);
		File dir1 = new File(dir+File.separator+"user.yml");
		if (dir.exists()) {
			if (!dir1.exists()) {
				try {
					dir1.createNewFile();
					YamlConfiguration uconfig = YamlConfiguration.loadConfiguration(dir1);
					uconfig.set("playername", player.getName());
					uconfig.set("displayname", player.getDisplayName());
					uconfig.set("afk", false);
					uconfig.set("hidden", false);
					uconfig.set("messaging", true);
					uconfig.set("rank", null);
					uconfig.set("muted", false);
					uconfig.set("socialspy", false);
					uconfig.set("tptoggled", false);
					uconfig.set("ip", player.getAddress().getHostName());
					uconfig.set("flying", player.isFlying());
					uconfig.set("gamemode", player.getGameMode().toString());
					uconfig.set("god", false);
					uconfig.set("flyspeed", player.getFlySpeed());
					uconfig.set("walkspeed", player.getWalkSpeed());
					uconfig.set("op", player.isOp());
					uconfig.set("banned", player.isBanned());
					uconfig.set("login", System.currentTimeMillis());
					uconfig.set("logout", null);
					uconfig.set("lastlocation.world", player.getWorld().getName());
					uconfig.set("lastlocation.x", player.getLocation().getX());
					uconfig.set("lastlocation.y", player.getLocation().getY());
					uconfig.set("lastlocation.z", player.getLocation().getZ());
					uconfig.set("lastlocation.yaw", player.getLocation().getYaw());
					uconfig.set("lastlocation.pitch", player.getLocation().getPitch());
					uconfig.set("logoutlocation.world", null);
					uconfig.set("logoutlocation.x", null);
					uconfig.set("logoutlocation.y", null);
					uconfig.set("logoutlocation.z", null);
					uconfig.set("logoutlocation.yaw", null);
					uconfig.set("logoutlocation.pitch", null);
					uconfig.save(dir1);
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				return;
			}
		}
		else {
			dir.mkdirs();
			try {
				dir1.createNewFile();
				YamlConfiguration uconfig = YamlConfiguration.loadConfiguration(dir1);
				uconfig.set("playername", player.getName());
				uconfig.set("displayname", player.getDisplayName());
				uconfig.set("afk", false);
				uconfig.set("hidden", false);
				uconfig.set("messaging", true);
				uconfig.set("rank", null);
				uconfig.set("muted", false);
				uconfig.set("socialspy", false);
				uconfig.set("tptoggled", false);
				uconfig.set("ip", player.getAddress().getHostName());
				uconfig.set("flying", player.isFlying());
				uconfig.set("gamemode", player.getGameMode());
				uconfig.set("god", false);
				uconfig.set("flyspeed", player.getFlySpeed());
				uconfig.set("walkspeed", player.getWalkSpeed());
				uconfig.set("op", player.isOp());
				uconfig.set("banned", player.isBanned());
				uconfig.set("login", System.currentTimeMillis());
				uconfig.set("logout", null);
				uconfig.set("lastlocation.world", player.getWorld().getName());
				uconfig.set("lastlocation.x", player.getLocation().getX());
				uconfig.set("lastlocation.y", player.getLocation().getY());
				uconfig.set("lastlocation.z", player.getLocation().getZ());
				uconfig.set("lastlocation.yaw", player.getLocation().getYaw());
				uconfig.set("lastlocation.pitch", player.getLocation().getPitch());
				uconfig.set("logoutlocation.world", null);
				uconfig.set("logoutlocation.x", null);
				uconfig.set("logoutlocation.y", null);
				uconfig.set("logoutlocation.z", null);
				uconfig.set("logoutlocation.yaw", null);
				uconfig.set("logoutlocation.pitch", null);
				uconfig.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void logoutUpdate(Player player) {
		UUID userID = player.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID);
		File dir1 = new File(dir+File.separator+"user.yml");
		if (dir1.exists()) {
			YamlConfiguration uconfig = YamlConfiguration.loadConfiguration(dir1);
			uconfig.set("playername", player.getName());
			uconfig.set("displayname", player.getDisplayName());
			uconfig.set("afk", false);
			uconfig.set("hidden", false);
			uconfig.set("messaging", Util.allowsMessaging(player));
			uconfig.set("rank", null);
			uconfig.set("muted", Util.isMuted(player));
			uconfig.set("socialspy", Util.isSpying(player));
			uconfig.set("tptoggled", Util.canTP(player));
			uconfig.set("ip", player.getAddress().getHostName());
			uconfig.set("flying", player.isFlying());
			uconfig.set("gamemode", player.getGameMode());
			uconfig.set("god", Util.isGod(player));
			uconfig.set("flyspeed", player.getFlySpeed());
			uconfig.set("walkspeed", player.getWalkSpeed());
			uconfig.set("op", player.isOp());
			uconfig.set("banned", player.isBanned());
			uconfig.set("logout", System.currentTimeMillis());
			uconfig.set("logoutlocation.world", player.getWorld().getName());
			uconfig.set("logoutlocation.x", player.getLocation().getX());
			uconfig.set("logoutlocation.y", player.getLocation().getY());
			uconfig.set("logoutlocation.z", player.getLocation().getZ());
			uconfig.set("logoutlocation.yaw", player.getLocation().getYaw());
			uconfig.set("logoutlocation.pitch", player.getLocation().getPitch());
			try {
				uconfig.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				throw new ConfigNotFoundException();
			} catch (ConfigNotFoundException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void loginUpdate(Player player) {
		UUID userID = player.getUniqueId();
		File dir = new File("plugins"+File.separator+"EssentialCommands"+File.separator+"users"+File.separator+userID);
		File dir1 = new File(dir+File.separator+"user.yml");
		if (dir1.exists()) {
			YamlConfiguration uconfig = YamlConfiguration.loadConfiguration(dir1);
			uconfig.set("playername", player.getName());
			player.setDisplayName(ChatColor.translateAlternateColorCodes('&', uconfig.get("displayname").toString()) + ChatColor.WHITE);
			uconfig.set("messaging", Util.allowsMessaging(player));
			uconfig.set("rank", null);
			PlayerConfig.setMuted(player, uconfig);
			uconfig.set("socialspy", Util.isSpying(player));
			uconfig.set("tptoggled", Util.canTP(player));
			uconfig.set("ip", player.getAddress().getHostName());
			uconfig.set("flying", player.isFlying());
			uconfig.set("gamemode", player.getGameMode());
			uconfig.set("god", Util.isGod(player));
			uconfig.set("flyspeed", player.getFlySpeed());
			uconfig.set("walkspeed", player.getWalkSpeed());
			uconfig.set("op", player.isOp());
			uconfig.set("banned", player.isBanned());
			uconfig.set("login", System.currentTimeMillis());
			try {
				uconfig.save(dir1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				throw new ConfigNotFoundException();
			} catch (ConfigNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	public static void setMuted(Player player, YamlConfiguration config) {
		if (config.get("muted").equals(true)) {
			Util.setMuted(player, MuteStatus.TRUE);
		}
		if (config.get("muted").equals(false)) {
			Util.setMuted(player, MuteStatus.FALSE);
		}
		else throw new UnknownStatusException();
	}
	public static void setSpying(Player player, YamlConfiguration config) {
		if (config.get("socialspy").equals(true)) {
			Util.setMuted(player, MuteStatus.TRUE);
		}
		if (config.get("socialspy").equals(false)) {
			Util.setMuted(player, MuteStatus.FALSE);
		}
		else throw new UnknownStatusException();
	}
}

	

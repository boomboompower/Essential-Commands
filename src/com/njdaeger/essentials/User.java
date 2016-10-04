package com.njdaeger.essentials;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.njdaeger.essentials.enums.Permission;

public abstract interface User {
	
	boolean isAllowed(Permission permission);
	
	boolean isAfk();
	
	void sendMessage(String message);
	
	Location getLocation(Player p);
	
	boolean isMuted();
	
	Player getBase();
	
	
}

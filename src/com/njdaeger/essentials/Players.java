package com.njdaeger.essentials;

import org.bukkit.Location;

import com.njdaeger.essentials.enums.Permission;

public abstract class Players implements com.njdaeger.essentials.User{
	
	public boolean isAllowed(Permission permission) {
		return this.getBase().hasPermission(permission.getPermission());
	}

	public boolean isAfk() {
		return Groups.afk.contains(this.getBase());
	}

	public void sendMessage(String message) {
		this.getBase().sendMessage(message);
	}

	public Location getLocation() {
		return this.getBase().getLocation();
	}

	public boolean isMuted() {
		return Groups.muted.contains(this.getBase());
	}
}

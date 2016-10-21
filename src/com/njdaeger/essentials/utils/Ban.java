package com.njdaeger.essentials.utils;

import java.util.Date;
import java.util.Set;

import org.bukkit.BanEntry;
import org.bukkit.BanList;

public abstract class Ban implements BanList{
	
	public BanEntry addBan(String target, String reason, Date expires, String source) {
		return null;
	}

	public Set<BanEntry> getBanEntries() {
		return null;
	}

	public BanEntry getBanEntry(String target) {
		return null;
	}

	public boolean isBanned(String target) {
		return false;
	}

	public void pardon(String target) {
		
	}
}

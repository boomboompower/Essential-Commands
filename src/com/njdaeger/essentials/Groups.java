package com.njdaeger.essentials;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Groups {
	public static ArrayList<Player> afk = new ArrayList<Player>();
	
	public static ArrayList<Player> vanish = new ArrayList<Player>();
	
	public static ArrayList<Player> tptoggled = new ArrayList<Player>();
	
	public static ArrayList<Player> muted = new ArrayList<Player>();
	
	public static HashMap<String, Location> afkloc = new HashMap<String, Location>();
}

package com.njdaeger.essentials.enums;

import net.md_5.bungee.api.ChatColor;

public enum Error{
	
	NOT_ENOUGH_ARGS {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "Not enough arguments.";
			return error;
		}
	},
	TOO_MANY_ARGS {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "Too many arguments.";
			return error;
		}
	},
	NO_PERMISSION {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "You don't have permission.";
			return error;
		}
	},
	UNKNOWN_PLAYER {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "Unknown player.";
			return error;
		}
	},
	PLAYER_ONLY {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "Only players can do that.";
			return error;
		}
	},
	UNKNOWN_GAMEMODE {

		@Override
		public String sendError() {
			String error = ChatColor.RED + "Unknown gamemode.";
			return error;
		}
		
	},
	ALREADY_GAMEMODE_P { // player

		@Override
		public String sendError() {
			String error = ChatColor.RED + "You are already in that gamemode.";
			return error;
		}
		
	},
	ALREADY_GAMEMODE_C { //console

		@Override
		public String sendError() {
			String error = ChatColor.RED + "That player is already in that gamemode.";
			return error;
		}
		
	},
	INPUT_NOT_NUM {

		@Override
		public String sendError() {
			String error = ChatColor.RED + "Input has to be an integer.";
			return error;
		}
		
	},
	UNKNOWN_ITEM {

		@Override
		public String sendError() {
			String error = ChatColor.RED + "Unknown item.";
			return error;
		}
		
	},
	INVENTORY_IS_FULL_P {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "Your inventory is full!";
			return error;
		}
	},
	INVENTORY_IS_FULL_PO {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "That player's inventory is full!";
			return error;
		}
	},
	INVENTORY_IS_FULL_C {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "That player's inventory is full!";
			return error;
		}
	},
	NICKNAME_TOO_LONG {

		@Override
		public String sendError() {
			String error = ChatColor.RED + "The nickname given is too long.";
			return error;
		}
		
	},
	PLAYER_IS_OPPED {
		
		@Override
		public String sendError() {
			String error = ChatColor.RED + "Cannot execute command. Target is opped.";
			return error;
		}
		
	},
	INPUT_TOO_LARGE {

		@Override
		public String sendError() {
			String error = ChatColor.RED + "The input used is too large.";
			return error;
		}
		
	},
	UNKNOWN_WALK_TYPE {

		@Override
		public String sendError() {
			String error = ChatColor.RED + "That walking type is unknown.";
			return error;
		}
		
	},
	INPUT_TOO_SMALL {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "The input used is too small.";
			return error;
		}
	},
	MESSAGING_DISABLED_TARGET {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "The target specified has their messaging disabled.";
			return error;
		}
	},
	MESSAGING_DISABLED_SENDER {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "You have your messaging disabled.";
			return error;
		}
	},
	CANNOT_BAN_TARGET {

		@Override
		public String sendError() {
			String error = ChatColor.RED + "Player cannot be banned.";
			return error;
		}
		
	},
	UNKNOWN_BAN_TYPE {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "Unknown ban type.";
			return error;
		}
	},
	BAN_WRONG_FORMAT {
		@Override
		public String sendError() {
			String error = ChatColor.RED + "Insert a \":\" between the time and the ban type.";
			return error;
		}
	};
	
	public abstract String sendError();
	
}

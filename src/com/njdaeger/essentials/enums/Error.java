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
		
	};
	
	public abstract String sendError();
	
}

package com.njdaeger.essentials.enums;

public enum Permission {
	
	ESS_ALL {

		@Override
		public String getPermission() {
			String permission = "essentials.*";
			return permission;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.*");
			return permission;
		}
		
	},
	ESS_AFK {
		@Override
		public String getPermission() {
			String permission = "essentials.afk";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/afk";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.afk");
			return permission;
		}
	},
	ESS_AFK_OTHER {
		@Override
		public String getPermission() {
			String permission = "essentials.afk.other";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/afk";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.afk.other");
			return permission;
		}
	},
	ESS_BACK {
		@Override
		public String getPermission() {
			String permission = "essentials.back";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/back";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.back");
			return permission;
		}
	},
	ESS_BAN {

		@Override
		public String getPermission() {
			String permission = "essentials.ban";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/ban";
			return command;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.ban");
			return permission;
		}
		
	},
	ESS_BREAK {
		@Override
		public String getPermission() {
			String permission = "essentials.break";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/break";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.break");
			return permission;
		}
	},
	ESS_BROADCAST {

		@Override
		public String getPermission() {
			String permission = "essentials.broadcast";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.broadcast");
			return permission;
		}
	},
	ESS_CHATCOLOR {

		@Override
		public String getPermission() {
			String permission = "essentials.chatcolor";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.chatcolor");
			return permission;
		}
		
	},
	ESS_FLY {
		@Override
		public String getPermission() {
			String permission = "essentials.fly";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/fly";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.fly");
			return permission;
		}
	},
	ESS_FLY_OTHER {
		
		@Override
		public String getPermission() {
			String permission = "essentials.fly.other";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/fly";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.fly.other");
			return permission;
		}
	},
	ESS_GAMEMODE {
		@Override
		public String getPermission() {
			String permission = "essentials.gamemode";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/gamemode";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.gamemode");
			return permission;
		}
	},
	ESS_GAMEMODE_OTHER {
		@Override
		public String getPermission() {
			String permission = "essentials.gamemode.other";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/gamemode";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.gamemode.other");
			return permission;
		}
	},
	ESS_GIVE {

		@Override
		public String getPermission() {
			String permission = "essentials.give";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/i";
			return command;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.give");
			return permission;
		}
		
	},
	ESS_GIVE_OTHER {

		@Override
		public String getPermission() {
			String permission = "essentials.give.other";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/i";
			return command;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.give.other");
			return permission;
		}
		
	},
	ESS_SERVER_INFO {
		
		@Override 
		public String getCommand() {
			String command = "serverinfo";
			return command;
		}
		
		@Override
		public String getPermission() {
			String permission = "essentials.serverinfo";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.serverinfo");
			return permission;
		}
		
	},
	ESS_SPEED {
		@Override
		public String getPermission() {
			String permission = "essentials.speed";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/speed";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.speed");
			return permission;
		}
	},
	ESS_SPEED_OTHER {
		
		@Override
		public String getPermission() {
			String permission = "essentials.speed.other";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/speed";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.speed.other");
			return permission;
		}
	},
	ESS_GOD {

		@Override
		public String getPermission() {
			String permission = "essentials.god";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.god");
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/god";
			return command;
		}
		
	},
	ESS_GOD_OTHER {

		@Override
		public String getPermission() {
			String permission = "essentials.god.other";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.god.other");
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/god";
			return command;
		}
		
	},
	ESS_NICK {

		@Override
		public String getPermission() {
			String permission = "essentials.nick";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.nick");
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/nick";
			return command;
		}
	
	}, 
	ESS_NICK_OTHER {

		@Override
		public String getPermission() {
			String permission = "essentials.nick.other";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission("essentials.nick.other");
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/nick";
			return command;
		}
		
	};
	
	public String perm = "";
	public abstract String getPermission();
	public abstract org.bukkit.permissions.Permission registerPermission();
	public String getCommand() {
		return null;
	}
}

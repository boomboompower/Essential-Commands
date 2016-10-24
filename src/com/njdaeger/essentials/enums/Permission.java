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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_ALL.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_AFK.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_AFK_OTHER.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_BACK.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_BAN.getPermission());
			return permission;
		}
		
	},
	ESS_BAN_NOTIFY {

		@Override
		public String getPermission() {
			String permission = "essentials.ban.notify";
			return permission;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_BAN_NOTIFY.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_BREAK.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_BROADCAST.getPermission());
			return permission;
		}
	},
	ESS_BURN {

		@Override
		public String getPermission() {
			String permission = "essentials.burn";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_BURN.getPermission());
			return permission;
		}
		@Override 
		public String getCommand() {
			String command = "/burn";
			return command;
		}
		
	},
	ESS_BURN_OTHER {

		@Override
		public String getPermission() {
			String permission = "essentials.burn.other";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_BURN_OTHER.getPermission());
			return permission;
		}
		@Override 
		public String getCommand() {
			String command = "/burn";
			return command;
		}
		
	},
	ESS_CLEAR {

		@Override
		public String getPermission() {
			String permission = "essentials.clear";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_CLEAR.getPermission());
			return permission;
		}
		@Override 
		public String getCommand() {
			String command = "/clear";
			return command;
		}
		
	},
	ESS_CLEAR_OTHER {

		@Override
		public String getPermission() {
			String permission = "essentials.clear.other";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_CLEAR_OTHER.getPermission());
			return permission;
		}
		@Override 
		public String getCommand() {
			String command = "/clear";
			return command;
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_CHATCOLOR.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_FLY.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_FLY_OTHER.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_GAMEMODE.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_GAMEMODE_OTHER.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_GIVE.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_GIVE_OTHER.getPermission());
			return permission;
		}
		
	},
	ESS_GOD{
	
		@Override
		public String getPermission() {
			String permission = "essentials.god";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_GOD.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/god";
			return command;
		}
		
	}, 
	ESS_GOD_OTHER{
	
		@Override
		public String getPermission() {
			String permission = "essentials.god.other";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_GOD_OTHER.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/god";
			return command;
		}
		
	},
	ESS_HEAL {

		@Override
		public String getPermission() {
			String permission = "essentials.heal";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_HEAL.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/heal";
			return command;
		}
	},
	ESS_HEAL_OTHER {
		@Override
		public String getPermission() {
			String permission = "essentials.heal.other";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_HEAL_OTHER.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/heal";
			return command;
		}
	},
	ESS_ME {

		@Override
		public String getPermission() {
			String permission = "essentials.me";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_ME.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/me";
			return command;
		}
		
	},
	ESS_ME_CHATCOLOR {

		@Override
		public String getPermission() {
			String permission = "essentials.me.chatcolor";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_ME_CHATCOLOR.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/me";
			return command;
		}
	},
	ESS_MESSAGE {
		@Override
		public String getPermission() {
			String permission = "essentials.message";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_MESSAGE.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/message";
			return command;
		}
	},
	ESS_MESSAGE_CHATCOLOR {
		@Override
		public String getPermission() {
			String permission = "essentials.message.chatcolor";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_MESSAGE_CHATCOLOR.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/message";
			return command;
		}
	},
	ESS_NICK{
	
		@Override
		public String getPermission() {
			String permission = "essentials.nick";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_NICK.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/nick";
			return command;
		}
	
	}, 
	ESS_NICK_OTHER{
	
		@Override
		public String getPermission() {
			String permission = "essentials.nick.other";
			return permission;
		}
	
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_NICK_OTHER.getPermission());
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/nick";
			return command;
		}
		
	},
	ESS_POSITION {
		@Override 
		public String getCommand() {
			String command = "/position";
			return command;
		}
		
		@Override
		public String getPermission() {
			String permission = "essentials.position";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_POSITION.getPermission());
			return permission;
		}
	},
	ESS_POSITION_OTHER {
		@Override 
		public String getCommand() {
			String command = "/position";
			return command;
		}
		
		@Override
		public String getPermission() {
			String permission = "essentials.position.other";
			return permission;
		}

		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_POSITION_OTHER.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_SERVER_INFO.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_SPEED.getPermission());
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
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_SPEED_OTHER.getPermission());
			return permission;
		}
	},
	ESS_TEMPBAN {
		@Override
		public String getPermission() {
			String permission = "essentials.tempban";
			return permission;
		}
		@Override
		public String getCommand() {
			String command = "/tempban";
			return command;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_TEMPBAN.getPermission());
			return permission;
		}
	},
	ESS_BAN_EXEMPT {
		@Override
		public String getPermission() {
			String permission = "essentials.ban.protect";
			return permission;
		}
		@Override
		public org.bukkit.permissions.Permission registerPermission() {
			org.bukkit.permissions.Permission permission = new org.bukkit.permissions.Permission(ESS_BAN_EXEMPT.getPermission());
			return permission;
		}
	};
	
	public String perm = "";
	public abstract String getPermission();
	public abstract org.bukkit.permissions.Permission registerPermission();
	public String getCommand() {
		return null;
	}
}

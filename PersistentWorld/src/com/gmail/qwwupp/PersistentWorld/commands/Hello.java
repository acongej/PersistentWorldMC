package com.gmail.qwwupp.PersistentWorld.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hello implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("hello")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot execute this command.");
				return false;
			}

			Player player = (Player) sender;
			player.sendMessage("gg");

			return true;
		}
		return false;
	}
	
}

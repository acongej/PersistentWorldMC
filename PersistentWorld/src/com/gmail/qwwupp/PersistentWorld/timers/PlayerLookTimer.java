package com.gmail.qwwupp.PersistentWorld.timers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.qwwupp.PersistentWorld.PersistentWorld;

import net.md_5.bungee.api.ChatColor;

public class PlayerLookTimer extends BukkitRunnable {

	PersistentWorld plugin;
	
	public PlayerLookTimer(PersistentWorld plugin) {
		
	}
	
	@Override
	public void run() {
	//	Bukkit.broadcastMessage(ChatColor.GOLD + "Players online: ");
	//	Bukkit.getServer().getOnlinePlayers().size();
		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
			if(player.getExp() == 0.0f) {
				player.setLevel(-1000);
			}
			else if(player.getExp() > 0.0f) {
				player.setLevel(0);
			}
		}
	}

}

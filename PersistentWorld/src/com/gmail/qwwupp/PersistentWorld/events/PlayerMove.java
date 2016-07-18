package com.gmail.qwwupp.PersistentWorld.events;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();

		Block tarBlock = player.getTargetBlock((Set<Material>) null, 3);
		Location loc = tarBlock.getLocation();
		Material material = tarBlock.getType();
		
		if(material == Material.IRON_ORE) {
			player.setLevel(0);
			player.setExp(IronOreBlockBreak.publicXP);
			//player.setExp(arg0);
		}
		else {
			player.setLevel(-1000);
		}
	}
}

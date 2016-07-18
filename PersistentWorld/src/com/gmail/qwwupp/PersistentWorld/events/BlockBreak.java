package com.gmail.qwwupp.PersistentWorld.events;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.qwwupp.PersistentWorld.iw.DirectDrop;



public class BlockBreak implements Listener {
	
	//create a hashmap to store the location of a block and a counter
	public static HashMap<Location, Integer> breaksCounter = new HashMap<Location, Integer>(); 
	public static HashMap<Location, Integer> payoutsCounter = new HashMap<Location, Integer>();
	
	//create a new instance of directdrop
	private DirectDrop dd = new DirectDrop();

	//meat
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();

		Block block = event.getBlock();
		Location loc = block.getLocation();
		Material material = block.getType();

		//if the block was iron ore
		if (material == Material.IRON_ORE) {
			
			//cancel the event
			event.setCancelled(true);
			
			
			//what should we drop?
			ItemStack whatToDrop = new ItemStack(Material.IRON_ORE, 1);
			
			
			//what percentage of the total should we break the block for it to drop?
			int breaksForPayout = 2;
			
			int totalPayout = 4;

			//if the counter knows this block exists
			if (breaksCounter.containsKey(loc)) {
				
				
				//add 1 to the break counter 
				breaksCounter.put(loc, breaksCounter.get(loc) + 1);
				//get the break counter
				int i = breaksCounter.get(loc);
				
				//get the payout counter
				int ii = payoutsCounter.get(loc);

				//if the counter hits the payout
				if (i == breaksForPayout) {
					//set the counter to 0
					breaksCounter.put(loc, 0);
					//direct-drop to the player
					dd.drop(player, whatToDrop);
					
					//add to how many times this block has paid out
					payoutsCounter.put(loc, ii + 1);
					
					//if this block has paid out all it can
					if (payoutsCounter.get(loc) == totalPayout) {
						//destroy the block
						block.setType(Material.AIR);
						
						//reset the payout counter
						payoutsCounter.put(loc, 0);
					}
				}
			}
			//if the counter doesnt know this block exists
			else if (!(breaksCounter.containsKey(loc))){
				
				//tell the break counter it has just been broken
				breaksCounter.put(loc, 1);
				
				//we assume it has only just been broken, so it can't have paid out yet
				payoutsCounter.put(loc, 0);
			}
			
			//update xp bar 'progress'
			//cast the payouts to a float
			float payoutsCounterf = (float) payoutsCounter.get(loc);
			//bleh math
			float xp = 1.0f - (payoutsCounterf / totalPayout);
			//set xp float 0.0 to 1.0 (percentage of total bar)
			player.setExp(xp);
			
			//debug stuff
			//player.sendMessage("breaks: " + breaksCounter.get(loc));
			//player.sendMessage("payouts: " + payoutsCounter.get(loc));
			//player.sendMessage(Float.toString(xp));
		}
	}
}

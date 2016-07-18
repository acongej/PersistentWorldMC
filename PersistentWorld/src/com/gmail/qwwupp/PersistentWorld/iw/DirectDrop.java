package com.gmail.qwwupp.PersistentWorld.iw;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DirectDrop {
	public void drop(Player p, ItemStack is) {
		Inventory inv = p.getInventory();

		inv.addItem(is);
		p.sendMessage(ChatColor.AQUA + "You recieved " + 
				ChatColor.GREEN + Integer.toString(is.getAmount()) + "x " + 
				ChatColor.WHITE + is.getType() + 
				ChatColor.AQUA + ".");

	}

}
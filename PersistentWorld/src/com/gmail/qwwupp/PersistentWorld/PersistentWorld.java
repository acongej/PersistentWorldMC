package com.gmail.qwwupp.PersistentWorld;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.gmail.qwwupp.PersistentWorld.commands.Hello;
import com.gmail.qwwupp.PersistentWorld.events.IronOreBlockBreak;
import com.gmail.qwwupp.PersistentWorld.events.PlayerMove;
import com.gmail.qwwupp.PersistentWorld.timers.PlayerLookTimer;

public class PersistentWorld extends JavaPlugin {

	//public static PluginManager pm;
	//public static BukkitScheduler bs;
	
	
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		registerCommands();
		registerEvents();
		registerTimers();
		
		
		logger.info("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + " has been enabled.");

	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + " has been disabled.");

	}
	
	
	public void registerCommands() {
		getCommand("hello").setExecutor(new Hello()); //Set /hello to look in com.gmail.qwwupp.PersistentWorld.commands.Hello.java
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new IronOreBlockBreak(), this);
		pm.registerEvents(new PlayerMove(), this);
	}

	public void registerTimers() {
		PlayerLookTimer plt = new PlayerLookTimer(this);
		plt.runTaskTimer(this, 0L, 60L);
	}
	
}

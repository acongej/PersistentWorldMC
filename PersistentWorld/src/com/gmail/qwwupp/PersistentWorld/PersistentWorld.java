package com.gmail.qwwupp.PersistentWorld;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.qwwupp.PersistentWorld.commands.Hello;
import com.gmail.qwwupp.PersistentWorld.events.BlockBreak;

public class PersistentWorld extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		registerCommands();
		registerEvents();
		
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
		pm.registerEvents(new BlockBreak(), this);
	}

	
}

package me.deathSwap.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.deathSwap.commands.Commands;
import me.deathSwap.listeners.Listeners;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable(){
		new Commands(this);
		getServer().getPluginManager().registerEvents(new Listeners(), this);

	}
}

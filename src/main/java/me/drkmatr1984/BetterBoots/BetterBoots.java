package me.drkmatr1984.BetterBoots;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class BetterBoots extends JavaPlugin
{
    public static BetterBoots plugin;
	public static FileConfiguration c;
	private Logger log = getLogger();
	PluginManager pm = getServer().getPluginManager();

	public void onEnable()
	{
		plugin = this;
		initConfig();
		initBootsRecipes();
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.FlightListener(), this);
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.DurabilityListener(), this);
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.Checkers(), this);
		if(c.getBoolean("ENABLEMETRICS") == true)
			initMetrics(this);
		getServer().getConsoleSender().sendMessage("§F[BetterBoots] Loading BetterBoots, Powered by §5Tussin§F!§r");
		getServer().getLogger().info("[BetterBoots] Loaded");
	}
	
	
	private void initMetrics(Plugin pl) {
		try {
			Metrics metrics = new Metrics(pl);
			metrics.start();
			log.info("Metrics enabled!");
		} catch (IOException e) {
			log.info("Failed to submit stats to MCStats.org");
		}
	}
	
	private void initConfig() {
		c = getConfig();
		c.options().copyDefaults(true);
		saveConfig();
	}
	
	private void initBootsRecipes()
	{
		Boots.FlightBoots();
		Boots.SpeedBoots();
	}
    
	public void onDisable()
    {
		getServer().getConsoleSender().sendMessage("§F[BetterBoots] Disabling BetterBoots, §5Tussin §Fwore off!§r");
		getServer().getLogger().info("[BetterBoots] Unloaded");
    }
}

package me.drkmatr1984.BetterBoots;

import java.io.File;
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
	public static File language;
	private Logger log = getLogger();
	PluginManager pm = getServer().getPluginManager();

	public void onEnable()
	{
		plugin = this;
		initConfig();
		initBootsRecipes();
		initListeners();
		getServer().getConsoleSender().sendMessage("§F[BetterBoots] Loading BetterBoots, Powered by §5Tussin§F!§r");
		if(ConfigAccessor.EnableMetrics == true){
			initMetrics(this);
			getServer().getConsoleSender().sendMessage("§F[BetterBoots] Plugin Metrics Enabled. Set 'ENABLEMETRICS' in Config.yml to false to disable this");
		}
		if(VanishNoPacketCheck()){
			getServer().getConsoleSender().sendMessage("§F[BetterBoots] §5VanishNoPacket§F detected! Using §5VanishNoPacket§F to handle SneakBoots!§r");
		}
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
		saveDefaultConfig();
    	c = this.getConfig();
    	ConfigAccessor.LoadConfiguration(c);
	}
	
	private void deInitConfig(){
		ConfigAccessor.SaveConfiguration(c);
		this.saveConfig();
	}
	
	private void initBootsRecipes()
	{
		Boots.FlightBoots();
		Boots.SpeedBoots();
		Boots.SneakBoots();
		Boots.IceBoots();
		Boots.HeavyBoots();
	}
	
	private void initListeners()
	{
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.FlightListener(), this);
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.SprintListener(), this);
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.SneakListener(), this);
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.IceListener(), this);
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.HeavyListener(), this);
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.DurabilityListener(), this);
		pm.registerEvents(new me.drkmatr1984.BetterBoots.Listeners.Checkers(), this);
	}
	
	public static boolean VanishNoPacketCheck()
    {
		if (plugin.getServer().getPluginManager().isPluginEnabled("VanishNoPacket")) {
			return true;
		}
		return false;
    }  
    
	public void onDisable()
    {
		deInitConfig();
		getServer().getConsoleSender().sendMessage("§F[BetterBoots] Disabling BetterBoots, §5Tussin §Fwore off!§r");
		getServer().getLogger().info("[BetterBoots] Unloaded");
    }
}

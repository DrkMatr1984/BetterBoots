package me.drkmatr1984.BetterBoots;

import org.bukkit.configuration.Configuration;

public class ConfigAccessor {

	// Config default values
	public static Double SprintSpeed = 0.1;
	public static Double FlightSpeed = 0.1;
	public static boolean EnableMetrics = true;
	public static boolean UseDurability = true;
	
    public static void LoadConfiguration(Configuration config) {
        try {
        	SprintSpeed = config.getDouble("general.SPRINTSPEED");
        	FlightSpeed = config.getDouble("general.FLIGHTSPEED");
        	EnableMetrics = config.getBoolean("general.ENABLEMETRICS");
        	UseDurability = config.getBoolean("general.DURABILITY");
        	
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
    public static void SaveConfiguration(Configuration config) {
    	config.set("general.SPRINTSPEED", SprintSpeed);
    	config.set("general.FLIGHTSPEED", FlightSpeed);
    	config.set("general.ENABLEMETRICS", EnableMetrics);
    	config.set("general.DURABILITY", UseDurability);
    }
    
}

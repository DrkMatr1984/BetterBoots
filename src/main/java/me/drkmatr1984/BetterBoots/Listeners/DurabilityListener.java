package me.drkmatr1984.BetterBoots.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.permissions.Permission;

public class DurabilityListener implements Listener
{
        //Durability Algorithms for the FlightBoots
		@EventHandler
        public void onBootsFlight(PlayerToggleFlightEvent event){
        	Player p = event.getPlayer();
        	if(p.getEquipment().getBoots() != null){
        		if((p.getEquipment().getBoots().getType().equals(Material.DIAMOND_BOOTS)) && (p.getEquipment().getBoots().getItemMeta().getDisplayName().contains("FlightBoots"))) {
        			if((p.getEquipment().getBoots().hasItemMeta()) && (!(p.getEquipment().getBoots().getItemMeta().getLore().isEmpty()) && (p.hasPermission(new Permission("BetterBoots.FlightBoots"))))){
        			if(p.isFlying()){
        				if(me.drkmatr1984.BetterBoots.BetterBoots.c.getBoolean("DURABILITY") == true){
        				short dur = p.getEquipment().getBoots().getDurability();
        				dur = ((short) (dur + 40));
	                    p.getEquipment().getBoots().setDurability(dur);
        				}
	                    if((p.getEquipment().getBoots().getType().getMaxDurability() - 80) == p.getEquipment().getBoots().getDurability()){
	                    	   p.sendMessage(p.getDisplayName() + ChatColor.YELLOW + ", Your boots are almost used up!" + ChatColor.RESET);
	                       }
	                       if(p.getEquipment().getBoots().getType().getMaxDurability() == p.getEquipment().getBoots().getDurability()){
	                    	   if((p.hasPermission("essentials.fly") || p.getGameMode() == GameMode.CREATIVE) && p.isFlying()){
	                         	 p.setFlying(true);
	                         	 p.setAllowFlight(true);
	                    	     }else{
	                    	     p.getEquipment().setBoots(null);
		                         p.setFlying(false);
		                         p.setAllowFlight(false);
		                         p.sendMessage(p.getDisplayName() + ChatColor.RED + ", Your boots broke!" + ChatColor.RESET);
	                    	     } 
	                      }
        			}
        		}
        	}
        	}
        }
}
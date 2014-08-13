package me.drkmatr1984.BetterBoots.Listeners;
import me.drkmatr1984.BetterBoots.ConfigAccessor;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;


public class FlightListener implements Listener
{
	@EventHandler
    public void onFlight(PlayerMoveEvent event)
	{
		Player p = event.getPlayer();
		ItemStack is = p.getEquipment().getBoots();
		if((is != null) && (is.getType() != Material.AIR)){
			if(is.getType().equals(Material.DIAMOND_BOOTS)){
				if(Checkers.canFlyCheck(p)){
					event.setCancelled(false);
				}else if(!(Checkers.canFlyCheck(p))){
					if(is != null){
						if(Checkers.isFlightBoots(is) && (p.hasPermission(Permissions.canHasFlightBoots))){
								String i = ConfigAccessor.FlightSpeed.toString();
								float speed = Float.parseFloat(i);
								p.setAllowFlight(true);
								p.setFlySpeed(speed);
							}else{
								p.setAllowFlight(false);
								p.setFlying(false);
							}
					}
				}
			}
		}
	}	
}    


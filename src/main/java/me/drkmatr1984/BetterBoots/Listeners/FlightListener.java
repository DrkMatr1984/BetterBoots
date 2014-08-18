package me.drkmatr1984.BetterBoots.Listeners;
import me.drkmatr1984.BetterBoots.ConfigAccessor;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;


public class FlightListener implements Listener
{
	@EventHandler
    public void onPlayerFlight(PlayerMoveEvent event)
	{
		Player p = event.getPlayer();
		ItemStack is = p.getEquipment().getBoots();
		if(Checkers.canFlyCheck(p)){
			return;
		}
		if(!(Checkers.isFlightBoots(is))){
			p.setAllowFlight(false);
		}
		if(Checkers.isBoots(is)){
			if((Checkers.isFlightBoots(is)) && (p.hasPermission(Permissions.canHasFlightBoots))){
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
	
	@EventHandler
	public void playerDeathSprint(PlayerDeathEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			p.setAllowFlight(false);
			p.setFlying(false);
		}
	}
}	


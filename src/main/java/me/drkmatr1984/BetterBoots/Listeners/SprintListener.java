package me.drkmatr1984.BetterBoots.Listeners;

import me.drkmatr1984.BetterBoots.BetterBoots;
import me.drkmatr1984.BetterBoots.ConfigAccessor;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;


public class SprintListener implements Listener
{

	@EventHandler
	public void onPlayerSprint(PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		ItemStack is = null;
		is = p.getInventory().getBoots();
		if(Checkers.isBoots(is)){
			if(Checkers.isSpeedBoots(is) && (p.hasPermission(Permissions.canHasSpeedBoots))){
				BetterBoots.plugin.getServer().getScheduler().scheduleSyncDelayedTask(BetterBoots.plugin, new Runnable() {
					public void run() {
						if(p.isSprinting())
						{
							String i = ConfigAccessor.SprintSpeed.toString();
							float speed = Float.parseFloat(i);
							p.setWalkSpeed(speed);
							p.setSprinting(true);
						}
					}
				}, 1L);	
				
			}
			if(Checkers.isSpeedBoots(is) && (p.hasPermission(Permissions.canHasSpeedBoots))){
				BetterBoots.plugin.getServer().getScheduler().scheduleSyncDelayedTask(BetterBoots.plugin, new Runnable() {
				public void run() {
					if(!(p.isSprinting())){
						p.setWalkSpeed(0.2f);
						p.setSprinting(false);
					}
				}
			}, 1L);	
				
			}
		}
	}
	
	@EventHandler
	public void playerDeathSprint(PlayerDeathEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			p.setWalkSpeed(0.2f);
		}
	}
}	

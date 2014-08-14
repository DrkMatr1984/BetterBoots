package me.drkmatr1984.BetterBoots.Listeners;

import me.drkmatr1984.BetterBoots.ConfigAccessor;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;


public class SprintListener implements Listener
{

	@EventHandler
	public void onPlayerSprint(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		ItemStack is = null;
		is = p.getInventory().getBoots();
		if(Checkers.isBoots(is)){
			if(Checkers.isSpeedBoots(is) && (p.hasPermission(Permissions.canHasSpeedBoots)) && (p.isSprinting())){
				String i = ConfigAccessor.SprintSpeed.toString();
				float speed = Float.parseFloat(i);
				p.setWalkSpeed(speed);
				p.setSprinting(true);
			}
			if(!(p.isSprinting()) && Checkers.isSpeedBoots(is) && (p.hasPermission(Permissions.canHasSpeedBoots))){
				p.setWalkSpeed(0.2f);
				p.setSprinting(false);
			}
		}	
	}
}	

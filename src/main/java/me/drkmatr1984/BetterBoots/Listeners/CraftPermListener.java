package me.drkmatr1984.BetterBoots.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import me.drkmatr1984.BetterBoots.Permissions;

/*This class checks when player is crafting if they have to permission to craft different types of BetterBoots*/	
public class CraftPermListener implements Listener{
	@EventHandler
	public void Craft(CraftItemEvent event) {
		Player p = (Player) event.getWhoClicked();
		ItemStack is = event.getInventory().getContents()[ 0];
		if(Checkers.isBoots(is)){
			if(!(CraftBootsCheck(p, is))){
				event.setCancelled(true);
			}
		}
		event.setCancelled(false);
    }
	
	//Checks if the specified player has permission to craft boots and returns true if they do
	private boolean CraftBootsCheck(Player player, ItemStack is){
		if(Checkers.isFlightBoots(is) && player.hasPermission(Permissions.canCraftFlightBoots)){
			return true;
		}
		return false;
	}
	
}
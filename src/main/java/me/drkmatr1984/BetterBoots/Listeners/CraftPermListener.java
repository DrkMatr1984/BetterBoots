package me.drkmatr1984.BetterBoots.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Recipe;

import me.drkmatr1984.BetterBoots.Boots;
import me.drkmatr1984.BetterBoots.Permissions;
import me.drkmatr1984.BetterBoots.Util.RecipeUtil;

/*This class checks when player is crafting if they have the permission to craft the type of BetterBoots they are trying to craft*/	
public class CraftPermListener implements Listener{
	
	@EventHandler
	public void onCraft(CraftItemEvent event) {
		Player p = (Player) event.getWhoClicked();
		Recipe is = event.getRecipe();
		event.setCancelled(CraftBootsCheck(p, is));
    }
	
	//Checks if the specified player has permission to craft boots and returns true if they do
	private boolean CraftBootsCheck(Player p, Recipe is){
		if(RecipeUtil.areEqual(is, (Recipe)Boots.FlightBootsRecipe))
		{
			if(!(p.hasPermission(Permissions.canCraftFlightBoots))){
				return true;
			}
		}
		if(RecipeUtil.areEqual(is, (Recipe)Boots.SneakBootsRecipe))
		{
			if(!(p.hasPermission(Permissions.canCraftSneakBoots))){
				return true;
			}
		}
		if(RecipeUtil.areEqual(is, (Recipe)Boots.SpeedBootsRecipe))
		{
			if(!(p.hasPermission(Permissions.canCraftSpeedBoots))){
				return true;
			}
		}
		if(RecipeUtil.areEqual(is, (Recipe)Boots.IceBootsRecipe))
		{
			if(!(p.hasPermission(Permissions.canCraftIceBoots))){
				return true;
			}
		}
		if(RecipeUtil.areEqual(is, (Recipe)Boots.HeavyBootsRecipe))
		{
			if(!(p.hasPermission(Permissions.canCraftHeavyBoots))){
				return true;
			}
		}
		return false;
	}
	
}
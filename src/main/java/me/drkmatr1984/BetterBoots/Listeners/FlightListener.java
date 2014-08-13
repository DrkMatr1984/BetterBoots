package me.drkmatr1984.BetterBoots.Listeners;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.permissions.Permission;


public class FlightListener implements Listener
{
	@EventHandler
    public void onFlight(PlayerMoveEvent event)
	{
		Player p = event.getPlayer();
		if((p.hasPermission("essentials.fly")) || (p.getGameMode() == GameMode.CREATIVE)){
			event.setCancelled(false);
		}else if(!(p.hasPermission("essentials.fly")) || !(p.getGameMode() == GameMode.CREATIVE)){
		if((p.getEquipment().getBoots() != null) && (p.getEquipment().getBoots().getType().equals(Material.DIAMOND_BOOTS)) && (p.getEquipment().getBoots().getItemMeta().getDisplayName().contains("FlightBoots")) && (p.getEquipment().getBoots().hasItemMeta()) && (!(p.getEquipment().getBoots().getItemMeta().getLore().isEmpty()) && (p.hasPermission(new Permission("BetterBoots.flightboots"))))){
					String i = me.drkmatr1984.BetterBoots.BetterBoots.c.getString("FLIGHTSPEED");
    				float speed = Float.parseFloat(i);
    				p.setAllowFlight(true);
    				p.setFlySpeed(speed);
			}else{
				p.setAllowFlight(false);
				p.setFlying(false);
	    	}
		if((p.getEquipment().getBoots() != null) && (p.getEquipment().getBoots().getType().equals(Material.DIAMOND_BOOTS)) && (p.getEquipment().getBoots().getItemMeta().getDisplayName().contains("FlightBoots")) && (p.getEquipment().getBoots().hasItemMeta()) && ((p.getEquipment().getBoots().getItemMeta().getLore().isEmpty()) && (p.hasPermission(new Permission("BetterBoots.flightboots"))))){
			p.sendMessage(ChatColor.RED + "Ya can't bootleg these boots, brosky!" + ChatColor.RESET);
		}
		}	
	}	
}    


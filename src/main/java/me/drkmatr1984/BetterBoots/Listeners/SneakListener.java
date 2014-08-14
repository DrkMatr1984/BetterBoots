package me.drkmatr1984.BetterBoots.Listeners;

import me.drkmatr1984.BetterBoots.BetterBoots;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class SneakListener implements Listener
{

	@EventHandler
	public void onPlayerSneak(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		ItemStack is = null;
		is = p.getInventory().getBoots();
		if(Checkers.isBoots(is)){
			if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
				if(!(BetterBoots.VanishNoPacketCheck())){
					p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false));
				}else{
					//do some VanishNoPacket vanishing here
				}
			}
			if(!(p.isSneaking()) && Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots))){
				if(!(BetterBoots.VanishNoPacketCheck())){
					if(p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
						p.removePotionEffect(PotionEffectType.INVISIBILITY);
					}
				}else{
					//Do some VanishNoPacket showing here
				}	
			}
		}	
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		Entity entity = e.getEntity();
		if (entity instanceof Player && e instanceof EntityDamageByEntityEvent) {
			Player p = (Player) entity;
			ItemStack is = null;
			is = p.getInventory().getBoots();
			if(Checkers.isBoots(is)){
				if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
					if(!(BetterBoots.VanishNoPacketCheck())){
						if(p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
							p.removePotionEffect(PotionEffectType.INVISIBILITY);
						}
					}else{
						//Do some VanishNoPacket showing here
					}	
					p.setSneaking(false);
	                p.sendMessage("You become visible while attacking!");
				}	
			}
		}
	}
	
	@EventHandler
	public void NoTarget(EntityTargetEvent e) {
		Entity entity = e.getTarget();
		if (entity instanceof Player)
		{
			Player p = (Player)entity;
			ItemStack is = null;
			is = p.getInventory().getBoots();
			if(Checkers.isBoots(is)){
				if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
					e.setCancelled(true);
				}
			}	
		}
    }
	
	@EventHandler
	public void StopTarget(EntityTargetLivingEntityEvent e){
		Entity entity = e.getTarget();
		if (entity instanceof Player)
		{
			Player p = (Player)entity;
			ItemStack is = null;
			is = p.getInventory().getBoots();
			if(Checkers.isBoots(is)){
				if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
					e.setCancelled(true);
				}
			}	
		}
	}
}
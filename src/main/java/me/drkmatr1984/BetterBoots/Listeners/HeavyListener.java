package me.drkmatr1984.BetterBoots.Listeners;

import me.drkmatr1984.BetterBoots.BetterBoots;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;




public class HeavyListener implements Listener
{
	//Prevent Knockback to entities allowed to wear boots if wearing HeavyBoots
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
            ItemStack is = null;
        	if(e.getEntity() instanceof Player)
            {
            	final Player p = (Player) e.getEntity();
            	is = p.getInventory().getBoots();
            	if(Checkers.isBoots(is)){
        			if((Checkers.isHeavyBoots(is)) && (p.hasPermission(Permissions.canHasHeavyBoots))){
        				BetterBoots.plugin.getServer().getScheduler().scheduleSyncDelayedTask(BetterBoots.plugin, new Runnable() {
        					public void run() {
        						p.setVelocity(new Vector());
        					}
        				}, 1L);
        			}
                }	    
            }
            if(e.getEntity() instanceof Villager)
            {	
            	final Villager p = (Villager) e.getEntity();
            	is = p.getEquipment().getBoots();
            	if(Checkers.isBoots(is)){
        			if(Checkers.isHeavyBoots(is)){
        				BetterBoots.plugin.getServer().getScheduler().scheduleSyncDelayedTask(BetterBoots.plugin, new Runnable() {
        					public void run() {
        						p.setVelocity(new Vector()); 
        					}
        				}, 1L);
        			}
            	}
            }
            if(e.getEntity() instanceof HumanEntity)
            {	
            	final HumanEntity p = (HumanEntity) e.getEntity();
            	is = p.getEquipment().getBoots();
            	if(Checkers.isBoots(is)){
        			if(Checkers.isHeavyBoots(is)){
        				BetterBoots.plugin.getServer().getScheduler().scheduleSyncDelayedTask(BetterBoots.plugin, new Runnable() {
        					public void run() {
        						p.setVelocity(new Vector()); 
        					}
        				}, 1L);
        			}
            	}
            }
            if(e.getEntity() instanceof Monster)
            {	
            	final Monster p = (Monster) e.getEntity();
            	is = p.getEquipment().getBoots();
            	if(Checkers.isBoots(is)){
        			if(Checkers.isHeavyBoots(is)){
        				BetterBoots.plugin.getServer().getScheduler().scheduleSyncDelayedTask(BetterBoots.plugin, new Runnable() {
        					public void run() {
        						p.setVelocity(new Vector()); 
        					}
        				}, 1L);
        			}
            	}
            }	         
	}
}
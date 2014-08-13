package me.drkmatr1984.BetterBoots.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


public class Checkers implements Listener
{

	   //Checks for the existence of BetterBoots, then attempts to remove them on PvP action if NoBootsPVP: true is specified in the configs
       @EventHandler
       public void pvpBlocker(EntityDamageByEntityEvent event){
    	   if(event.getEntity() instanceof Player) {
    		   Player p = (Player) event.getEntity();
    	       
           }	   
       }
       
}       
       
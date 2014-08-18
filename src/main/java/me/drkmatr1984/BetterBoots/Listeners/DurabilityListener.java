package me.drkmatr1984.BetterBoots.Listeners;

import me.drkmatr1984.BetterBoots.ConfigAccessor;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;

public class DurabilityListener implements Listener
{
        //Durability Calculations for the FlightBoots
		@EventHandler
        public void onBootsFlight(PlayerToggleFlightEvent event){
			if(ConfigAccessor.UseDurability == true){
			Player p = event.getPlayer();
        	ItemStack is = p.getInventory().getBoots();
        	if(Checkers.isBoots(is))	
        	{	
        		if((Checkers.isFlightBoots(is)) && (p.hasPermission(Permissions.canHasFlightBoots)))
        		{	
        			if(p.isFlying()){
        				short dur = is.getDurability();
        				dur = ((short) (dur + 40));
	                    is.setDurability(dur);
        				}
	                    if(((is.getType().getMaxDurability() - 80) <= is.getDurability()) && ((is.getType().getMaxDurability() - 40) >= is.getDurability())){
	                    	   p.sendMessage(p.getDisplayName() + ChatColor.YELLOW + ", Your boots are almost used up!" + ChatColor.RESET);
	                       }
	                       if(is.getType().getMaxDurability() <= is.getDurability()){
	                    	   if((Checkers.canFlyCheck(p)) && p.isFlying()){
	                         	 p.setFlying(true);
	                         	 p.setAllowFlight(true);
	                    	     }else{
	                    	     p.getEquipment().setBoots(null);
		                         p.setFlying(false);
		                         p.setAllowFlight(false);
		                         p.sendMessage(p.getDisplayName() + ChatColor.RED + ", Your boots broke!" + ChatColor.RESET);
	                    	     } 
	                      }
        			}
        		}
        	}
        }
		
		@EventHandler
		public void onSneakToggle(PlayerToggleSneakEvent e){
			if(ConfigAccessor.UseDurability == true){
			Player p = e.getPlayer();
        	ItemStack is = p.getInventory().getBoots();
        	if(Checkers.isBoots(is))	
        	{	
        		if((Checkers.isSneakBoots(is)) && (p.hasPermission(Permissions.canHasSneakBoots)))
        		{	
        			if(p.isSneaking()){
            				short dur = is.getDurability();
            				dur = ((short) (dur + 3));
    	                    is.setDurability(dur);
    	                    if(((is.getType().getMaxDurability() - 6) <= is.getDurability()) && ((is.getType().getMaxDurability() - 3) >= is.getDurability())){
 	                    	   p.sendMessage(p.getDisplayName() + ChatColor.YELLOW + ", Your boots are almost used up!" + ChatColor.RESET);
    	                    }
    	                    if(is.getType().getMaxDurability() <= is.getDurability()){
    	                    	p.getEquipment().setBoots(null);
    	                    	p.setSneaking(false);
    	                    	p.sendMessage(p.getDisplayName() + ChatColor.RED + ", Your boots broke!" + ChatColor.RESET);
    	                    }
    	                    
        				}    
        			}
        		
        		}
        	}
		}
		
		@EventHandler
		public void onHitHeavyBoots(EntityDamageByEntityEvent e) {
			ItemStack is = null;
			if(ConfigAccessor.UseDurability == true){    
			  	if(e.getEntity() instanceof Player)
	            {
	            	final Player p = (Player) e.getEntity();
	            	is = p.getInventory().getBoots();
	            	if(Checkers.isBoots(is)){
	        			if((Checkers.isHeavyBoots(is)) && (p.hasPermission(Permissions.canHasHeavyBoots))){
	        					HeavyDurability(is);
	        					if(((is.getType().getMaxDurability() - 20) <= is.getDurability()) && ((is.getType().getMaxDurability() - 10) >= is.getDurability())){
	  	                    	   p.sendMessage(p.getDisplayName() + ChatColor.YELLOW + ", Your boots are almost used up!" + ChatColor.RESET);
	     	                    }
	     	                    if(is.getType().getMaxDurability() <= is.getDurability()){
	     	                    	p.getEquipment().setBoots(null);
	     	                    	p.sendMessage(p.getDisplayName() + ChatColor.RED + ", Your boots broke!" + ChatColor.RESET);
	     	                    }
	        			}
	        		}
	            }
	            if(e.getEntity() instanceof Villager)
	            {	
	            	final Villager p = (Villager) e.getEntity();
	            	is = p.getEquipment().getBoots();
	            	if(Checkers.isBoots(is)){
	        			if(Checkers.isHeavyBoots(is)){
	        				HeavyDurability(is);
	        				if(is.getType().getMaxDurability() <= is.getDurability()){
	     	                   	p.getEquipment().setBoots(null);
	     	                }
	        			}
	            	}
	            }
	            if(e.getEntity() instanceof HumanEntity)
	            {	
	            	final HumanEntity p = (HumanEntity) e.getEntity();
	            	is = p.getEquipment().getBoots();
	            	if(Checkers.isBoots(is)){
	        			if(Checkers.isHeavyBoots(is)){
	        				HeavyDurability(is);
	        				if(is.getType().getMaxDurability() <= is.getDurability()){
	     	                   	p.getEquipment().setBoots(null);
	     	                }
	        			}
	            	}
	            }
	            if(e.getEntity() instanceof Monster)
	            {	
	            	final Monster p = (Monster) e.getEntity();
	            	is = p.getEquipment().getBoots();
	            	if(Checkers.isBoots(is)){
	        			if(Checkers.isHeavyBoots(is)){
	        				HeavyDurability(is);
	        				if(is.getType().getMaxDurability() <= is.getDurability()){
	     	                   	p.getEquipment().setBoots(null);
	     	                }
	        			}
	            	}
	            }
			}    
		}
		
		@EventHandler
	    public void onIceBootsDurability(PlayerMoveEvent event)
		{
			if(ConfigAccessor.UseDurability == true){
			Player p = event.getPlayer();
			ItemStack is = p.getEquipment().getBoots();
			if(Checkers.isBoots(is)){
				if((Checkers.isIceBoots(is)) && (p.hasPermission(Permissions.canHasIceBoots))){
						Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
						if(block.isLiquid() && (!block.isEmpty())) {
							short dur = is.getDurability();
							dur = ((short) (dur + 1));
							is.setDurability(dur);
						}
    					if(((is.getType().getMaxDurability() - 10) <= is.getDurability()) && ((is.getType().getMaxDurability() - 9) >= is.getDurability())){
	                    	   p.sendMessage(p.getDisplayName() + ChatColor.YELLOW + ", Your boots are almost used up!" + ChatColor.RESET);
 	                    }
 	                    if(is.getType().getMaxDurability() <= is.getDurability()){
 	                    	p.getEquipment().setBoots(null);
 	                    	p.sendMessage(p.getDisplayName() + ChatColor.RED + ", Your boots broke!" + ChatColor.RESET);
 	                    }
    				}
				}
			}
		}
		
		@EventHandler
		public void onSprintToggle(PlayerToggleSprintEvent e)
		{
			if(ConfigAccessor.UseDurability == true){
			Player p = e.getPlayer();
			ItemStack is = null;
			is = p.getInventory().getBoots();
				if(Checkers.isBoots(is)){
					if(Checkers.isSpeedBoots(is) && (p.hasPermission(Permissions.canHasSpeedBoots))){
						if(p.isSprinting()){
							short dur = is.getDurability();
							dur = ((short) (dur + 5));
    	                    is.setDurability(dur);
    	                    if(((is.getType().getMaxDurability() - 10) <= is.getDurability()) && ((is.getType().getMaxDurability() - 5) >= is.getDurability())){
 	                    	   p.sendMessage(p.getDisplayName() + ChatColor.YELLOW + ", Your boots are almost used up!" + ChatColor.RESET);
    	                    }
    	                    if(is.getType().getMaxDurability() <= is.getDurability()){
    	                    	p.getEquipment().setBoots(null);
    	                    	p.setSprinting(false);
    	                    	p.setWalkSpeed(0.2f);
    	                    	p.sendMessage(p.getDisplayName() + ChatColor.RED + ", Your boots broke!" + ChatColor.RESET);
    	                    }
    	                    
        				}
					}
				}
			}
		}
		
		public void HeavyDurability(ItemStack is)
        {
			short dur = is.getDurability();
			dur = ((short) (dur + 5));
            is.setDurability(dur);    
        }
}
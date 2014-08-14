package me.drkmatr1984.BetterBoots.Listeners;

import java.util.List;

import me.drkmatr1984.BetterBoots.Boots;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;


public class Checkers implements Listener
{

	   //Checks for the existence of BetterBoots, then attempts to remove them on PvP action if NoBootsPVP: true is specified in the configs
       @EventHandler
       public void pvpChecker(EntityDamageByEntityEvent e){
    	   if (e.getEntity() instanceof Player && e instanceof EntityDamageByEntityEvent && ((EntityDamageByEntityEvent)e).getDamager() instanceof Player) {
    		  // pvp damage occurred
    	   }
       }
       
       //Checks if player already has permission to fly
       public static boolean canFlyCheck(Player player){
    	   if((player.hasPermission("essentials.fly")) || (player.getGameMode() == GameMode.CREATIVE)){
    		   return true;
    	   }else
    	   return false;
       }
       
       //Checks if itemstack is an instance of BetterBoots
       public static boolean isBoots(ItemStack is){
    	   if(isFlightBoots(is)){
    		   return true;
    	   }
    	   if(isSpeedBoots(is)){
    		   return true;
    	   }
    	   if(isSneakBoots(is)){
    		   return true;
    	   }
   	   return false;
   	   }
       
       //checks if Recipe is an instance of FlightBootsRecipe
   	   public static boolean isFlightBootsRecipe(ItemStack is){
    	   if ((is != null) && (is.getType() != Material.AIR)){
    		   List<Recipe> recipe = Bukkit.getRecipesFor(is);
    		   if (recipe instanceof ShapedRecipe){
    			   Recipe srecipe = (ShapedRecipe) recipe;
    			   Recipe srecipe2 = (Recipe) Boots.FlightBootsRecipe;
    			   return me.drkmatr1984.BetterBoots.Util.RecipeUtil.areEqual(srecipe, srecipe2);
    		   }
    	   }
    	   return false;
      	}
       
   	   //checks if Recipe is an instance of SpeedBootsRecipe
   	   public static boolean isSpeedBootsRecipe(ItemStack is){
    	   if ((is != null) && (is.getType() != Material.AIR)){
    		   List<Recipe> recipe = Bukkit.getRecipesFor(is);
    		   if (recipe instanceof ShapedRecipe){
    			   Recipe srecipe = (ShapedRecipe) recipe;
    			   Recipe srecipe2 = (Recipe) Boots.SpeedBootsRecipe;
    			   return me.drkmatr1984.BetterBoots.Util.RecipeUtil.areEqual(srecipe, srecipe2);
    		   }
    	   }
    	   return false;
      	}
       
   	   //checks if Recipe is an instance of SneakBootsRecipe
   	   public static boolean isSneakBootsRecipe(ItemStack is){
    	   if ((is != null) && (is.getType() != Material.AIR)){
    		   List<Recipe> recipe = Bukkit.getRecipesFor(is);
    		   if (recipe instanceof ShapedRecipe){
    			   Recipe srecipe = (ShapedRecipe) recipe;
    			   Recipe srecipe2 = (Recipe) Boots.SneakBootsRecipe;
    			   return me.drkmatr1984.BetterBoots.Util.RecipeUtil.areEqual(srecipe, srecipe2);
    		   }
    	   }
    	   return false;
      	}
   	   
   	   //Checks if boots are FlightBoots
   	   public static boolean isFlightBoots(ItemStack is){
    	   if ((is != null) && (is.getType() != Material.AIR)){
    		   if(is.getType() != Material.AIR){
    			    if(is.hasItemMeta()){
    			    	if(is.getItemMeta().hasDisplayName()){
    			    		if(is.getItemMeta().getLore() != null){
    			    			if((is.getItemMeta().getLore().equals(Boots.getFlightBoots().getItemMeta().getLore())) && (is.getItemMeta().getDisplayName().equals(Boots.getFlightBoots().getItemMeta().getDisplayName()))){
        			    			return true;
    			    			}
    			    		}
    			    	}
    			    }
    		   }
    	   }   
    	   return false;
   	   }
    
   	   //Checks if boots are SpeedBoots
       public static boolean isSpeedBoots(ItemStack is){
    	   if ((is != null) && (is.getType() != Material.AIR)){
    		   if(is.getType() != Material.AIR){
    			    if(is.hasItemMeta()){
    			    	if(is.getItemMeta().hasDisplayName()){
    			    		if(is.getItemMeta().getLore() != null){
    			    			if((is.getItemMeta().getLore().equals(Boots.getSpeedBoots().getItemMeta().getLore())) && (is.getItemMeta().getDisplayName().equals(Boots.getSpeedBoots().getItemMeta().getDisplayName()))){
        			    			return true;
    			    			}
    			    		}
    			    	}
    			    }
    		   }
    	   }   
    	   return false;
       }
       
       //Checks if boots are SneakBoots
       public static boolean isSneakBoots(ItemStack is){
    	   if ((is != null) && (is.getType() != Material.AIR)){
    		   if(is.getType() != Material.AIR){
    			    if(is.hasItemMeta()){
    			    	if(is.getItemMeta().hasDisplayName()){
    			    		if(is.getItemMeta().getLore() != null){
    			    			if((is.getItemMeta().getLore().equals(Boots.getSneakBoots().getItemMeta().getLore())) && (is.getItemMeta().getDisplayName().equals(Boots.getSneakBoots().getItemMeta().getDisplayName()))){
        			    			return true;
    			    			}
    			    		}
    			    	}
    			    }
    		   }
    	   }   
    	   return false;
       }
}       
       
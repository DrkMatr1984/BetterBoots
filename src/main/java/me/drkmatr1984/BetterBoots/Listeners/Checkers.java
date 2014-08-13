package me.drkmatr1984.BetterBoots.Listeners;

import java.util.List;

import me.drkmatr1984.BetterBoots.Boots;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
       public void pvpBlocker(EntityDamageByEntityEvent event){
    	   if(event.getEntity() instanceof Player) {
    		   Player p = (Player) event.getEntity();
    	
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
   	   return false;
   	   }
       
       //checks if itemstack is an instance of FlightBoots
       @SuppressWarnings("deprecation") 
   	   public static boolean isFlightBoots(ItemStack is){
    	   if ((is != null) && (is.getTypeId() != 0)){
    		   List<Recipe> recipe = Bukkit.getRecipesFor(is);
    		   if (recipe instanceof ShapedRecipe){
    			   Recipe srecipe = (ShapedRecipe) recipe;
    			   Recipe srecipe2 = (Recipe) Boots.FlightBootsRecipe;
    			   return me.drkmatr1984.BetterBoots.Util.RecipeUtil.areEqual(srecipe, srecipe2);
    		   }
    	   }
    	   return false;
      	}
       
       @SuppressWarnings("deprecation") 
   	   public static boolean isSpeedBoots(ItemStack is){
    	   if ((is != null) && (is.getTypeId() != 0)){
    		   List<Recipe> recipe = Bukkit.getRecipesFor(is);
    		   if (recipe instanceof ShapedRecipe){
    			   Recipe srecipe = (ShapedRecipe) recipe;
    			   Recipe srecipe2 = (Recipe) Boots.SpeedBootsRecipe;
    			   return me.drkmatr1984.BetterBoots.Util.RecipeUtil.areEqual(srecipe, srecipe2);
    		   }
    	   }
    	   return false;
      	}
}       
       
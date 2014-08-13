package me.drkmatr1984.BetterBoots;
import java.util.ArrayList;

import net.minecraft.server.v1_7_R1.NBTTagCompound;
import net.minecraft.server.v1_7_R1.NBTTagList;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Boots{

	//Initialize FlightBoots
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void FlightBoots()
	{
		Double Speed = BetterBoots.c.getDouble("FLIGHTSPEED")*10;
		String speedLore = Speed.toString();
		ItemStack db = new ItemStack((Material.DIAMOND_BOOTS));
		db = addGlow(db);
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§6FlightBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FPop these babies on and Fly like Hermes!");
		lore.add(1,"§FFlight Speed : " + ("§F" + speedLore));
		meta.setLore(lore);
		db.setItemMeta(meta);
		ShapedRecipe recipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		recipe.shape(new String[] { "ACA", "CBC", "ACA" });
		recipe.setIngredient('A', Material.FEATHER);
		recipe.setIngredient('B', Material.DIAMOND_BOOTS);
		recipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(recipe);
	}
	
	//Initialize SpeedBoots
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void SpeedBoots()
	{
		Double Speed = BetterBoots.c.getDouble("SPRINTSPEED")*10;
		String speedLore = Speed.toString();
		ItemStack db = new ItemStack((Material.GOLD_BOOTS));
		db = addGlow(db);
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§6SpeedBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FRun to the Hills!");
		lore.add(1,"§FSprint Speed : " + ("§F" + speedLore));
		meta.setLore(lore);
		db.setItemMeta(meta);
		ShapedRecipe recipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		recipe.shape(new String[] { "ACA", "AAB", "ACA" });
		recipe.setIngredient('A', Material.FEATHER);
		recipe.setIngredient('B', Material.GOLD_BOOTS);
		recipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(recipe);
	}
			
	public static ItemStack addGlow(ItemStack item)
	{
	    net.minecraft.server.v1_7_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
	    NBTTagCompound tag = null;
	    if (!nmsStack.hasTag())
	    {
	    	tag = new NBTTagCompound();
	        nmsStack.setTag(tag);
	    }
	    if (tag == null)
	    {
	    	tag = nmsStack.getTag();
	    }
	    NBTTagList ench = new NBTTagList();
	    tag.set("ench", ench);
	    nmsStack.setTag(tag);
	    item = CraftItemStack.asBukkitCopy(nmsStack);
	    return item;
	}
}
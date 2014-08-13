package me.drkmatr1984.BetterBoots;
import java.util.ArrayList;

import me.drkmatr1984.BetterBoots.Util.InventoryUtils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Boots {
	
	public static ShapedRecipe FlightBootsRecipe = null;
	public static ShapedRecipe SpeedBootsRecipe = null;

	//Initialize FlightBoots
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void FlightBoots()
	{
		Double Speed = ConfigAccessor.FlightSpeed;
		String speedLore = Speed.toString();
		ItemStack db = new ItemStack((Material.DIAMOND_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§6FlightBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FPop these babies on and Fly like Hermes!");
		lore.add(1,"§FFlight Speed : " + ("§F" + speedLore));
		meta.setLore(lore);
		db.setItemMeta(meta);
		InventoryUtils.addGlow(db);
		FlightBootsRecipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		FlightBootsRecipe.shape(new String[] { "ACA", "CBC", "ACA" });
		FlightBootsRecipe.setIngredient('A', Material.FEATHER);
		FlightBootsRecipe.setIngredient('B', Material.DIAMOND_BOOTS);
		FlightBootsRecipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(FlightBootsRecipe);
	}
	
	//Initialize SpeedBoots
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void SpeedBoots()
	{
		Double Speed = ConfigAccessor.SprintSpeed;
		String speedLore = Speed.toString();
		ItemStack db = new ItemStack((Material.GOLD_BOOTS));
		InventoryUtils.addGlow(db);
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§6SpeedBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FRun to the Hills!");
		lore.add(1,"§FSprint Speed : " + ("§F" + speedLore));
		meta.setLore(lore);
		db.setItemMeta(meta);
		InventoryUtils.addGlow(db);
		SpeedBootsRecipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		SpeedBootsRecipe.shape(new String[] { "ACA", "AAB", "ACA" });
		SpeedBootsRecipe.setIngredient('A', Material.FEATHER);
		SpeedBootsRecipe.setIngredient('B', Material.GOLD_BOOTS);
		SpeedBootsRecipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(SpeedBootsRecipe);
	}	
}
package me.drkmatr1984.BetterBoots;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Boots {
	
	public static ShapedRecipe FlightBootsRecipe = null;
	public static ShapedRecipe SpeedBootsRecipe = null;
	public static ShapedRecipe SneakBootsRecipe = null;
	public static ShapedRecipe IceBootsRecipe = null;
	public static ShapedRecipe HeavyBootsRecipe = null;

	//Initialize FlightBoots Recipe
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void FlightBoots()
	{
		Double Speed = ConfigAccessor.FlightSpeed;
		Speed = Speed * 10;
		String speedLore = Speed.toString();
		ItemStack db = new ItemStack((Material.DIAMOND_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§6FlightBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FPop these babies on and Fly like Hermes!");
		lore.add(1,"§FFlight Speed : " + ("§F" + speedLore));
		meta.setLore(lore);
		db.setItemMeta(meta);
		FlightBootsRecipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		FlightBootsRecipe.shape(new String[] { "ACA", "CBC", "ACA" });
		FlightBootsRecipe.setIngredient('A', Material.FEATHER);
		FlightBootsRecipe.setIngredient('B', Material.DIAMOND_BOOTS);
		FlightBootsRecipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(FlightBootsRecipe);
	}
	
	//Initialize SpeedBoots Recipe
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void SpeedBoots()
	{
		Double Speed = ConfigAccessor.SprintSpeed;
		Speed = Speed * 10;
		String speedLore = Speed.toString();
		ItemStack db = new ItemStack((Material.GOLD_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§ASpeedBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FRun to the Hills!");
		lore.add(1,"§FSprint Speed : " + ("§F" + speedLore));
		meta.setLore(lore);
		db.setItemMeta(meta);
		SpeedBootsRecipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		SpeedBootsRecipe.shape(new String[] { "ACA", "AAB", "ACA" });
		SpeedBootsRecipe.setIngredient('A', Material.FEATHER);
		SpeedBootsRecipe.setIngredient('B', Material.GOLD_BOOTS);
		SpeedBootsRecipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(SpeedBootsRecipe);
	}	
	
	//Initialize SneakBoots Recipe
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void SneakBoots()
	{
		ItemStack db = new ItemStack((Material.LEATHER_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§7SneakBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FFrom the §7Shadows§F...");
		lore.add(1,"§FHold SHIFT(sneak) to become invisible");
		lore.add(2,"§FWhile wearing these boots.");
		meta.setLore(lore);
		db.setItemMeta(meta);
		SneakBootsRecipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		SneakBootsRecipe.shape(new String[] { "ACA", "ABA", "ACA" });
		SneakBootsRecipe.setIngredient('A', Material.NETHER_WARTS);
		SneakBootsRecipe.setIngredient('B', Material.LEATHER_BOOTS);
		SneakBootsRecipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(SneakBootsRecipe);
	}
	
	//Initialize IceBoots Recipe
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void IceBoots()
	{
		ItemStack db = new ItemStack((Material.CHAINMAIL_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§9IceBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FWho's got cold feet now?");
		lore.add(1,"§FThese boots allow you to walk on water by changing the");
		lore.add(2,"§FThe water beneath your feet to §9ice§F.");
		meta.setLore(lore);
		db.setItemMeta(meta);
		IceBootsRecipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		IceBootsRecipe.shape(new String[] { "ACA", "ABA", "ACA" });
		IceBootsRecipe.setIngredient('A', Material.SNOW_BALL);
		IceBootsRecipe.setIngredient('B', Material.CHAINMAIL_BOOTS);
		IceBootsRecipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(IceBootsRecipe);
	}
	
	//Initialize HeavyBoots Recipe
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void HeavyBoots()
	{
		ItemStack db = new ItemStack((Material.IRON_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§8HeavyBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FJust §Otry§R §Fto knock me over in these...");
		lore.add(1,"§FThese boots allow you to ignore");
		lore.add(2,"§8Knockback §Feffects.");
		meta.setLore(lore);
		db.setItemMeta(meta);
		HeavyBootsRecipe = new ShapedRecipe(new org.bukkit.inventory.ItemStack(db));
		HeavyBootsRecipe.shape(new String[] { "ACA", "ABA", "ACA" });
		HeavyBootsRecipe.setIngredient('A', Material.IRON_INGOT);
		HeavyBootsRecipe.setIngredient('B', Material.IRON_BOOTS);
		HeavyBootsRecipe.setIngredient('C', Material.ENDER_PEARL);
		BetterBoots.plugin.getServer().addRecipe(HeavyBootsRecipe);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ItemStack getFlightBoots()
	{
		Double Speed = ConfigAccessor.FlightSpeed;
		Speed = Speed * 10;
		String speedLore = Speed.toString();
		ItemStack db = new ItemStack((Material.DIAMOND_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§6FlightBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FPop these babies on and Fly like Hermes!");
		lore.add(1,"§FFlight Speed : " + ("§F" + speedLore));
		meta.setLore(lore);
		db.setItemMeta(meta);
		return db;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ItemStack getSpeedBoots()
	{
		Double Speed = ConfigAccessor.SprintSpeed;
		Speed = Speed * 10;
		String speedLore = Speed.toString();
		ItemStack db = new ItemStack((Material.GOLD_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§6SpeedBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FRun to the Hills!");
		lore.add(1,"§FSprint Speed : " + ("§F" + speedLore));
		meta.setLore(lore);
		db.setItemMeta(meta);
		return db;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ItemStack getSneakBoots()
	{
		ItemStack db = new ItemStack((Material.LEATHER_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§6SneakBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FFrom the Shadows...");
		lore.add(1,"§FHold shift(sneak) to become invisible while wearing these boots.");
		meta.setLore(lore);
		db.setItemMeta(meta);
		return db;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ItemStack getIceBoots()
	{
		ItemStack db = new ItemStack((Material.CHAINMAIL_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§9IceBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FWho's got cold feet now?");
		lore.add(1,"§FThese boots allow you to walk on water by changing the");
		lore.add(2,"§FThe water beneath your feet to §9ice§F.");
		meta.setLore(lore);
		db.setItemMeta(meta);
		return db;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ItemStack getHeavyBoots()
	{
		ItemStack db = new ItemStack((Material.IRON_BOOTS));
		ItemMeta meta = db.getItemMeta();
		meta.setDisplayName("§8HeavyBoots");
		ArrayList lore = new ArrayList();
		lore.add(0,"§FJust §Otry§R §Fto knock me over in these...");
		lore.add(1,"§FThese boots allow you to ignore");
		lore.add(2,"§8Knockback §Feffects.");
		meta.setLore(lore);
		db.setItemMeta(meta);
		return db;
	}
	
}
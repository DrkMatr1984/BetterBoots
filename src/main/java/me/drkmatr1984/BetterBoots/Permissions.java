package me.drkmatr1984.BetterBoots;

import org.bukkit.permissions.Permission;

public class Permissions 
{
	public static final Permission canHasFlightBoots = new Permission(Strings.FLIGHT_BOOTS);
	public static final Permission canHasSpeedBoots = new Permission(Strings.SPEED_BOOTS);
	public static final Permission canHasSneakBoots = new Permission(Strings.SNEAK_BOOTS);
	public static final Permission canHasHeavyBoots = new Permission(Strings.HEAVY_BOOTS);
	public static final Permission canHasIceBoots = new Permission(Strings.ICE_BOOTS);
	public static final Permission canCraftFlightBoots = new Permission(Strings.FLIGHT_BOOTS_CRAFT);
	public static final Permission canCraftSpeedBoots = new Permission(Strings.SPEED_BOOTS_CRAFT);
	public static final Permission canCraftSneakBoots = new Permission(Strings.SNEAK_BOOTS_CRAFT);
	public static final Permission canCraftHeavyBoots = new Permission(Strings.HEAVY_BOOTS_CRAFT);
	public static final Permission canCraftIceBoots = new Permission(Strings.ICE_BOOTS_CRAFT);

	public class Strings {
		public static final String FLIGHT_BOOTS = "BetterBoots.flightboots.use";
		public static final String SPEED_BOOTS = "BetterBoots.speedboots.use";
		public static final String SNEAK_BOOTS = "BetterBoots.sneakboots.use";
		public static final String HEAVY_BOOTS = "BetterBoots.heavyboots.use";
		public static final String ICE_BOOTS = "BetterBoots.iceboots.use";
		public static final String FLIGHT_BOOTS_CRAFT = "BetterBoots.flightboots.craft";
		public static final String SPEED_BOOTS_CRAFT = "BetterBoots.speedboots.craft";
		public static final String SNEAK_BOOTS_CRAFT = "BetterBoots.sneakboots.craft";
		public static final String HEAVY_BOOTS_CRAFT = "BetterBoots.heavyboots.craft";
		public static final String ICE_BOOTS_CRAFT = "BetterBoots.iceboots.craft";
	}
}
package me.drkmatr1984.BetterBoots.Listeners;

import me.drkmatr1984.BetterBoots.BetterBoots;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class IceListener implements Listener
{
	//Allows player to walk on water by Turning water to ice beneath their feet
	@EventHandler
    public void onWaterWalk(PlayerMoveEvent event)
	{
		Player p = event.getPlayer();
		ItemStack is = p.getEquipment().getBoots();
		if(Checkers.isBoots(is)){
			if((Checkers.isIceBoots(is)) && (p.hasPermission(Permissions.canHasIceBoots))){
				final Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
				BlockFace face = yawToFace(p.getLocation().getYaw());
				final Block nextBlock = p.getLocation().getBlock().getRelative(face);
				if(block.isLiquid() && (!block.isEmpty())) {
					BetterBoots.plugin.getServer().getScheduler().scheduleSyncDelayedTask(BetterBoots.plugin, new Runnable() {
    					public void run() {
    						block.setType(Material.ICE);
    					}
    				}, 1L);	
				}
				if(nextBlock.isLiquid() && (!nextBlock.isEmpty())) {
					BetterBoots.plugin.getServer().getScheduler().scheduleSyncDelayedTask(BetterBoots.plugin, new Runnable() {
    					public void run() {
    						block.setType(Material.ICE);
    					}
    				}, 1L);
				}
			}
		}
		
	}
	
	//Thanks to BergerKiller for this tidbit of code
	
	private static final BlockFace[] axis = { BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };
    private static final BlockFace[] radial = { BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH, BlockFace.SOUTH_WEST, BlockFace.WEST, BlockFace.NORTH_WEST };
   
    /**
    * Gets the horizontal Block Face from a given yaw angle<br>
    * This includes the NORTH_WEST faces
    *
    * @param yaw angle
    * @return The Block Face of the angle
    */
    public static BlockFace yawToFace(float yaw) {
        return yawToFace(yaw, true);
    }
 
    /**
    * Gets the horizontal Block Face from a given yaw angle
    *
    * @param yaw angle
    * @param useSubCardinalDirections setting, True to allow NORTH_WEST to be returned
    * @return The Block Face of the angle
    */
    public static BlockFace yawToFace(float yaw, boolean useSubCardinalDirections) {
        if (useSubCardinalDirections) {
            return radial[Math.round(yaw / 45f) & 0x7];
        } else {
            return axis[Math.round(yaw / 90f) & 0x3];
        }
    }    
}	
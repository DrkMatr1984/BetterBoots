package me.drkmatr1984.BetterBoots.Listeners;

import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;


public class SprintListener implements Listener
{

	@EventHandler
	public void onPlayerToggleSprint(PlayerToggleSprintEvent e) {
		Player p = e.getPlayer();
		if (p.isSprinting()) {
			if((p.getEquipment().getBoots() != null) && (p.getEquipment().getBoots().getType().equals(Material.GOLD_BOOTS)) && (p.getEquipment().getBoots().getItemMeta().getDisplayName().contains("SpeedBoots")) && (p.getEquipment().getBoots().hasItemMeta()) && (!(p.getEquipment().getBoots().getItemMeta().getLore().isEmpty()) && (p.hasPermission(Permissions.canHasSpeedBoots)))){
				String i = me.drkmatr1984.BetterBoots.BetterBoots.c.getString("SPRINTSPEED");
				float speed = Float.parseFloat(i);
				p.setSprinting(false);
				p.setWalkSpeed(speed);
			}	
				p.sendMessage("You have started to sprint.");
		}
		else {
			p.setSprinting(false);
			p.setWalkSpeed((float)0.1);
			p.sendMessage("You are no longer sprinting.");
		}
	}
	
	/*public void setSpeed(LivingEntity entity, float speed)
	{
	EntityLiving ent = ((CraftLivingEntity) entity).getHandle();
	Field f;
	try
	{
	f = net.minecraft.server.v1_7_R1.EntityLiving.class.getDeclaredField("bI");
	f.setAccessible(true);
	f.setFloat(ent, speed);
	} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
	{
	e.printStackTrace();
	}
	}*/
}
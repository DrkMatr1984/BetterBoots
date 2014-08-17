package me.drkmatr1984.BetterBoots.Listeners;

import me.drkmatr1984.BetterBoots.BetterBoots;
import me.drkmatr1984.BetterBoots.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.kitteh.vanish.staticaccess.VanishNoPacket;
import org.kitteh.vanish.staticaccess.VanishNotLoadedException;


@SuppressWarnings("deprecation")
public class SneakListener implements Listener
{
	//Makes player invisible/visible on SHIFT Sneak toggles
	@EventHandler
	public void onPlayerSneak(PlayerMoveEvent e) throws VanishNotLoadedException{
		Player p = e.getPlayer();
		ItemStack is = null;
		is = p.getInventory().getBoots();
		if(Checkers.isBoots(is)){
			if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
				if(!(BetterBoots.VanishNoPacketCheck())){
					p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false));
					p.sendMessage(ChatColor.WHITE + "You slip into the " + ChatColor.GRAY + "shadows" + ChatColor.WHITE + "..." + ChatColor.RESET);
				}else{
					if(!(VanishNoPacket.getManager().isVanished(p))){
						VanishNoPacket.getManager().toggleVanishQuiet(p, false);
						p.sendMessage(ChatColor.WHITE + "You slip into the " + ChatColor.GRAY + "shadows" + ChatColor.WHITE + "..." + ChatColor.RESET);
					}
				}
			}
			if(!(p.isSneaking()) && Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots))){
				if(!(BetterBoots.VanishNoPacketCheck())){
					if(p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
						p.removePotionEffect(PotionEffectType.INVISIBILITY);
						p.sendMessage(ChatColor.WHITE + "You emerge from the " + ChatColor.GRAY + "shadows" + ChatColor.WHITE + "!" + ChatColor.RESET);
					}
				}else{
					if(VanishNoPacket.getManager().isVanished(p)){
					VanishNoPacket.getManager().toggleVanishQuiet(p, false);
					p.sendMessage(ChatColor.WHITE + "You emerge from the " + ChatColor.GRAY + "shadows" + ChatColor.WHITE + "!" + ChatColor.RESET);
					}
				}	
			}
		}	
	}
	
	//Makes Player Visible if Attacked/Attacking
	@EventHandler
	public void onDamage(EntityDamageEvent e) throws VanishNotLoadedException{
		Entity entity = e.getEntity();
		if (entity instanceof Player) {
			Player p = (Player) entity;
			ItemStack is = null;
			is = p.getInventory().getBoots();
			if(Checkers.isBoots(is)){
				if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
					if(!(BetterBoots.VanishNoPacketCheck())){
						if(p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
							p.removePotionEffect(PotionEffectType.INVISIBILITY);
							p.sendMessage(ChatColor.WHITE + "You become" + ChatColor.AQUA + " visible" + ChatColor.WHITE + " while being attacked!" + ChatColor.RESET);
							p.sendMessage(ChatColor.WHITE + "Press and hold " + ChatColor.RED + ChatColor.UNDERLINE + "SHIFT " + ChatColor.RESET + ChatColor.WHITE + "again to re-engage invisibility." + ChatColor.RESET);
						}
					}else{
						if(VanishNoPacket.getManager().isVanished(p)){
							VanishNoPacket.getManager().toggleVanishQuiet(p, false);
							p.sendMessage(ChatColor.WHITE + "You become" + ChatColor.AQUA + " visible" + ChatColor.WHITE + " while being attacked!" + ChatColor.RESET);
							p.sendMessage(ChatColor.WHITE + "Press and hold " + ChatColor.RED + ChatColor.UNDERLINE + "SHIFT " + ChatColor.RESET + ChatColor.WHITE + "again to re-engage invisibility." + ChatColor.RESET);
						}
					}	
					p.setSneaking(false);
				}	
			}
		}
		if (e instanceof EntityDamageByEntityEvent){
			if(((EntityDamageByEntityEvent) e).getDamager() instanceof Player){
				Player p = (Player) ((EntityDamageByEntityEvent) e).getDamager();
				ItemStack is = null;
				is = p.getInventory().getBoots();
				if(Checkers.isBoots(is)){
					if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
						if(!(BetterBoots.VanishNoPacketCheck())){
							if(p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
								p.removePotionEffect(PotionEffectType.INVISIBILITY);
								p.sendMessage(ChatColor.WHITE + "You become" + ChatColor.AQUA +  " visible" + ChatColor.WHITE + " while attacking!" + ChatColor.RESET);
								p.sendMessage(ChatColor.WHITE + "Press and hold " + ChatColor.RED + ChatColor.UNDERLINE + "SHIFT " + ChatColor.RESET + ChatColor.WHITE + "again to re-engage invisibility." + ChatColor.RESET);
							}
						}else{
							if(VanishNoPacket.getManager().isVanished(p)){
								VanishNoPacket.getManager().toggleVanishQuiet(p, false);
								p.sendMessage(ChatColor.WHITE + "You become" + ChatColor.AQUA +  " visible" + ChatColor.WHITE + " while attacking!" + ChatColor.RESET);
								p.sendMessage(ChatColor.WHITE + "Press and hold " + ChatColor.RED + ChatColor.UNDERLINE + "SHIFT " + ChatColor.RESET + ChatColor.WHITE + "again to re-engage invisibility." + ChatColor.RESET);
							}
						}	
						p.setSneaking(false);
					}	
				}
			}
		}
	}
	
	//These two block entity targeting while invisible
	@EventHandler
	public void NoTarget(EntityTargetEvent e) {
		Entity entity = e.getTarget();
		if (entity instanceof Player)
		{
			Player p = (Player)entity;
			ItemStack is = null;
			is = p.getInventory().getBoots();
			if(Checkers.isBoots(is)){
				if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
					e.setCancelled(true);
				}
			}	
		}
    }
	
	@EventHandler
	public void StopTarget(EntityTargetLivingEntityEvent e){
		Entity entity = e.getTarget();
		if (entity instanceof Player)
		{
			Player p = (Player)entity;
			ItemStack is = null;
			is = p.getInventory().getBoots();
			if(Checkers.isBoots(is)){
				if(Checkers.isSneakBoots(is) && (p.hasPermission(Permissions.canHasSneakBoots)) && (p.isSneaking())){
					e.setCancelled(true);
				}
			}	
		}
	}
}
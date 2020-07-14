package me.chickenstyle.backpack.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.chickenstyle.backpack.Main;
import me.chickenstyle.backpack.Utils;
import me.chickenstyle.backpack.holders.ArrowHolder;
import me.chickenstyle.backpack.holders.BagHolder;
import me.chickenstyle.backpack.holders.PotionHolder;
import me.chickenstyle.backpack.holders.TalismanHolder;

public class InventoryClick implements Listener{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getInventory() == null) return;
		if (e.getClick().equals(ClickType.NUMBER_KEY)) { e.setCancelled(true); return;}
		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)) return;
		Player player = (Player) e.getWhoClicked();	
		if (e.getInventory().getHolder() instanceof ArrowHolder) {
			if (!e.getCurrentItem().equals(Utils.getArrowItemStack())) {
				if (!e.getCurrentItem().equals(Utils.getGrayGlass())) {
					if (!e.getCurrentItem().getType().equals(Material.ARROW)) {
						player.sendMessage(Utils.Color(Main.getInstance().getConfig().getString("messages.disablePlace")));
						e.setCancelled(true);
					}
				} else {
					e.setCancelled(true);
				}
			} else {
				e.setCancelled(true);
				player.closeInventory();
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"sudo " + player.getName() + " " +Main.getInstance().getConfig().getString("arrowCommand"));
			}
		}
		
		if (e.getInventory().getHolder() instanceof PotionHolder) {
			if (!e.getCurrentItem().getType().equals(Material.POTION)) {
				if (!e.getCurrentItem().equals(Utils.getGrayGlass()) &&
						!e.getCurrentItem().equals(Utils.getArrowItemStack())) {
						player.sendMessage(Utils.Color(Main.getInstance().getConfig().getString("messages.disablePlace")));
					} else if (e.getCurrentItem().equals(Utils.getArrowItemStack())) {
						e.setCancelled(true);
						player.closeInventory();
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"sudo " + player.getName() + " " +Main.getInstance().getConfig().getString("arrowCommand"));
					}
					e.setCancelled(true);
			} 
		}
		
		if (e.getInventory().getHolder() instanceof TalismanHolder) {
			if (!e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
				if (!e.getCurrentItem().equals(Utils.getGrayGlass()) &&
						!e.getCurrentItem().equals(Utils.getArrowItemStack())) {
						player.sendMessage(Utils.Color(Main.getInstance().getConfig().getString("messages.disablePlace")));
					} else if (e.getCurrentItem().equals(Utils.getArrowItemStack())) {
						e.setCancelled(true);
						player.closeInventory();
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"sudo " + player.getName() + " " +Main.getInstance().getConfig().getString("arrowCommand"));
					}
					e.setCancelled(true);
			}
		}
		
		if (e.getInventory().getHolder() instanceof BagHolder) {
			if (e.getCurrentItem().equals(Utils.getGrayGlass())) {
				e.setCancelled(true);
			}
			
			if (e.getCurrentItem().equals(Utils.getArrowItemStack())) {
				e.setCancelled(true);
				player.closeInventory();
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
				"sudo " + player.getName() + " " +Main.getInstance().getConfig().getString("arrowCommand"));
			}
		}
	}
}

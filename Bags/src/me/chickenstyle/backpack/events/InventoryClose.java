package me.chickenstyle.backpack.events;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.chickenstyle.backpack.BagType;
import me.chickenstyle.backpack.Utils;
import me.chickenstyle.backpack.configs.BagsData;
import me.chickenstyle.backpack.holders.ArrowHolder;
import me.chickenstyle.backpack.holders.BagHolder;
import me.chickenstyle.backpack.holders.PotionHolder;
import me.chickenstyle.backpack.holders.TalismanHolder;

public class InventoryClose implements Listener{
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		if (e.getInventory().getHolder() instanceof ArrowHolder) {
			BagsData.addData((Player)e.getPlayer(), BagType.Arrows,
					getValidItems(e.getView().getTopInventory(), new ItemStack(Material.ARROW)));
		}
		
		if (e.getInventory().getHolder() instanceof PotionHolder) {
			BagsData.addData((Player)e.getPlayer(), BagType.Potions,
					getValidItems(e.getView().getTopInventory(), new ItemStack(Material.POTION)));
		}
		
		if (e.getInventory().getHolder() instanceof TalismanHolder) {
			BagsData.addData((Player)e.getPlayer(), BagType.Talismans,
					getValidItems(e.getView().getTopInventory(), new ItemStack(Material.PLAYER_HEAD)));
		}
		
		if (e.getInventory().getHolder() instanceof BagHolder) {
			BagsData.addData((Player)e.getPlayer(), BagType.Bag,
					getItems(e.getInventory()));
		}
	}
	
	
	public ArrayList<ItemStack> getItems(Inventory inv){
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		for (int i = 0;i <27;i++) {
			if (inv.getContents()[i] != null && inv.getContents()[i].getType() !=Material.AIR) {
				items.add(inv.getContents()[i]);
			} else {
				items.add(new ItemStack(Material.AIR));
			}
		}
		return items;
	}
	
	
	public ArrayList<ItemStack> getValidItems(Inventory inv,ItemStack whitelist) {
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		for (ItemStack item:inv.getContents()) {
			if (item != null && item.getType() != Material.AIR) {
				if (item.getType().equals(whitelist.getType())) {
						if (item.getItemMeta().hasDisplayName()) {
							if (!item.getItemMeta().getDisplayName().equals(Utils.Color("&7&lGo Back!"))) {
								items.add(item);
							} 
						} else {
							items.add(item);
						}
					}
			} else {
				items.add(new ItemStack(Material.AIR));
			}
			
			
		}
		return items;
	}
}

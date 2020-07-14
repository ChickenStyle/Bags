package me.chickenstyle.backpack;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {
	public static String Color(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static ItemStack getArrowItemStack() {
		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta meta = arrow.getItemMeta();
		meta.setDisplayName(Color("&aGo Back!"));
		arrow.setItemMeta(meta);
		return arrow;
	}
	
	public static ItemStack getGrayGlass() {
		ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta meta = glass.getItemMeta();
		meta.setDisplayName(" ");
		glass.setItemMeta(meta);
		return glass;
	}
	
	public static Inventory createBigInventory(InventoryHolder holder,String title,ArrayList<ItemStack> items) {
		Inventory gui = Bukkit.createInventory(holder, 36, Color(title));
		for (int i = 27;i < 36;i++) {
			if (i == 31) {
				gui.setItem(i, getArrowItemStack());
			} else {
				gui.setItem(i, getGrayGlass());
			}
		}
		
		for (int i = 0; i < 27;i++) {
			if (!items.isEmpty()) {
				gui.setItem(i, items.get(i));
			}
		}
		return gui;
	}
	
	public static Inventory createInventory(InventoryHolder holder,String title,ArrayList<ItemStack> items) {
		Inventory gui = Bukkit.createInventory(holder, 18, Color(title));
		for (int i = 9;i < 18;i++) {
			if (i == 13) {
				gui.setItem(i, getArrowItemStack());
			} else {
				gui.setItem(i, getGrayGlass());
			}
		}
		
		for (int i = 0; i < 9;i++) {
			if (!items.isEmpty()) {
				gui.setItem(i, items.get(i));
			}
		}
		
		
		return gui;
	}
}

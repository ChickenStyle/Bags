package me.chickenstyle.backpack;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.chickenstyle.backpack.commands.ArrowBagCommand;
import me.chickenstyle.backpack.commands.BagCommand;
import me.chickenstyle.backpack.commands.PotionBagCommand;
import me.chickenstyle.backpack.commands.TalismanBagCommand;
import me.chickenstyle.backpack.configs.BagsData;
import me.chickenstyle.backpack.events.InventoryClick;
import me.chickenstyle.backpack.events.InventoryClose;

public class Main extends JavaPlugin implements Listener{
	
	private static Main instance;
	@Override
	public void onEnable() {
		
		instance = this;
		
		// Loads configs
		this.getConfig().options().copyDefaults();
	    saveDefaultConfig();
	    new BagsData(this);
	    
	    //Commands
	    getCommand("arrowbag").setExecutor(new ArrowBagCommand());
	    getCommand("potionbag").setExecutor(new PotionBagCommand());
	    getCommand("talismanbag").setExecutor(new TalismanBagCommand());
	    getCommand("bag").setExecutor(new BagCommand());
	    
	    loadListeners();
	    
	    getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Backpacks plugin has been enabled!");
	}
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if (!BagsData.containsPlayer(e.getPlayer())) {
			BagsData.addData(e.getPlayer(), BagType.Arrows, new ArrayList<ItemStack>());
			BagsData.addData(e.getPlayer(), BagType.Potions, new ArrayList<ItemStack>());
			BagsData.addData(e.getPlayer(), BagType.Talismans, new ArrayList<ItemStack>());
			BagsData.addData(e.getPlayer(), BagType.Bag, new ArrayList<ItemStack>());
		}
	}

	
	public static Main getInstance() {
		return instance;
	}
	
	public void loadListeners() {
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new InventoryClose(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
	}
}

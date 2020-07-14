package me.chickenstyle.backpack.configs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.chickenstyle.backpack.BagType;
import me.chickenstyle.backpack.Main;


/*
 * Bags:
 *   {uuid}:
 *     Arrows:
 *     - Cool
 *     - Yes
 *     Potions:
 *     - YES
 *     - Very cool
 *     Talismans:
 *     - Cool
 *     - No
 *    
 * 
 * 
 */

public class BagsData {
	
	private static File file;
	private static YamlConfiguration config;
    public BagsData(Main main) {
  	  file = new File(main.getDataFolder(), "BagsData.yml");
  	 if (!file.exists()) {
  		 try {
				 file.createNewFile();
		    	 config = YamlConfiguration.loadConfiguration(file);
		    	  	try {
		    				config.save(file);
		    		    	config = YamlConfiguration.loadConfiguration(file);
		    			} catch (IOException e) {
		    				e.printStackTrace();
		    			}
			} catch (IOException e) {
				e.printStackTrace();
			}
  		 
  	 }
  	config = YamlConfiguration.loadConfiguration(file);
   }
    static public void addData(Player player,BagType type,ArrayList<ItemStack> items) {
    		config.set("Bags." + player.getUniqueId() + "." + type, items);
    	  	try {
    			config.save(file);
    	    	config = YamlConfiguration.loadConfiguration(file);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    }

	
	@SuppressWarnings("unchecked")
	static public ArrayList<ItemStack> getItems(Player player,BagType type) {
		return (ArrayList<ItemStack>) config.get("Bags." + player.getUniqueId() + "." + type);
    }
	
	static public boolean containsPlayer(Player player) {
		return config.contains("Bags." + player.getUniqueId());
	}
	
	static public void configReload() {
   	 config = YamlConfiguration.loadConfiguration(file);
		try {
			config.save(file);
			config = YamlConfiguration.loadConfiguration(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

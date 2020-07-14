package me.chickenstyle.backpack.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.chickenstyle.backpack.BagType;
import me.chickenstyle.backpack.Main;
import me.chickenstyle.backpack.Utils;
import me.chickenstyle.backpack.configs.BagsData;
import me.chickenstyle.backpack.holders.PotionHolder;

public class PotionBagCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Inventory gui = Utils.createInventory(new PotionHolder(),
					Main.getInstance().getConfig().getString("titles.potion"),
					BagsData.getItems(player, BagType.Potions));
			player.openInventory(gui);
		}
		return false;
	}

}

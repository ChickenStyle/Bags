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
import me.chickenstyle.backpack.holders.TalismanHolder;

public class TalismanBagCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Inventory gui = Utils.createInventory(new TalismanHolder(),
					Main.getInstance().getConfig().getString("titles.talisman"),
					BagsData.getItems(player, BagType.Talismans));
			player.openInventory(gui);
		}
		return false;
	}

}

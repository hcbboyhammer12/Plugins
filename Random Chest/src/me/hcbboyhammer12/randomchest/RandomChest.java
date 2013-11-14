package me.hcbboyhammer12.randomchest;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomChest extends JavaPlugin{
	
	public void onEnable() {
		getLogger().info("Time to get random!");
	}
	
	public void onDisable() {
		getLogger().info("No more randomness!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("random")) {
		Player p = (Player) sender;
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can create a random chest!");
				return true;
			}
			
			if (!(args.length == 0)) {
				sender.sendMessage(ChatColor.RED + "There are no arguments for this command!");
				return true;
			}
			
		}
	}
}

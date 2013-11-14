package me.hcbboyhammer12.announcer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Announcer extends JavaPlugin{
	
	SettingsManager settings = SettingsManager.getInstance();
	
	public void onEnable() {
		settings.setup(this);
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement"));
			}
		}, 20, 12000);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("annreload")) {
			settings.reloadConfig();
			sender.sendMessage(ChatColor.GREEN + "Reloaded Announcer config!");
		}
		return true;
	}

}

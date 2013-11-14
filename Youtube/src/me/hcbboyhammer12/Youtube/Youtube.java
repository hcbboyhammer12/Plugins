package me.hcbboyhammer12.Youtube;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Youtube extends JavaPlugin{
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		getLogger().info("onEnable has been invoked!");
	}
	
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("youtube")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players can run that command!");
				return true;
			}
			
			if (args.length != 0) {
				sender.sendMessage(ChatColor.RED + "There are no arguments for this command!");
				return true;
			}
			
			sender.sendMessage(ChatColor.AQUA + getConfig().getString("Channel Name") + "- " + ChatColor.DARK_AQUA + getConfig().getString("Channel Link") + ". " + getConfig().getString("Message"));
		}
		if (cmd.getName().equalsIgnoreCase("ytsetname")) {
			if (!sender.hasPermission("yt.setname")) {
				sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "You must include a Channel Name!");
				return true;
			}
			StringBuilder str = new StringBuilder();
			for (int i= 0; i < args.length; i++) {
				str.append(args[i] + " ");
			}
			String name = str.toString();
			getConfig().set("Channel Name", name);
			saveConfig();
			sender.sendMessage(ChatColor.GREEN + "Channel Name set to: " + name);
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("ytsetlink")) {
			if (!sender.hasPermission("yt.setlink")) {
				sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "You must include a Channel Link!");
				return true;
			}
			StringBuilder str = new StringBuilder();
			for (int i= 0; i < args.length; i++) {
				str.append(args[i] + " ");
			}
			String link = str.toString();
			getConfig().set("Channel Link", link);
			saveConfig();
			sender.sendMessage(ChatColor.GREEN + "Channel Link set to: " + link);
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("ytsetmessage")) {
			if (!sender.hasPermission("yt.setmessage")) {
				sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "You must include a custom message!");
				return true;
			}
			StringBuilder str = new StringBuilder();
			for (int i= 0; i < args.length; i++) {
				str.append(args[i] + " ");
			}
			String message = str.toString();
			getConfig().set("Message", message);
			saveConfig();
			sender.sendMessage(ChatColor.GREEN + "Custom message set to: " + message);
			return true;
		}
		return true;
	}
}

package me.hcbboyhammer12.motd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MOTD extends JavaPlugin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.sendMessage(ChatColor.GREEN + getConfig().getString("message"));
	}
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("motd")) {
			sender.sendMessage(ChatColor.GREEN + "MOTD: " + getConfig().getString("message"));
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("setmotd")) {
			if (!sender.hasPermission("motd.set")) {
				sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
				return true;
			}
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Please specify a message!");
				return true;
			}
			StringBuilder str = new StringBuilder();
			for (int i= 0; i < args.length; i++) {
				str.append(args[i] + " ");
			}
			String motd = str.toString();
			getConfig().set("message", motd);
			saveConfig();
			sender.sendMessage(ChatColor.GREEN + "MOTD set to: " + motd);
			return true;
		}
		return true;
	}	
}

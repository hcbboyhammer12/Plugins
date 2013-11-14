package me.hcbboyhammer12.consoleonly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ConsoleOnly extends JavaPlugin implements Listener{
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		String msg = e.getMessage().toLowerCase();
		if (msg.startsWith("/op")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED + "Only the console can execute that command!");
		}
		
	}

}

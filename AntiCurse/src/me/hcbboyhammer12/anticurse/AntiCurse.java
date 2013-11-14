package me.hcbboyhammer12.anticurse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCurse extends JavaPlugin implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		for (String word : e.getMessage().split(" ")) {
			if (getConfig().getString("badwords").contains(word)) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "Don't curse!");
			}
		}
	}
	
	public void onEnable() {
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("AntiCurse has been enabled!");
	}

}

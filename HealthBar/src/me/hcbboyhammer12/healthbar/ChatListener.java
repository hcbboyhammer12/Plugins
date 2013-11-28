package me.hcbboyhammer12.healthbar;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();
        String msg = e.getMessage();
        double h = p.getHealth();
        p.setDisplayName(ChatColor.YELLOW + "[" + ChatColor.RED + h + "/20.0" + ChatColor.YELLOW + "]" + ChatColor.WHITE + p.getName());
    }
}

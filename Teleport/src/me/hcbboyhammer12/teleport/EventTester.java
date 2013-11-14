package me.hcbboyhammer12.teleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EventTester implements Listener {

    @EventHandler
    public void onPlayerWarp(PlayerWarpEvent e) {
        Bukkit.getServer().broadcastMessage(ChatColor.GREEN + e.getPlayer().getName() + " warped to warp " + e.getWarpName() + "!");
    }

}

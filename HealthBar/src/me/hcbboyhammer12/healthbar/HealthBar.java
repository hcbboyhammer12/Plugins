package me.hcbboyhammer12.healthbar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HealthBar extends JavaPlugin {

    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }
}

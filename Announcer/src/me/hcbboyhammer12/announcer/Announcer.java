package me.hcbboyhammer12.announcer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Announcer extends JavaPlugin{
	
	SettingsManager settings = SettingsManager.getInstance();
	
	public void onEnable() {

        getConfig().options().copyDefaults(true);
        saveConfig();
		settings.setup(this);
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement1.message1"));
			}
		}, settings.getConfig().getInt("announcement1.delay1"), 12000);

        settings.setup(this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement2.message2"));
            }
        }, settings.getConfig().getInt("announcement2.delay2"), 12000);

        settings.setup(this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement3.message3"));

            }
        }, settings.getConfig().getInt("announcement3.delay3"), 12000);

        settings.setup(this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement4.message4"));
            }
        }, settings.getConfig().getInt("announcement4.delay4"), 12000);

        settings.setup(this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement5.message5"));
            }
        }, settings.getConfig().getInt("announcement5.delay5"), 12000);

        settings.setup(this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement6.message6"));
            }
        }, settings.getConfig().getInt("announcement6.delay6"), 12000);

        settings.setup(this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement7.message7"));
            }
        }, settings.getConfig().getInt("announcement7.delay7"), 12000);

        settings.setup(this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + settings.getConfig().getString("announcement8.message8"));
            }
        }, settings.getConfig().getInt("announcement8.delay8"), 12000);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("annreload")) {
			settings.reloadConfig();
			sender.sendMessage(ChatColor.GREEN + "Reloaded Announcer config!");
		}
		return true;
	}

}

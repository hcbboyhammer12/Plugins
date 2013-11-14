package me.hcbboyhammer12.teleport;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Teleport extends JavaPlugin {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	public void onEnable() {
		settings.setup(this);
        Bukkit.getServer().getPluginManager().registerEvents(new EventTester(), this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This plugin is for players only!");
		}
		
		Player p = (Player) sender;
		
		
		if  (cmd.getName().equalsIgnoreCase("tp")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "Please specify a player!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
				return true;
			}
			p.teleport(target.getLocation());
			return true;
		}	
	
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			settings.getData().set("spawn.world" , p.getLocation().getWorld().getName());
			settings.getData().set("spawn.x" , p.getLocation().getX());
			settings.getData().set("spawn.y" , p.getLocation().getY());
			settings.getData().set("spawn.z" , p.getLocation().getZ());
			saveConfig();
			p.sendMessage(ChatColor.GREEN + "Spawn set!");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			if (settings.getData().getConfigurationSection("spawn") == null) {
				p.sendMessage(ChatColor.RED + "The spawn has not yet been set!");
				return true;
			}
			World w = Bukkit.getServer().getWorld(settings.getData().getString("spawn.world"));
			double x = settings.getData().getDouble("spawn.x");
			double y = settings.getData().getDouble("spawn.y");
			double z = settings.getData().getDouble("spawn.z");
			p.teleport(new Location(w, x, y, z));
			p.sendMessage(ChatColor.GREEN + "Welcome to the spawn!");
			
		}
		
		if (cmd.getName().equalsIgnoreCase("setwarp")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "Please specify a warp name!");
				return true;
			}
			settings.getData().set("warps." + args[0] + ".world", p.getLocation().getWorld().getName());
			settings.getData().set("warps." + args[0] + ".x", p.getLocation().getX());
			settings.getData().set("warps." + args[0] + ".y", p.getLocation().getY());
			settings.getData().set("warps." + args[0] + ".z", p.getLocation().getZ());
			settings.saveData();
			p.sendMessage(ChatColor.GREEN + "Set warp " + args[0] + "!");
		}
		
		if (cmd.getName().equalsIgnoreCase("warp")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "Please specify a warp!");
				return true;
			}
            if (settings.getData().getConfigurationSection("warps." + args[0]) == null) {
                p.sendMessage(ChatColor.RED + "Warp " + args[0] + " does not exist!");
                return true;
            }
			World w = Bukkit.getServer().getWorld(settings.getData().getString("warps." + args[0] + ".world"));
			double x = settings.getData().getDouble("warps." + args[0] + ".x");
			double y = settings.getData().getDouble("warps." + args[0] + ".y");
			double z = settings.getData().getDouble("warps." + args[0] + ".z");
            Location l = new Location(w, x, y, z);
			p.teleport(l);
            Bukkit.getServer().getPluginManager().callEvent(new PlayerWarpEvent(p, l, args[0]));
			p.sendMessage(ChatColor.GREEN + "Teleported to " + args[0] + "!");
		}

        if (cmd.getName().equalsIgnoreCase("delwarp")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Please specify a warp!");
                return true;
            }
            if (settings.getData().getConfigurationSection("warps." + args[0]) == null) {
                p.sendMessage(ChatColor.RED + "Warp " + args[0] + " does not exist!");
                return true;
            }
            settings.getData().set("warps." + args[0], null);
            settings.saveData();
            p.sendMessage(ChatColor.GREEN + "Removed warp " + args[0] + "!");
        }

		return true;		
	
	}
}

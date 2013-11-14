package me.hcbboyhammer12.medic;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Medic extends JavaPlugin {
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new MedicListener(), this);
    }
       
        @SuppressWarnings("deprecation")
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
               
                if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.RED + "The console cannot use Medic!");
                        return true;
                }
               
                Player player = (Player) sender;
               
                if (cmd.getName().equalsIgnoreCase("heal")) {
                        if (args.length == 0) {
                                player.setHealth(20);
                                player.sendMessage(ChatColor.GREEN + "You have been healed!");
                                return true;
                        }
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target == null) {
                                player.sendMessage(ChatColor.RED + "Could not find player!");
                                return true;
                        }
                        target.setHealth(20);
                        target.sendMessage(ChatColor.GREEN + "You have been healed!");
                        player.sendMessage(ChatColor.GREEN + target.getName() + " has been healed!");
                }
               
                if (cmd.getName().equalsIgnoreCase("feed")) {
                        if (args.length == 0) {
                                player.setFoodLevel(20);
                                player.sendMessage(ChatColor.GREEN + "You have been fed!");
                                return true;
                        }
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target == null) {
                                player.sendMessage(ChatColor.RED + "Could not find player!");
                                return true;
                        }
                        target.setFoodLevel(20);
                        target.sendMessage(ChatColor.GREEN + "You have been fed!");
                        player.sendMessage(ChatColor.GREEN + target.getName() + " has been fed!");
                }
                if (cmd.getName().equalsIgnoreCase("hurt")) {
                    if (args.length == 0) {
                        player.setHealth(5);
                        player.sendMessage(ChatColor.GOLD + "You have been hurt!");
                        return true;
                    }
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.RED + "Could not find player!");
                        return true;
                    }
                    target.setHealth(5);
                    target.sendMessage(ChatColor.GREEN + "You have been hurt!");
                    player.sendMessage(ChatColor.GREEN + target.getName() + " has been hurt!");
                }
            if (cmd.getName().equalsIgnoreCase("starve")) {
                if (args.length == 0) {
                    player.setFoodLevel(5);
                    player.sendMessage(ChatColor.GOLD + "You have been starved!");
                    return true;
                }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Could not find player!");
                    return true;
                }
                target.setFoodLevel(5);
                target.sendMessage(ChatColor.GREEN + "You have been starved!");
                player.sendMessage(ChatColor.GREEN + target.getName() + " has been starved!");
                }
                return true;
        }
}
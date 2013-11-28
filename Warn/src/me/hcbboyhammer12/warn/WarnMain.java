package me.hcbboyhammer12.warn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WarnMain extends JavaPlugin {

    public void onEnable() {

    }


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warn")) {
            if (!(args.length == 0)) {
                sender.sendMessage(ChatColor.RED + "Invalid length of arguments!");
                return true;
            }

            String reason = args[0];
            Player p = Bukkit.getServer().getPlayer(args[1]);

            if (reason == "spam") {
                if (args[1] == null) {
                    sender.sendMessage(ChatColor.RED + "Please specify a valid player! Player " + args[1] + " could not be found!");
                    return true;
                }

                p.sendMessage(ChatColor.GOLD + "Do not spam. You have been warned! -" + sender.getName());
                p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());

            }
            if (reason == "swearing") {
                if (args[1] == null) {
                    sender.sendMessage(ChatColor.RED + "Please specify a valid player! Player " + args[1] + " could not be found!");
                    return true;
                }

                p.sendMessage(ChatColor.GOLD + "Do not swear. You have been warned! -" + sender.getName());
                p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());

            }
            if (reason == "profanity") {
                if (args[1] == null) {
                    sender.sendMessage(ChatColor.RED + "Please specify a valid player! Player " + args[1] + " could not be found!");
                    return true;
                }

                p.sendMessage(ChatColor.GOLD + "Do not use profanity. You have been warned! -" + sender.getName());
                p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());

            }
            if (reason == "rude") {
                if (args[1] == null) {
                    sender.sendMessage(ChatColor.RED + "Please specify a valid player! Player " + args[1] + " could not be found!");
                    return true;
                }

                p.sendMessage(ChatColor.GOLD + "Do not be rude. You have been warned! -" + sender.getName());
                p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());

            }
            if (reason == "advertise") {
                if (args[1] == null) {
                    sender.sendMessage(ChatColor.RED + "Please specify a valid player! Player " + args[1] + " could not be found!");
                    return true;
                }

                p.sendMessage(ChatColor.GOLD + "Do not advertise. You have been warned! -" + sender.getName());
                p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());

            }
            if (reason == "inappropriate") {
                if (args[1] == null) {
                    sender.sendMessage(ChatColor.RED + "Please specify a valid player! Player " + args[1] + " could not be found!");
                    return true;
                }

                p.sendMessage(ChatColor.GOLD + "Do not be inappropriate. You have been warned! -" + sender.getName());
                p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());

            }
        }
        return false;
    }

}

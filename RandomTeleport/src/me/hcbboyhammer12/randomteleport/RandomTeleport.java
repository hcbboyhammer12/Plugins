package me.hcbboyhammer12.randomteleport;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomTeleport extends JavaPlugin {

    public boolean onCommand (CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("randomtp")) {
            Player p = (Player) sender;

        }
    }

}

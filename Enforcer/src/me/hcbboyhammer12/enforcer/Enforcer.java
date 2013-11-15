package me.hcbboyhammer12.enforcer;

import org.bukkit.command.CommandSender;
import org.bukkit.material.Command;
import org.bukkit.plugin.java.JavaPlugin;

public class Enforcer extends JavaPlugin {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kick")) {


        }
        return true;
    }
}

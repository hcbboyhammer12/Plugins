package me.hcbboyhammer12.basics;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Basics extends JavaPlugin{

	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("")) {
			if (sender instanceof Player) {
			
							
			}
			
		}
	}
	
	
}

package me.hcbboyhammer12.swag;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SWAG extends JavaPlugin {
	
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}
	
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("swag")) {
			if (sender instanceof Player)
				Player player = (Player) sender;
				
			
		}
	}
}

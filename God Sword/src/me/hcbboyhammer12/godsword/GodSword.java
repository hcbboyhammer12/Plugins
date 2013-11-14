package me.hcbboyhammer12.godsword;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class GodSword extends JavaPlugin{
	
	public void onEnable() {
		getLogger().info("onEnable has been invoked for God Sword!");
	}
	public void onDisable() {
		getLogger().info("onDisable has been invoked for God Sword!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		PlayerInventory inv = (PlayerInventory) player.getInventory();
		if (cmd.getName().equalsIgnoreCase("godsword"))
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Only players are able to recieve the God Sword!");
				return true;
			}
			if (!sender.hasPermission("gs.summon")) {
				sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
				return true;
			}
			if(args.length != 0) {
				sender.sendMessage(ChatColor.RED + "You cannot give other players the God Sword!");
				return true;
			}
			ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
			sword.addEnchantment(Enchantment.DAMAGE_ALL , 5);
			sword.addEnchantment(Enchantment.FIRE_ASPECT , 2);
			sword.addEnchantment(Enchantment.KNOCKBACK , 2);
			sword.addEnchantment(Enchantment.DURABILITY , 3);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName("The God Sword");
			sword.setItemMeta(swordMeta);
			inv.addItem(sword);
			return true;

        if (cmd.getName().equalsIgnoreCase("godarmor"))
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players are able to recieve the God Armor!");
                return true;
            }
            if (!sender.hasPermission("ga.summon")) {
            sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
            return true;
        }
            if(args.length != 0) {
                sender.sendMessage(ChatColor.RED + "You cannot give other players the God Armor!");
                return true;
        }
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
            item.addEnchantment(Enchantment.DAMAGE_ALL , 5);
            item.addEnchantment(Enchantment.FIRE_ASPECT , 2);
            item.addEnchantment(Enchantment.KNOCKBACK , 2);
            item.addEnchantment(Enchantment.DURABILITY , 3);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("The God Sword");
            item.setItemMeta(itemMeta);
            inv.addItem(item);
            return true;
    }
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
            item.addEnchantment(Enchantment.DAMAGE_ALL , 5);
            item.addEnchantment(Enchantment.FIRE_ASPECT , 2);
            item.addEnchantment(Enchantment.KNOCKBACK , 2);
            item.addEnchantment(Enchantment.DURABILITY , 3);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("The God Sword");
            item.setItemMeta(itemMeta);
            inv.addItem(item);
            return true;
    }

}

package me.hcbboyhammer12.kit;
 
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
 
public class Kit extends JavaPlugin {
 
        public static Economy econ = null;
       
        public void onEnable() {
        if (!setupEconomy()) {
            getLogger().severe(ChatColor.RED + "Disabled due to no Vault dependency found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }
       
        private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
       
        ArrayList<Player> cooldown = new ArrayList<Player>();
       
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
                if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.RED + "Only players can get kits!");
                        return true;
                }
               
                final Player p = (Player) sender;
                PlayerInventory pi = p.getInventory();
               
                if (cmd.getName().equalsIgnoreCase("kit")) {
                        if (cooldown.contains(p)) {
                                p.sendMessage(ChatColor.RED + "You cannot get another kit yet!");
                                return true;
                        }
                        EconomyResponse r = econ.withdrawPlayer(p.getName(), 10);
                        if (r.transactionSuccess()) {
                                pi.addItem(new ItemStack(Material.STONE_SWORD, 1));
                                pi.addItem(new ItemStack(Material.STONE_PICKAXE, 1));
                                pi.addItem(new ItemStack(Material.APPLE, 5));
                                p.sendMessage(ChatColor.GREEN + "You got your kit!");
                                cooldown.add(p);
                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                                        public void run() {
                                                cooldown.remove(p);
                                        }
                                }, 100);
                                return true;
                        }
                        else {
                                p.sendMessage(ChatColor.RED + "You cannot get a kit at this time.");
                                return true;
                        }
                }
                if (cmd.getName().equalsIgnoreCase("barbarian")) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.RED + "Only players can get kits!");
                        return true;
                    }

                    if (p.getGameMode() != GameMode.SURVIVAL) {
                        p.sendMessage(ChatColor.RED + "YOu must be in survival to get this kit!");
                        return true;
                    }

                    if (pi.contains(266, 10)) {

                        pi.addItem(new ItemStack(Material.IRON_SWORD, 1));
                        pi.addItem(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
                        pi.addItem(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
                        pi.addItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
                        pi.addItem(new ItemStack(Material.CHAINMAIL_HELMET, 1));
                        pi.addItem(new ItemStack(Material.COOKED_BEEF, 3));
                        pi.addItem(new ItemStack(Material.MELON, 5));



                    }
                }
               
                if (cmd.getName().equalsIgnoreCase("ci")) {
                        pi.clear();
                        p.sendMessage(ChatColor.GREEN + "Inventory Cleared!");
                }
                return true;
        }
}
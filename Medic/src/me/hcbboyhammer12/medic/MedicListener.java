package me.hcbboyhammer12.medic;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MedicListener implements Listener {
	
	@EventHandler
    public void onSignChange(SignChangeEvent e) {
            if (e.getLine(0).equalsIgnoreCase("[Heal]")) {
                    e.setLine(0, "§3[Heal]");
                    e.setLine(1, "§3Click here");
                    e.setLine(2, "§3to get healed!");
            }
        if (e.getLine(0).equalsIgnoreCase("[Feed]")) {
            e.setLine(0, "§2[Feed]");
            e.setLine(1, "§2Click here");
            e.setLine(2, "§2to be fed!");

        }
    }
   
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
            if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (e.getClickedBlock().getState() instanceof Sign) {
                    Sign s = (Sign) e.getClickedBlock().getState();
                    if (s.getLine(0).equalsIgnoreCase("§3[Heal]")) {
                            e.getPlayer().setHealth(20);
                            e.getPlayer().sendMessage(ChatColor.GREEN + "You were healed!");
                    }
            }
            if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (e.getClickedBlock().getState() instanceof Sign) {
                    Sign s = (Sign) e.getClickedBlock().getState();
                    if (s.getLine(0).equalsIgnoreCase("§2[Feed]")) {
                           e.getPlayer().setFoodLevel(20);
                           e.getPlayer().sendMessage(ChatColor.GREEN + "You were fed!");
            }
        }
    }
}

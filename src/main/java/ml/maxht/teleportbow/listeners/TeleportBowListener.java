package ml.maxht.teleportbow.listeners;

import ml.maxht.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import java.net.http.WebSocket;

public class TeleportBowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {

        if (e.getEntity().getShooter() instanceof Player p) {

            ItemStack shotBow = p.getInventory().getItemInMainHand();
            if (shotBow.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + TeleportBow.getPlugin(TeleportBow.class).getConfig().getString("bowname"))) {
            }

        }

    }

}

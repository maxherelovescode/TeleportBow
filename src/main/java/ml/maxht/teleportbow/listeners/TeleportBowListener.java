package ml.maxht.teleportbow.listeners;

import ml.maxht.teleportbow.TeleportBow;
import ml.maxht.teleportbow.utility.BowUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.net.http.WebSocket;
import java.util.concurrent.TimeUnit;

public class TeleportBowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {

        if (e.getEntity().getShooter() instanceof Player p) {

            ItemStack shotBow = p.getInventory().getItemInMainHand();
            if (shotBow.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + TeleportBow.getPlugin(TeleportBow.class).getConfig().getString("bowname"))) {

                Location location = e.getEntity().getLocation();
                p.teleport(location);
                e.getEntity().remove();
                p.sendMessage(ChatColor.GREEN + "Teleport Successful");
                p.playSound(p, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);

            }

        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        if (TeleportBow.getPlugin(TeleportBow.class).getConfig().getBoolean("playerjoinenabled") == true){
            Player p = e.getPlayer();
            if (p.hasPlayedBefore() == false) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                p.getInventory().addItem(BowUtils.createTeleportBow());
                p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                p.sendMessage(ChatColor.YELLOW + "Here's A Free Teleport Bow. Don't Lose it! You won't get another");
            }
        }

    }


}

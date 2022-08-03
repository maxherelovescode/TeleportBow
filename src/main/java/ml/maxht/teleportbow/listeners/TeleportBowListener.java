package ml.maxht.teleportbow.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.net.http.WebSocket;

public class TeleportBowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e){

        if (e.getEntity().getType() == EntityType.ARROW){

            

        }

    }

}

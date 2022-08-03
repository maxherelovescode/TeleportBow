package ml.maxht.teleportbow;

import ml.maxht.teleportbow.commands.GiveCommand;
import ml.maxht.teleportbow.listeners.TeleportBowListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    public static TeleportBow plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("givebow").setExecutor(new GiveCommand());
        getServer().getPluginManager().registerEvents(new TeleportBowListener(), this );
        System.out.println("The teleport bow Plugin has loaded.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("The teleport bow Plugin has shutdown.");
    }
}

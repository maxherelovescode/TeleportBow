package ml.maxht.teleportbow;

import ml.maxht.teleportbow.commands.GiveCommand;
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
        System.out.println("The teleport bow Plugin has loaded.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("The teleport bow Plugin has shutdown.");
    }
}

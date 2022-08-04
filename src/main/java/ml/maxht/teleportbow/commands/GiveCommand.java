package ml.maxht.teleportbow.commands;

import ml.maxht.teleportbow.TeleportBow;
import ml.maxht.teleportbow.utility.BowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.annotation.Target;

public class GiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if (p.hasPermission("tpbow.givebow")){
                if (args.length == 0){

                    ItemStack bow = BowUtils.createTeleportBow();
                    p.getInventory().addItem(bow);
                    p.getInventory().addItem(new ItemStack(Material.ARROW));
                    p.sendMessage(ChatColor.GREEN + "You have been given a teleport bow.");

                }else {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null){
                        p.sendMessage(ChatColor.RED + "That player does not exist.");

                        return true;
                    }

                    ItemStack bow = BowUtils.createTeleportBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW));
                    target.sendMessage(ChatColor.GREEN + "You have been given a teleport bow by " + ChatColor.YELLOW + p.getDisplayName());

                }
            }else {
                p.sendMessage(ChatColor.RED + "You do not have the permission to use this command.");
            }

        }

        return true;
    }
}

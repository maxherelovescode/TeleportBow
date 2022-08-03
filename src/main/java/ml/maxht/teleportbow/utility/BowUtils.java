package ml.maxht.teleportbow.utility;

import ml.maxht.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;

public class BowUtils {


    public static ItemStack createTeleportBow(){

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GREEN + TeleportBow.getPlugin().getConfig().getString("bowname"));
        ArrayList lore = new ArrayList<>();
        lore.add("Teleport Bow");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowMeta);
        return bow;


    }

}

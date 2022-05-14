package me.invis.report.util;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {

    public static ItemStack stripFlags(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.removeItemFlags(ItemFlag.values());
        item.setItemMeta(itemMeta);

        return item;
    }

}

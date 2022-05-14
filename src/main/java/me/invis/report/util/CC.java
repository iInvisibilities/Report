package me.invis.report.util;

import org.bukkit.ChatColor;

public class CC {

    public static String translateColors(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

}

package me.invis.report.util;

import me.invis.report.Report;
import me.invis.report.preset.Setting;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Cooldown {

    public static List<Player> cooldownList = new ArrayList<>();

    public static void addPlayer(Player player) {
        if(!isInCooldown(player)) cooldownList.add(player);
        Bukkit.getScheduler().runTaskLater(Report.getInstance(), () -> removePlayer(player), Setting.REPORT_DELAY * 20L);
    }

    public static void removePlayer(Player player) {
        if(isInCooldown(player)) cooldownList.remove(player);
    }

    public static boolean isInCooldown(Player player) {
        return cooldownList.contains(player);
    }

}

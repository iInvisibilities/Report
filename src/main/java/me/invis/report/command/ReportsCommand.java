package me.invis.report.command;

import me.invis.report.Report;
import me.invis.report.inventory.ReportsInventory;
import me.invis.report.util.ListUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ReportsCommand implements CommandExecutor {

    private final FileConfiguration reportsFile = Report.getCurrentReportsFile();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(args.length <= 1) {
            if(!(commandSender instanceof Player)) return true;
            ((Player) commandSender).openInventory(Report.getReportsInventory());
        }

        else {
            if(args[0].equalsIgnoreCase("clear")) {
                String playerName = args[1];
                OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);
                String playerUUIDString = player.getUniqueId().toString();

                reportsFile.getKeys(false).forEach(report -> reportsFile.set(report, ListUtil.removeAll(new ArrayList<>(reportsFile.getStringList(report)), playerUUIDString)));
                ReportsInventory.initItems();

                commandSender.sendMessage(ChatColor.GREEN + "Cleared all reports for " + playerName + "(" + playerUUIDString + ")!");
            }
        }

        return true;
    }

}

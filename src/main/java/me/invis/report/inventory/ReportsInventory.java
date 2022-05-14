package me.invis.report.inventory;

import me.invis.report.Report;
import me.invis.report.ReportType;
import me.invis.report.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;

public class ReportsInventory {

    private final Inventory inventory;

    public ReportsInventory() {
        // Identifying/making the inventory
        inventory = Bukkit.createInventory(null, 54, "Current reports:");

        // Adding already-existing reports to the inventory
        initItems(inventory);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public static void initItems(Inventory inventory) {
        FileConfiguration reportsFile = Report.getCurrentReportsFile();

        inventory.clear();

        reportsFile.getKeys(false).forEach(reportName -> {
            List<String> reportedPlayers = reportsFile.getStringList(reportName);
            ReportType reportType = ReportType.getByReport(reportName);

            reportedPlayers.forEach(reportedPlayerUUID -> {
                OfflinePlayer reportedPlayer = Bukkit.getOfflinePlayer(UUID.fromString(reportedPlayerUUID));

                ItemStack reportItem = new ItemStack(Material.valueOf((reportType == ReportType.CHAT ? "PAPER" : "DIAMOND_SWORD")));
                ItemMeta reportItemMeta = reportItem.getItemMeta();
                reportItemMeta.setDisplayName(reportedPlayer.getName() + ChatColor.RESET + "(" + ChatColor.valueOf(((reportType == ReportType.CHAT ? "WHITE" : "DARK_AQUA"))) + reportName + ChatColor.RESET + ")");
                reportItem.setItemMeta(reportItemMeta);

                inventory.addItem(ItemUtil.stripFlags(reportItem));
            });
        });
    }

    public static void initItems() {
        initItems(Report.getReportsInventory());
    }

}

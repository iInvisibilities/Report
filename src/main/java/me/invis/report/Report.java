package me.invis.report;

import me.invis.report.command.MainCommand;
import me.invis.report.command.ReportsCommand;
import me.invis.report.config.messages.Messages;
import me.invis.report.config.messages.enums.MessageType;
import me.invis.report.config.settings.Settings;
import me.invis.report.inventory.ReportsInventory;
import me.invis.report.listener.PlayerJoin;
import me.invis.report.listener.PlayerLeave;
import me.invis.report.listener.SimplePrevent;
import me.invis.report.staff.StaffManager;
import me.invis.report.staff.listener.Join;
import me.invis.report.staff.listener.Leave;
import me.invis.report.util.YamlFile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class Report extends JavaPlugin {

    private static Report INSTANCE;
    private static FileConfiguration CONFIG, REPORTS;
    private static Inventory REPORTS_INVENTORY;

    private Messages messages;
    private Settings settings;

    @Override
    public void onEnable() {
        // Self-identifying
        INSTANCE = this;

        // Creating files
        saveDefaultConfig();
        YamlFile reportsYamlFile = new YamlFile("reports.yml").create();

        // File variables identification
        CONFIG = getConfig();
        REPORTS = reportsYamlFile.get();

        // Initialization
        initSettings();
        initMessages();

        // Reports inventory identification
        REPORTS_INVENTORY = new ReportsInventory().getInventory();

        // Events registering
        Arrays.asList(
                new PlayerJoin(), new PlayerLeave(),
                new Join(), new Leave(),
                new SimplePrevent()
                )
                .forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, this));

        // Commands registering
        Arrays.asList
                        ("report", "chatreport")
                .forEach(commandName -> getCommand(commandName).setExecutor(new MainCommand()));

        getCommand("reports").setExecutor(new ReportsCommand());

        // Saving current staff members (only applicable if the server has been RELOADED, which is really discouraged!)
        Bukkit.getOnlinePlayers().stream().filter(StaffManager::isStaff).collect(Collectors.toList()).forEach(StaffManager::addNewStaffMember);
    }

    @Override
    public void onDisable() {
        new YamlFile("reports.yml").save(Report.getCurrentReportsFile());
    }

    private void initMessages() {
        ConfigurationSection messagesSection = getConfiguration().getConfigurationSection("MESSAGES");
        this.messages = new Messages(
                messagesSection.getKeys(false).stream().collect(Collectors.toMap(messageTypeName -> MessageType.valueOf(messageTypeName.replaceAll("-", "_")), messagesSection::getString, (a, b) -> b))
        );
    }

    public Messages getMessages() {
        return this.messages;
    }

    public void initSettings() {
        this.settings = new Settings(
                getConfiguration().getStringList("INGAME-REPORT"),
                getConfiguration().getStringList("CHAT-REPORT"),
                getConfiguration().getInt("REPORT-DELAY")
        );
    }

    public Settings getSettings() {
        return this.settings;
    }

    public static Report getInstance() {
        return INSTANCE;
    }

    public static FileConfiguration getConfiguration() {
        return CONFIG;
    }

    public static FileConfiguration getCurrentReportsFile() {
        return REPORTS;
    }

    public static Inventory getReportsInventory() {
        return REPORTS_INVENTORY;
    }
}

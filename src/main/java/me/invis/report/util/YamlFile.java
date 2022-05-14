package me.invis.report.util;

import me.invis.report.Report;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlFile {

    private final String fileName;

    private final File file;

    public YamlFile(String fileName) {
        this.fileName = fileName;
        this.file = new File(Report.getInstance().getDataFolder(), fileName);
    }

    public YamlFile create() {
        if (!getFile().exists()) {
            getFile().getParentFile().mkdirs();
            Report.getInstance().saveResource(getFileName(), false);
        }

        return this;
    }

    public YamlFile save(FileConfiguration configFile) {
        try {
            configFile.save(getFile());
        } catch (IOException e) { e.printStackTrace(); }

        return this;
    }

    public FileConfiguration get() {
        FileConfiguration configFile = new YamlConfiguration();
        try {
            configFile.load(getFile());
        } catch (IOException | InvalidConfigurationException e) { e.printStackTrace(); }

        return configFile;
    }

    private File getFile() {
        return this.file;
    }

    private String getFileName() {
        return this.fileName;
    }
}


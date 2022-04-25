package com.github.siroio.commandlog.clogger.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {

    private final Plugin plugin;
    private FileConfiguration config = null;

    private static String Color;
    private static String dbPath;

    public Config(Plugin plugin) {
        this.plugin = plugin;
        this.Load();
    }

    public void Load() {
        plugin.saveDefaultConfig();
        if(config != null) plugin.reloadConfig();
        config = plugin.getConfig();

        setColor(config.getString("Color"));
        setdbPath(config.getString("DatabasePath"));
    }

    public static String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public static String getdbPath() {
        return dbPath;
    }

    public void setdbPath(String path) {
        dbPath = path;
    }
}

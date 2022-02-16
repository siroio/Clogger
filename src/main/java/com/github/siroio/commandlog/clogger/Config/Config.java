package com.github.siroio.commandlog.clogger.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {

    private final Plugin plugin;
    private FileConfiguration config = null;

    private String Color;

    public Config(Plugin plugin) {
        this.plugin = plugin;
        this.Load();
    }

    public void Load() {
        plugin.saveDefaultConfig();
        if(config != null) plugin.reloadConfig();
        config = plugin.getConfig();

        config.getString("Color");
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public final FileConfiguration getConfig() {
        return config;
    }

}

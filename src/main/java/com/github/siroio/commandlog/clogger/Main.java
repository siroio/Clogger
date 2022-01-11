package com.github.siroio.commandlog.clogger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.siroio.commandlog.clogger.Utils.Logger;

public final class Main extends JavaPlugin {

    public static Main getInstance;
    public Main() { getInstance = this; }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger.print("プラグインが有効化されました");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package com.github.siroio.commandlog.clogger;

import com.github.siroio.commandlog.clogger.Events.Manager.EventManager;
import com.github.siroio.commandlog.clogger.Events.Manager.EventRegister;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.siroio.commandlog.clogger.Utils.Logger;

public final class Main extends JavaPlugin {

    public static Main getInstance;
    public EventManager eventManager;

    public Main() { getInstance = this;
        eventManager = new EventManager(this);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger.print("プラグインが有効化されました");
        eventManager.loadEvent();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Logger.print("プラグインが無効化されました");
        eventManager.unLoadEvent();
    }
}

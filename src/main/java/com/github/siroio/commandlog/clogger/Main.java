package com.github.siroio.commandlog.clogger;

import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import com.github.siroio.commandlog.clogger.Commands.cmd;
import com.github.siroio.commandlog.clogger.Config.Config;
import com.github.siroio.commandlog.clogger.Events.Manager.EventManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.siroio.commandlog.clogger.Utils.Logger;

public final class Main extends JavaPlugin {

    public static Main getInstance;
    public static Config config;
    private final EventManager eventManager;

    public Main() {
        getInstance = this;
        eventManager = new EventManager(this);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger.print("プラグインが有効化されました");
        eventManager.loadEvent();
        config = new Config(this);
        getCommand("clogger").setExecutor(new cmd());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Logger.print("プラグインが無効化されました");
        eventManager.unLoadEvent();
        PlayerBeanManager.clearPlayerList();
    }
}

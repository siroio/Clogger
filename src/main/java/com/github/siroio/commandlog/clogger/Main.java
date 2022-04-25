package com.github.siroio.commandlog.clogger;

import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import com.github.siroio.commandlog.clogger.Commands.MainCommand;
import com.github.siroio.commandlog.clogger.Config.Config;
import com.github.siroio.commandlog.clogger.Database.Database;
import com.github.siroio.commandlog.clogger.Events.Manager.EventManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.siroio.commandlog.clogger.Wrapper.Logger;

public final class Main extends JavaPlugin {

    public static Main getInstance;
    public static Config config;
    private final EventManager eventManager;
    private Database db;

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
        db = new Database();
        getCommand("clog").setExecutor(new MainCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Logger.print("プラグインが無効化されました");
        eventManager.unLoadEvent();
        PlayerBeanManager.clearPlayerList();
        db.close();
    }
}

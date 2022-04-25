package com.github.siroio.commandlog.clogger.Events.Manager;

import com.github.siroio.commandlog.clogger.Wrapper.Logger;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public final class EventRegister {

    private final Plugin plugin;

    private final HashMap<String, Listener> listenerList;

    public EventRegister(Plugin plugin) {
        this.plugin = plugin;
        listenerList = new HashMap<>();
    }

    // イベントの追加
    public void addEvent(Listener listener) {
        listenerList.put(listener.getClass().getSimpleName(), listener);
    }

    // イベントを登録
    public void Register() {
        listenerList.values().forEach((listener) -> {
            plugin.getServer()
                  .getPluginManager()
                  .registerEvents(listener, plugin);

            Logger.print(listener.getClass().getSimpleName(), "を登録しました。");
        });
    }

    // すべてのイベントの登録解除
    public void unRegisterAll() {
        HandlerList.unregisterAll();
        listenerList.clear();
        Logger.print("登録されているイベントを解除しました。");
    }
}

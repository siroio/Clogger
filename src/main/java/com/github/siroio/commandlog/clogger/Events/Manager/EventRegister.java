package com.github.siroio.commandlog.clogger.Events.Manager;

import com.github.siroio.commandlog.clogger.Utils.Logger;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public final class EventRegister {

    private final Plugin plugin;

    private final HashMap<String, Listener> EventList;

    public EventRegister(Plugin plugin) {
        this.plugin = plugin;
        EventList = new HashMap<>();
    }

    // イベントの追加
    public void addEvent(Listener listener) {
        EventList.put(listener.getClass().getSimpleName(), listener);
    }

    // イベントを登録
    public void Register() {
        EventList.values().forEach((event) -> {
            plugin.getServer()
                  .getPluginManager()
                  .registerEvents(event, plugin);

            Logger.print(event.getClass().getSimpleName(), "を登録しました。");
        });
    }

    // イベントの登録解除
    public void unRegister(Event event) {
        EventList.values().forEach((listener) -> {
            event.getHandlers().unregister(listener);
            EventList.remove(listener.getClass().getSimpleName());
        });
    }

    // すべてのイベントの登録解除
    public void unRegisterAll() {
        HandlerList.unregisterAll();
        EventList.clear();
    }
}

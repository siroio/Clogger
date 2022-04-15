package com.github.siroio.commandlog.clogger.Events.Manager;

import com.github.siroio.commandlog.clogger.Events.ConsoleEvents.ConsoleReceiveCommands;
import com.github.siroio.commandlog.clogger.Events.Inventory.InventoryClickEvents;
import com.github.siroio.commandlog.clogger.Events.PlayerEvents.PlayerJoinEvents;
import com.github.siroio.commandlog.clogger.Events.PlayerEvents.PlayerReceiveCommands;
import com.github.siroio.commandlog.clogger.Events.PlayerEvents.UnknownCommandMessage;
import org.bukkit.plugin.Plugin;

public class EventManager {

    private final EventRegister eventRegister;

    public EventManager(Plugin plugin) {
        eventRegister = new EventRegister(plugin);
    }

    // 登録したいイベントの追加
    // Do Not Delete This Function
    public void loadEvent() {
        /// イベントリスナーを作成したら以下に追加をしてください。 ///
        eventRegister.addEvent(new PlayerReceiveCommands());
        eventRegister.addEvent(new ConsoleReceiveCommands());
        eventRegister.addEvent(new PlayerJoinEvents());
        eventRegister.addEvent(new InventoryClickEvents());
        eventRegister.addEvent(new UnknownCommandMessage());

        eventRegister.Register();
    }

    // 特録解除
    public void unLoadEvent() {
        eventRegister.unRegisterAll();
    }

}

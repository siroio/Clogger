package com.github.siroio.commandlog.clogger.Events.Manager;

import com.github.siroio.commandlog.clogger.Events.Console.ConsoleReceiveCommands;
import com.github.siroio.commandlog.clogger.Events.Players.PlayerReceiveCommands;
import org.bukkit.plugin.Plugin;

public class EventManager {

    private final EventRegister eventRegister;

    public EventManager(Plugin plugin) {
        eventRegister = new EventRegister(plugin);
    }

    // 登録したいイベントの追加
    public void loadEvent() {
        /// ### イベントリスナーを作成したら以下に追加をしてください。 ///
        eventRegister.addEvent(new PlayerReceiveCommands());
        eventRegister.addEvent(new ConsoleReceiveCommands());

        /// ~~~ 削除をしないでください ~~~ ///
        eventRegister.Register();
        /// ~~~~~~~~~~~~~~~~~~~~~~~ ///
    }

    // 特録解除
    public void unLoadEvent() {
        eventRegister.unRegisterAll();
    }

}

package com.github.siroio.commandlog.clogger.Events.ConsoleEvents;

import com.github.siroio.commandlog.clogger.Config.Config;
import com.github.siroio.commandlog.clogger.Wrapper.Broadcast;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class ConsoleReceiveCommands implements Listener {
    // プレイヤー以外が実行したコマンドが処理される前に呼び出される。
    @EventHandler
    public void ReceiveConsoleCommand(ServerCommandEvent event) {
        if(event.getSender().getName().equals("@")) return;
        Broadcast.sendMessage(
                ChatColor.of(Config.getColor()),
                true,
                "[CLOG] ",
                event.getSender().getName(),
                ":",
                event.getCommand()
        );
    }
}

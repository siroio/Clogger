package com.github.siroio.commandlog.clogger.Events.ConsoleEvents;

import com.github.siroio.commandlog.clogger.Utils.Broadcast;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class ConsoleReceiveCommands implements Listener {
    // プレイヤー以外が実行したコマンドが処理される前に呼び出される。
    @EventHandler
    public void ReceiveConsoleCommand(ServerCommandEvent event) {
        if(event.getSender().getName().equals("@")) return;
        Broadcast.sendMessage(
                ChatColor.GRAY,
                "[CLOGGER] ",
                event.getSender().getName(),
                ":",
                event.getCommand()
        );
    }
}

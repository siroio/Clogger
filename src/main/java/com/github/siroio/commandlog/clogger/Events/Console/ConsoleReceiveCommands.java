package com.github.siroio.commandlog.clogger.Events.Console;

import com.github.siroio.commandlog.clogger.Utils.Broadcast;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class ConsoleReceiveCommands implements Listener {
    // プレイヤー以外が実行したコマンドが処理される前に呼び出される。
    @EventHandler
    public void ReceiveConsoleCommand(ServerCommandEvent event) {
        Broadcast.sendMessage(
                ChatColor.GRAY,
                "[CLOGGER] ",
                event.getSender().getName(),
                ":",
                event.getCommand()
        );
    }
}

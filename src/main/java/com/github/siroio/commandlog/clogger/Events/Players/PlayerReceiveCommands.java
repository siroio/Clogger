package com.github.siroio.commandlog.clogger.Events.Players;

import com.github.siroio.commandlog.clogger.Utils.Broadcast;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerReceiveCommands implements Listener {

    // プレイヤーが実行したコマンドが処理される前に呼び出される。
    @EventHandler
    public void ReceiveChatCommand(PlayerCommandPreprocessEvent event) {
        Broadcast.sendMessage(
                ChatColor.GRAY,
                "[CLOGGER] ",
                event.getPlayer().getName(),
                ":",
                event.getMessage()
        );
    }
}

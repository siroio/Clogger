package com.github.siroio.commandlog.clogger.Events.Players;


import com.github.siroio.commandlog.clogger.Events.Manager.EventRegister;
import com.github.siroio.commandlog.clogger.Main;
import com.github.siroio.commandlog.clogger.Utils.Broadcast;
import com.github.siroio.commandlog.clogger.Utils.Logger;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ReceiveCommands implements Listener {

    // プレイヤーが実行したコマンドが処理される前に呼び出される。
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Broadcast.sendMessage(
                ChatColor.GRAY,
                "[CLOGGER] ",
                event.getPlayer().getName(),
                ":",
                event.getMessage()
        );
    }
}

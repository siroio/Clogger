package com.github.siroio.commandlog.clogger.Events.PlayerEvents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class UnknownCommandMessage implements Listener {

    @EventHandler
    public void onMessage(PlayerCommandPreprocessEvent event) {
        // Unknown Command メッセージの無効化
        if(!event.getPlayer().isOp()) return;

        String msg = event.getMessage();
        String[] args = msg.split(" ");

        if(!(Bukkit.getHelpMap().getHelpTopic(args[0]) == null)) return;
        event.setCancelled(true);
    }
}

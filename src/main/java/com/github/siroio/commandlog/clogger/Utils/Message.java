package com.github.siroio.commandlog.clogger.Utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class Message {

    // 色を指定しない場合
    public static void sendMessage(Player player, String... message) {
        sendMessage(player, ChatColor.WHITE, message);
    }

    // 色を指定してプレイヤーへメッセージを送信
    public static void sendMessage(Player player, ChatColor chatColor, String... message) {
        StringBuilder sb = new StringBuilder();
        sb.append(chatColor);
        for(String msg : message) sb.append(msg);
        player.sendMessage(sb.toString());
        sb.setLength(0);
    }
}

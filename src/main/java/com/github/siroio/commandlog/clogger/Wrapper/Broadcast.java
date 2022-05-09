package com.github.siroio.commandlog.clogger.Wrapper;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;


public class Broadcast {

    // 権限関係なくメッセージを送信
    public static void sendMessage(String... messages) {
        sendMessage(ChatColor.WHITE, false, messages);
    }

    // 色を変更可能
    public static void sendMessage(ChatColor color, String... messages) {
        sendMessage(color, false, messages);
    }

    // 色を指定しない場合
    public static void sendMessage(boolean op_only, String... messages) {
        sendMessage(ChatColor.WHITE, op_only, messages);
    }

    // opのみに出力するかを指定
    public static void sendMessage(ChatColor color, boolean op_only, String... messages) {
        StringBuilder sb = new StringBuilder();
        sb.append(color);
        for (String msg : messages) sb.append(msg);
        // 色を個別に設定
        if(op_only) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                if(player.isOp()) player.sendMessage(sb.toString());
            });
        }
        else Bukkit.broadcastMessage(sb.toString());
        sb.setLength(0);
    }
}

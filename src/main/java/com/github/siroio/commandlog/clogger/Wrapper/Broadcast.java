package com.github.siroio.commandlog.clogger.Wrapper;

import com.github.siroio.commandlog.clogger.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Server;

public class Broadcast {

    // Server Instance
    private static final Server server = Main.getInstance.getServer();

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
            server.getOnlinePlayers().forEach(player -> {
                if(player.isOp()) player.sendMessage(sb.toString());
            });
        }
        else server.broadcastMessage(sb.toString());
        sb.setLength(0);
    }
}

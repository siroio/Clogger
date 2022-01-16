package com.github.siroio.commandlog.clogger.Utils;

import com.github.siroio.commandlog.clogger.Main;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class Broadcast {

    private static final StringBuffer sb = new StringBuffer();
    private static final Server server = Main.getInstance.getServer();

    // 権限関係なくメッセージを送信
    public static void sendMessage(String... messages) {
        sendMessage(ChatColor.WHITE, false, messages);
    }

    // 色を変更可能
    public static void sendMessage(ChatColor color, String... messages) {
        sendMessage(color, false, messages);
    }

    public static void sendMessage(boolean op_only, String... messages) {
        sendMessage(ChatColor.WHITE, op_only, messages);
    }

    // opのみに出力するかを指定
    public static void sendMessage(ChatColor color, boolean op_only, String... messages) {
        sb.append(color);
        for (String msg : messages) sb.append(msg);

        if(op_only) {
            for (Player p : server.getOnlinePlayers()) {
                if(p.isOp()) p.sendMessage(sb.toString());
            }
        }
        else server.broadcastMessage(sb.toString());
        sb.setLength(0);
    }
}

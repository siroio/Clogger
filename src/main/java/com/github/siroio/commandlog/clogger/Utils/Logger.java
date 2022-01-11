package com.github.siroio.commandlog.clogger.Utils;


import com.github.siroio.commandlog.clogger.Main;
import org.bukkit.ChatColor;

import java.util.Arrays;

public final class Logger {

    // コンソールに文字列出力
    public static void print(final String messages) {
        StringBuilder sb = new StringBuilder();
        sb.append("[CLOGGER] ");
        sb.append(messages);
        Main.getInstance
            .getServer()
            .getConsoleSender()
            .sendMessage(sb.toString());
    }

    // 色付きで出力
    public static void print(ChatColor Color, final String messages) {
        StringBuilder sb = new StringBuilder();
        sb.append(Color);
        sb.append("[CLOGGER] ");
        sb.append(messages);
        Main.getInstance
                .getServer()
                .getConsoleSender()
                .sendMessage(sb.toString());
    }
}

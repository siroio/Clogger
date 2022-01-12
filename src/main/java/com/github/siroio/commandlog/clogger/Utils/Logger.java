package com.github.siroio.commandlog.clogger.Utils;


import com.github.siroio.commandlog.clogger.Main;
import org.bukkit.ChatColor;

import java.util.Arrays;

public final class Logger {

    private static StringBuffer sb;

    // コンソールに文字列出力
    public static void print(final String... messages) {
        sb = new StringBuffer();
        sb.append("[CLOGGER] ");
        for(String s : messages) sb.append(s);
        Main.getInstance
            .getServer()
            .getConsoleSender()
            .sendMessage(sb.toString());

        sb.setLength(0);
    }

    // 色付きで出力
    public static void print(ChatColor Color, final String... messages) {
        sb = new StringBuffer();
        sb.append(Color);
        sb.append("[CLOGGER] ");
        for(String s : messages) sb.append(s);
        Main.getInstance
                .getServer()
                .getConsoleSender()
                .sendMessage(sb.toString());
        sb.setLength(0);
    }
}

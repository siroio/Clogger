package com.github.siroio.commandlog.clogger.Utils;


import com.github.siroio.commandlog.clogger.Main;
import org.bukkit.ChatColor;

import java.util.Arrays;

public final class Logger {

    // コンソールに文字列出力
    public static void print(final String... messages) {
        StringBuffer sb = new StringBuffer();
        sb.append("[CLOGGER] ");
        for(String s : messages) sb.append(s);
        Main.getInstance
            .getServer()
            .getConsoleSender()
            .sendMessage(sb.toString());
    }

    // 色付きで出力
    public static void print(ChatColor Color, final String... messages) {
        StringBuffer sb = new StringBuffer();
        sb.append(Color);
        sb.append("[CLOGGER] ");
        for(String s : messages) sb.append(s);
        Main.getInstance
                .getServer()
                .getConsoleSender()
                .sendMessage(sb.toString());
    }
}

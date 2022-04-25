package com.github.siroio.commandlog.clogger.Wrapper;


import com.github.siroio.commandlog.clogger.Main;
import net.md_5.bungee.api.ChatColor;

public final class Logger {

    private static StringBuilder sb;

    // コンソールに文字列出力
    public static void print(final String... messages) {
        print(ChatColor.GRAY, messages);
    }

    // 色付きで出力
    public static void print(ChatColor Color, final String... messages) {
        sb = new StringBuilder();
        sb.append(Color);
        sb.append("[CLOG] ");
        for(String s : messages) sb.append(s);
        Main.getInstance
                .getServer()
                .getConsoleSender()
                .sendMessage(sb.toString());
        sb.setLength(0);
    }
}

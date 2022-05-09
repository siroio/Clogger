package com.github.siroio.commandlog.clogger.Wrapper;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BukkitColor {
    private static Map<String, ChatColor> colorMap = new HashMap(){{
        put("BLACK", ChatColor.BLACK);
        put("DARK_BLUE", ChatColor.DARK_BLUE);
        put("DARK_GREEN", ChatColor.DARK_GREEN);
        put("DARK_AQUA", ChatColor.DARK_AQUA);
        put("DARK_RED", ChatColor.DARK_RED);
        put("DARK_PURPLE", ChatColor.DARK_PURPLE);
        put("GOLD", ChatColor.GOLD);
        put("GRAY", ChatColor.GRAY);
        put("DARK_GRAY", ChatColor.DARK_GRAY);
        put("BLUE", ChatColor.BLUE);
        put("GREEN", ChatColor.GREEN);
        put("AQUA", ChatColor.AQUA);
        put("RED", ChatColor.RED);
        put("LIGHT_PURPLE", ChatColor.LIGHT_PURPLE);
        put("YELLOW", ChatColor.YELLOW);
        put("WHITE", ChatColor.WHITE);
        put("MAGIC", ChatColor.MAGIC);
    }};

    public static List<ChatColor> ToList() {
        return new ArrayList<>(colorMap.values());
    }

    public static List<String> ToStringList() {
        return new ArrayList<>(colorMap.keySet());
    }

    public static ChatColor getColor(String name) {
        return colorMap.get(name);
    }
}

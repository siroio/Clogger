package com.github.siroio.commandlog.clogger.Database;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerChatColor {
    private static HashMap<Player, ChatColor> playerColor;

    public PlayerChatColor() {
        playerColor = new HashMap<>();
    }

    public ChatColor getColor(Player player) {
        return playerColor.get(player);
    }

    public void UpdatePlayerColor(Player player, ChatColor color) {
        playerColor.replace(player, color);
    }
}

package com.github.siroio.commandlog.clogger.Beans;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerBeanManager {

    private static HashMap<Player, PlayerBean> PlayerList = new HashMap<>();

    public static void addPlayer(Player player, PlayerBean bean) {
        PlayerList.put(player, bean);
    }

    public static void removePlayer(Player player) {
        PlayerList.remove(player);
    }

    public static void setPlayerBean(Player player, PlayerBean bean) {
        if(PlayerList.containsKey(player)) PlayerList.replace(player, bean);
        else PlayerList.put(player, bean);

    }

    public static final PlayerBean getPlayerBean(Player player) {
        return PlayerList.get(player);
    }

    public static final HashMap<Player, PlayerBean> getPlayerList() {
        return PlayerList;
    }

    public static void clearPlayerList() {
        PlayerList.clear();
    }
}

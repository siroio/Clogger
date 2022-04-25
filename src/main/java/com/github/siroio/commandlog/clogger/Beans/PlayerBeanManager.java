package com.github.siroio.commandlog.clogger.Beans;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class PlayerBeanManager {

    // ビーンのハッシュマップ
    private static final HashMap<Player, PlayerBean> PlayerList = new HashMap<>();

    // 指定したプレイヤーをマップに追加
    public static void addPlayer(Player player, PlayerBean bean) {
        PlayerList.put(player, bean);
    }

    // 指定したプレイヤーをマップから除去
    public static void removePlayer(Player player) {
        PlayerList.remove(player);
    }

    public static void setPlayerBean(Player player, PlayerBean bean) {
        if(PlayerList.containsKey(player)) PlayerList.replace(player, bean);
        else PlayerList.put(player, bean);
    }

    public static PlayerBean getPlayerBean(Player player) {
        return PlayerList.get(player);
    }

    public static HashMap<Player, PlayerBean> getPlayerList() {
        return PlayerList;
    }

    public static void clearPlayerList() {
        PlayerList.clear();
    }

    public static boolean containPlayer(Player player) {
        return PlayerList.containsKey(player);
    }
}

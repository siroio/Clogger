package com.github.siroio.commandlog.clogger.Beans;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerBeanManager {

    private HashMap<Player, PlayerBean> PlayerList;

    public PlayerBeanManager() {
        PlayerList = new HashMap<>();
    }

    public void addPlayer(Player player, PlayerBean bean) {
        PlayerList.put(player, bean);
    }

    public void removePlayer(Player player) {
        PlayerList.remove(player);
    }

    public void setPlayerBean(Player player, PlayerBean bean) {
        PlayerList.replace(player, bean);
    }

    public final PlayerBean getPlayerBean(Player player) {
        return PlayerList.get(player);
    }

    public final HashMap<Player, PlayerBean> getPlayerList() {
        return PlayerList;
    }
}

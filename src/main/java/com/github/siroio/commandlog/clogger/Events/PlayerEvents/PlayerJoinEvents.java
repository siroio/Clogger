package com.github.siroio.commandlog.clogger.Events.PlayerEvents;

import com.github.siroio.commandlog.clogger.Beans.CommandBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEvents implements Listener {

    // プレイヤーがサーバー参加時に実行される。
    // プレヤーとコマンドのBeanを作成追加
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(PlayerBeanManager.containPlayer(event.getPlayer())) return;

        PlayerBean p_bean = new PlayerBean();
        p_bean.setName(player.getName());
        PlayerBeanManager.addPlayer(player, p_bean);
    }
}

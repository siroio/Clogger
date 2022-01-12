package com.github.siroio.commandlog.clogger.Events.PlayerEvents;

import com.github.siroio.commandlog.clogger.Beans.CommandBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    // プレイヤーがサーバー参加時に実行される。
    // プレヤーとコマンドのBeanを作成追加
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerBean p_bean = new PlayerBean();
        CommandBean c_bean = new CommandBean();

        p_bean.setName(player.getName());
        p_bean.setCommand(c_bean);
        Main.getInstance.getPbm().addPlayer(player, p_bean);
    }
}

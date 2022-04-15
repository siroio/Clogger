package com.github.siroio.commandlog.clogger.Events.PlayerEvents;

import com.github.siroio.commandlog.clogger.Beans.CommandBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import com.github.siroio.commandlog.clogger.Config.Config;
import com.github.siroio.commandlog.clogger.Utils.Broadcast;
import com.github.siroio.commandlog.clogger.Utils.DateGetter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerReceiveCommands implements Listener {

    // プレイヤーが実行したコマンドが処理される前に呼び出される。
    @EventHandler
    public void ReceiveChatCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        CommandBean command = new CommandBean();
        PlayerBean bean = new PlayerBean();

        // PlayerBeanが存在しているか確認
        if(PlayerBeanManager.containPlayer(player)) {
            bean = PlayerBeanManager.getPlayerBean(player);
        }

        // 使用されたコマンドの詳細をセット
        command.setCommand(event.getMessage());
        command.setDate(DateGetter.now());
        command.setLocation(player.getLocation());

        // プレイヤーにコマンドを追加
        bean.setName(player.getName());
        bean.addCommand(command);
        PlayerBeanManager.setPlayerBean(player, bean);

        sendMessage(player, event.getMessage());
    }

    public void sendMessage(Player player, String command) {
        Broadcast.sendMessage(
                ChatColor.of(Config.getColor()),
                true,
                "[CLOG] ",
                player.getName(),
                ":",
                command
        );
    }
}

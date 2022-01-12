package com.github.siroio.commandlog.clogger.Events.PlayerEvents;

import com.github.siroio.commandlog.clogger.Beans.CommandBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import com.github.siroio.commandlog.clogger.Main;
import com.github.siroio.commandlog.clogger.Utils.Broadcast;
import com.github.siroio.commandlog.clogger.Utils.DateGetter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerReceiveCommands implements Listener {

    public static PlayerBeanManager pbm =
            Main.getInstance.getPbm();

    // プレイヤーが実行したコマンドが処理される前に呼び出される。
    @EventHandler
    public void ReceiveChatCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        CommandBean command = new CommandBean();
        PlayerBean bean = pbm.getPlayerBean(player);

        // コマンドの追加
        command.setCommand(event.getMessage());
        command.setDate(DateGetter.now());

        // プレイヤーにコマンドを追加
        bean.setName(player.getName());
        bean.setCommand(command);

        sendMessage(player, event.getMessage());
    }

    public void sendMessage(Player executer, String command) {
        if(executer == null) return;
        Broadcast.sendMessage(
                ChatColor.GRAY,
                "[CLOGGER] ",
                executer.getPlayer().getName(),
                ":",
                command
        );
    }
}

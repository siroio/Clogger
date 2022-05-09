package com.github.siroio.commandlog.clogger.Commands.SubCmd;

import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicReference;

public class ShowLog implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String targetString = args.length < 2 ? null : args[1];
        AtomicReference<Player> targetPlayer = null;
        PlayerBean targetBean;


        // プレイヤービーンの中から指定したプレイヤーがいるのか探索
        PlayerBeanManager.getPlayerList().keySet().stream()
                .filter(player -> player.getName().equalsIgnoreCase(targetString))
                .forEach(targetPlayer::set);

        if(targetPlayer.get() == null) {
            ErrorMessage(sender);
            return false;
        }

        // 見つけたプレイヤーのビーンを取得
        targetBean = PlayerBeanManager.getPlayerBean(targetPlayer.get());
        sendLog(targetBean, sender);

        return false;
    }

    private void sendLog(PlayerBean target, CommandSender sender) {
        StringBuilder sb = new StringBuilder();
        sb.append(ChatColor.BLUE);
        sb.append("------------")
            .append(ChatColor.YELLOW)
            .append(target.getName())
            .append(ChatColor.BLUE)
            .append("--------------");
        sender.sendMessage(sb.toString());
        sb.setLength(0);
        for(var bean_ : target.getCommandList()) {
            sb.append(ChatColor.BLUE).append("コマンド: ")
              .append(ChatColor.WHITE).append(bean_.getCommand());
            sender.sendMessage(sb.toString());
            sb.setLength(0);

            sb.append(ChatColor.BLUE).append("日付時間: ")
              .append(ChatColor.WHITE).append(bean_.getDate());
            sender.sendMessage(sb.toString());
            sb.setLength(0);

            sb.append(ChatColor.BLUE).append("ワールド: ")
              .append(ChatColor.WHITE)
              .append(bean_.getLocation().getWorld().getName());
            sender.sendMessage(sb.toString());
            sb.setLength(0);

            sb.append(ChatColor.BLUE).append("座標: ")
              .append(ChatColor.WHITE)
              .append(" X: ").append((int) bean_.getLocation().getX())
              .append(" Y: ").append((int) bean_.getLocation().getY())
              .append(" Z: ").append((int) bean_.getLocation().getZ());
            sender.sendMessage(sb.toString());
            sb.setLength(0);
        }
    }

    private void ErrorMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.RED+"指定したプレイヤーが見つからないか、プレイヤーが指定されていません。");
    }
}

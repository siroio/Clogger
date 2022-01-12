package com.github.siroio.commandlog.clogger.Commands;

import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))  return false;

        if(!command.getName().equalsIgnoreCase("clogger")) return false;

        Player player = ((Player) sender).getPlayer();
        HashMap<Player, PlayerBean> bean = PlayerBeanManager.getPlayerList();

        for(var o : bean.values()) {
            sender.sendMessage(o.getName() + ":" + o.getCommand().peek());
        }

        return false;
    }
}

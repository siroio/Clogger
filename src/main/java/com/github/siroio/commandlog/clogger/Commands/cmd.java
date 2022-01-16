package com.github.siroio.commandlog.clogger.Commands;

import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import com.github.siroio.commandlog.clogger.Inventory.GUI;
import com.github.siroio.commandlog.clogger.Inventory.InvGUIs.testGUI;
import com.github.siroio.commandlog.clogger.Main;
import com.github.siroio.commandlog.clogger.Utils.Broadcast;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class cmd implements CommandExecutor {

    private final Map<String, CommandExecutor> subCommands;
    private final String NO_ARGS = "NO ARGS";
    public cmd() {
        subCommands = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!command.getName().equalsIgnoreCase("clogger")) return false;
        Player player;
        if(sender instanceof Player) player = ((Player) sender).getPlayer();
        Player target = null;
        for(Player p : Main.getInstance.getServer().getOnlinePlayers()) {
            if(p.getName().equalsIgnoreCase(args[0])) target = p;
        }
        var pBean = PlayerBeanManager.getPlayerBean(target);

        Broadcast.sendMessage(true, "サイズ", String.valueOf(pBean.getCommand().size()));

        Broadcast.sendMessage(true, pBean.getName());
        pBean.getCommand().values().forEach((list) -> {
            Broadcast.sendMessage(true, list.getCommand());
            Broadcast.sendMessage(true,list.getDate());
            Broadcast.sendMessage(true,
                   "X:" + ((int) list.getLocation().getX()) + ":" +
                   "Y:" + ((int) list.getLocation().getY()) + ":" +
                   "Z:" + ((int) list.getLocation().getZ())
            );
        });

        Broadcast.sendMessage("c 5");
        return false;
    }
}

package com.github.siroio.commandlog.clogger.Commands;

import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBeanManager;
import com.github.siroio.commandlog.clogger.Inventory.GUI;
import com.github.siroio.commandlog.clogger.Inventory.InvGUIs.testGUI;
import com.github.siroio.commandlog.clogger.Main;
import com.github.siroio.commandlog.clogger.Utils.Broadcast;
import org.bukkit.ChatColor;
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
        Player player = null;
        if(sender instanceof Player) player = ((Player) sender).getPlayer();


        if(player != null && player.isOp() && args[0].equalsIgnoreCase("test")) {
            GUI gui = new testGUI();
            player.openInventory(gui.getInventory());
            return true;
        }

        Player target = null;
        for(Player p : Main.getInstance.getServer().getOnlinePlayers()) {
            if(p.getName().equalsIgnoreCase(args[0])) target = p;
        }

        if(target == null) return false;

        var pBean = PlayerBeanManager.getPlayerBean(target);
        target.sendMessage(pBean.getCommandList().size() +"");
        pBean.getCommandList().forEach((list)-> {
            Broadcast.sendMessage(ChatColor.AQUA, "------------", pBean.getName(), "--------------");
            Broadcast.sendMessage(true, "コマンド: ", list.getCommand());
            Broadcast.sendMessage(true, "日付: ", list.getDate());
            Broadcast.sendMessage(true,
                    "X:", String.valueOf(((int) list.getLocation().getX())), ", ",
                    "Y:", String.valueOf((int) list.getLocation().getY()) , ", " ,
                    "Z:", String.valueOf((int) list.getLocation().getZ())
            );
        });
        return false;
    }
}

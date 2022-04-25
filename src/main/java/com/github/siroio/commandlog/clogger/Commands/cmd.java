package com.github.siroio.commandlog.clogger.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class cmd implements CommandExecutor {

    private final Map<String, CommandExecutor> subCommands;
    private final String NO_ARGS = "NO ARGS";
    public cmd() {
        subCommands = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /*
        if(!command.getName().equalsIgnoreCase("clogger")) return false;
        Player player = null;
        if(sender instanceof Player) player = (Player) sender;

        if(args[0].equalsIgnoreCase("")) {
            player.sendMessage(ChatColor.RED + "指定したコマンドが存在しないか、プレイヤーが存在していません。");
            return true;
        }

        if(player != null && player.isOp() && args[0].equalsIgnoreCase("test")) {
            GUI gui = new testGUI();
            player.openInventory(gui.getInventory());
            return true;
        }

        Player target = null;
        for (Player player_ : PlayerBeanManager.getPlayerList().keySet()) {
            if(player_.getName().equalsIgnoreCase(args[0])) {
                target = player_;
                break;
            }
        }
        if(target == null) return false;
        var pBean = PlayerBeanManager.getPlayerBean(target);

        pBean.getCommandList().forEach((list)-> {
            Broadcast.sendMessage(ChatColor.AQUA, "------------", pBean.getName(), "--------------");
            Broadcast.sendMessage(true, "コマンド: ", list.getCommand());
            Broadcast.sendMessage(true, "日付: ", list.getDate());
            Broadcast.sendMessage(true,
                    "X:", String.valueOf((int) list.getLocation().getX()), ", ",
                               "Y:", String.valueOf((int) list.getLocation().getY()) , ", ",
                               "Z:", String.valueOf((int) list.getLocation().getZ())
            );
        });
        */
        return false;
    }
}

package com.github.siroio.commandlog.clogger.Commands.SubCmd;

import com.github.siroio.commandlog.clogger.Wrapper.Broadcast;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class myChatColor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "コンソールからは実行できません。");
            return false;
        }

        Broadcast.sendMessage(args[1]);
        return false;
    }
}

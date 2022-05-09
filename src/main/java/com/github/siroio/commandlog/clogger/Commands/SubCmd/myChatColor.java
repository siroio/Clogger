package com.github.siroio.commandlog.clogger.Commands.SubCmd;

import com.github.siroio.commandlog.clogger.Database.Database;
import com.github.siroio.commandlog.clogger.Wrapper.Broadcast;
import com.github.siroio.commandlog.clogger.Wrapper.BukkitColor;
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

        if(args.length < 1) {
            sender.sendMessage(ChatColor.RED + "色を指定してください！");
            return false;
        }
        Player player = (Player) sender;
        Database.upsertPlayer(player.getUniqueId().toString(), args[1]);
        return false;
    }
}

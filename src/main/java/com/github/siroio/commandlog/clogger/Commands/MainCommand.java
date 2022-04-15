package com.github.siroio.commandlog.clogger.Commands;

import com.github.siroio.commandlog.clogger.Commands.SubCmd.ShowLog;
import com.github.siroio.commandlog.clogger.Commands.SubCmd.test;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.*;

public class MainCommand implements CommandExecutor, TabCompleter {

    private final Map<String, CommandExecutor> subCommands;

    // 辞書にサブコマンドを登録
    public MainCommand() {
        Map<String, CommandExecutor> commands = new HashMap<>();
        commands.put("log", new ShowLog());
        commands.put("test", new test());
        subCommands = Collections.unmodifiableMap(commands);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 辞書内に実行されたコマンドが登録されているか確認
        if(args.length < 1) {
            ErrorMessage(sender);
            return false;
        }

        // 入ってきた引数を小文字に変換
        String arg0 = args[0].toLowerCase(Locale.ENGLISH);

        if(subCommands.containsKey(arg0)) {
            return subCommands.get(arg0).onCommand(sender, command, label, args);
        }
        else {
            ErrorMessage(sender);
            return false;
        }

    }

    // コマンド補完機能の実装
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if(args.length < 1) return null;

        String arg0 = args[0].toLowerCase(Locale.ENGLISH);
        if(arg0.equalsIgnoreCase("test")) return List.of("");
        if(arg0.equalsIgnoreCase("log")) return null;
        return Arrays.asList("log", "test");
    }

    // エラーメッセージ
    private void ErrorMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "コマンドが存在しないかコマンドが間違っています。");
    }
}

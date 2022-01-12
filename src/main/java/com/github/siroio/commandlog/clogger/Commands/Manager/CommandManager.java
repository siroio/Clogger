package com.github.siroio.commandlog.clogger.Commands.Manager;

import com.github.siroio.commandlog.clogger.Commands.cmd;
import org.bukkit.command.CommandExecutor;

import java.util.HashMap;
import java.util.Map;

public final class CommandManager {

    private static HashMap<String, CommandExecutor> subCommand = new HashMap<>();

    public static void subCommandRegister(String subCommand, CommandExecutor executor) {

    }
}

package com.github.siroio.commandlog.clogger.Beans;

import org.bukkit.Location;

import java.io.Serializable;
import java.util.Date;
import java.util.Queue;

public class PlayerBean implements Serializable {

    public PlayerBean(){}
    private String name;
    private Queue<CommandBean> commandList;

    // SETTER //
    public void setName(String name) {
        this.name = name;
    }

    public void setCommand(CommandBean command) {
        this.commandList.add(command);
    }

    // GETTER //
    public final String getName() {
        return name;
    }

    public final Queue<CommandBean> getCommand() {
        return commandList;
    }


}

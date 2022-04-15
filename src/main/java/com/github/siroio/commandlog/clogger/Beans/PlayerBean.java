package com.github.siroio.commandlog.clogger.Beans;

import java.io.Serializable;
import java.util.*;

public class PlayerBean implements Serializable {

    public PlayerBean(){}
    private String name;
    private static final Deque<CommandBean> commandList = new ArrayDeque<>();

    // SETTER //
    public void setName(String name) {
        this.name = name;
    }

    public void addCommand(CommandBean command) {
        if(commandList.size() >= 20)
            commandList.pollFirst();
        commandList.offerLast(command);
    }

    // GETTER //
    public final String getName() {
        return this.name;
    }

    public final Deque<CommandBean> getCommandList() {
        return commandList;
    }


}

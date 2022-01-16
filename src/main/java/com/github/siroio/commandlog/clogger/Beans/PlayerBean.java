package com.github.siroio.commandlog.clogger.Beans;

import com.github.siroio.commandlog.clogger.Utils.GENID;
import org.bukkit.Location;

import javax.xml.datatype.DatatypeFactory;
import java.io.Serializable;
import java.util.*;

public class PlayerBean implements Serializable {

    public PlayerBean(){}
    private String name;
    private HashMap<UUID, CommandBean> commandList = new HashMap();

    // SETTER //
    public void setName(String name) {
        this.name = name;
    }

    public void setCommand(CommandBean command) {
        this.commandList.put(GENID.getUUID(), command);
    }

    // GETTER //
    public final String getName() {
        return name;
    }

    public final HashMap<UUID, CommandBean> getCommand() {
        return commandList;
    }


}

package com.github.siroio.commandlog.clogger.Beans;

import org.bukkit.Location;

import java.io.Serializable;
import java.util.Date;
import java.util.Queue;

public class CommandBean implements Serializable {

    private String date;
    private String command;
    private Location location;

    // SETTER //
    public void setDate(String date) {
        this.date = date;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // GETTER //
    public final String getDate() {
        return date;
    }

    public final String getCommand() {
        return command;
    }

    public final Location getLocation() {
        return location;
    }
}
package com.github.siroio.commandlog.clogger.Database;

import com.github.siroio.commandlog.clogger.Config.Config;
import com.github.siroio.commandlog.clogger.Main;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;

public class Database {
    private final HikariDataSource hikari;
    private final File ConfigPath = Main.getInstance.getDataFolder();
    public String CreateTable = new StringBuilder().append("CREATE TABLE IF NOT EXISTS player_color (").append("`UUID` TEXT NOT NULL,").append("'Color' TEXT NOT NULL,").append("PRIMARY KEY('UUID')").append(");").toString();

    public Database() {
        String dbPath = ConfigPath + Config.getdbPath();
        (new File(dbPath)).getParentFile().mkdirs();
        System.out.println(new File(dbPath).getAbsolutePath());
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.sqlite.JDBC");
        config.setJdbcUrl("jdbc:sqlite:" + dbPath);
        config.setConnectionInitSql("SELECT 1");

        hikari = new HikariDataSource(config);
        init();
    }

    private void init() {
        try (Connection conn = hikari.getConnection()) {
            Statement s = conn.createStatement();
            s.executeUpdate(CreateTable);
            s.close();
        }
        catch (SQLException e) {
            Main.getInstance.getLogger().log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void close() {
        if(hikari != null) hikari.close();
    }
}

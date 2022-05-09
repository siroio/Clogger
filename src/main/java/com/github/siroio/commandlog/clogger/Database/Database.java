package com.github.siroio.commandlog.clogger.Database;

import com.github.siroio.commandlog.clogger.Config.Config;
import com.github.siroio.commandlog.clogger.Main;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.sql.*;
import java.util.UUID;
import java.util.logging.Level;

public class Database {
    private static HikariDataSource hikari;
    private final File ConfigPath = Main.getInstance.getDataFolder();
    public static final String table_name = "player_color";
    public String CreateTable = new StringBuilder().append("CREATE TABLE IF NOT EXISTS ").append(table_name).append(" (`UUID` TEXT NOT NULL,").append("'Color' TEXT NOT NULL,").append("PRIMARY KEY('UUID')").append(");").toString();

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
            Bukkit.getLogger().log(Level.SEVERE, e.getMessage(), e);
        }
    }
    public static void searchPlayer(String uuid) {
        try (Connection conn = hikari.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + table_name + " WHERE UUID = ?;");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if(rs.wasNull()) {
                System.out.println("NULLだよ～");
            }
        }
        catch (SQLException e) {
            Bukkit.getLogger().log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static void upsertPlayer(String uuid, String Color) {
        try (Connection conn = hikari.getConnection()) {
            String SQL = "REPLACE INTO "+ table_name +" ( UUID, Color ) VALUES ( ?, ? );";
            try(PreparedStatement ps = conn.prepareStatement(SQL)) {
                ps.setString(1, uuid);
                ps.setString(2, Color);
            }
        }
        catch (SQLException e) {
            Bukkit.getLogger().log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void close() {
        if(hikari != null) hikari.close();
    }
}

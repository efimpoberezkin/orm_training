package com.epam.homework.orm.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.epam.homework.orm.ConstantsContainer.*;

public class DatabaseInitializer {

    private static final Logger log = Logger.getRootLogger();

    public static void initialize(boolean tryToDropBeforeInitializing) {
        Connection conn = null;
        Statement stmt = null;
        try {
            log.debug("Creating database...");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();

            if (tryToDropBeforeInitializing) {
                try {
                    String sql = "DROP DATABASE " + DB_NAME;
                    stmt.executeUpdate(sql);
                } catch (SQLException e) { // ignore
                }
            }

            String sql = "CREATE DATABASE " + DB_NAME;
            stmt.executeUpdate(sql);
            log.debug("Database created");
        } catch (SQLException e) {
            log.error("Failed to create database", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log.error("Failed to close resources", e);
            }
        }
    }
}

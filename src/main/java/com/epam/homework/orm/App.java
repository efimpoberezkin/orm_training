package com.epam.homework.orm;

import com.epam.homework.orm.db.DatabaseInitializer;
import org.apache.log4j.Logger;

public class App {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final Logger log = Logger.getRootLogger();

    public static void main(String[] args) {
        deployDatabase();
    }

    private static void deployDatabase() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("Could not load driver class", e);
        }

        log.info("*** Initializing database ***");
        DatabaseInitializer.initialize(true);
    }
}

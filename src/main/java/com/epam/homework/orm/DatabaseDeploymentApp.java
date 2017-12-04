package com.epam.homework.orm;

import com.epam.homework.orm.config.DataSourceConfig;
import com.epam.homework.orm.config.PersistenceJPAConfig;
import com.epam.homework.orm.db.DatabaseInitializer;
import com.epam.homework.orm.db.DatabasePopulator;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DatabaseDeploymentApp {

    private static final Logger log = Logger.getRootLogger();

    public static void main(String[] args) {
        deployDatabase();
    }

    private static void deployDatabase() {
        log.info("*** Initializing database ***");
        DatabaseInitializer.initialize(true);

        log.info("*** Populating database with example data ***");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, PersistenceJPAConfig.class);
        DatabasePopulator.populateWithExampleData(context);
    }
}

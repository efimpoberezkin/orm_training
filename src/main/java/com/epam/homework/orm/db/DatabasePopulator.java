package com.epam.homework.orm.db;

import com.epam.homework.orm.db.domain.*;
import com.epam.homework.orm.db.service.AirplaneService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;

public class DatabasePopulator {

    private static final Logger log = Logger.getRootLogger();

    public static void populateWithExampleData(ApplicationContext context) {

        log.debug("Preparing example data...");

        // Passengers

        Passenger john = new Passenger("John", Gender.MALE);

        Passenger jack = new Passenger("Jack", Gender.MALE);

        Passenger jaime = new Passenger("Jaime", Gender.MALE);
        jaime.setPassengerContactInfo(new PassengerContactInfo("Jaime's email", "Jaime's phone"));

        Passenger logan = new Passenger("Logan", Gender.MALE);
        logan.setPassengerContactInfo(new PassengerContactInfo("Logan's email", "Logan's phone"));

        Passenger clark = new Passenger("Clark", Gender.MALE);

        Passenger joanne = new Passenger("Joanne", Gender.FEMALE);

        Passenger robin = new Passenger("Robin", Gender.FEMALE);
        robin.setPassengerContactInfo(new PassengerContactInfo("Robin's email", "Robin's phone"));

        Passenger anna = new Passenger("Anna", Gender.FEMALE);
        anna.setPassengerContactInfo(new PassengerContactInfo("Anna's email", "Anna's phone"));

        Passenger emily = new Passenger("Emily", Gender.FEMALE);
        emily.setPassengerContactInfo(new PassengerContactInfo("Emily's email", "Emily's phone"));

        // Planes and flights

        Airplane boeing737 = new Airplane("Boeing737", 150);
        {
            Flight flightAB = new Flight("A", "B", Timestamp.valueOf("2017-10-10 10:00:00"),
                    Timestamp.valueOf("2017-10-10 13:00:00"));
            {
                flightAB.addPassenger(john);
                flightAB.addPassenger(jack);
                flightAB.addPassenger(joanne);
            }
            boeing737.addFlight(flightAB);

            Flight flightBA = new Flight("B", "A", Timestamp.valueOf("2017-10-12 10:00:00"),
                    Timestamp.valueOf("2017-10-12 13:00:00"));
            {
                flightBA.addPassenger(jack);
                flightBA.addPassenger(jaime);
                flightBA.addPassenger(robin);
            }
            boeing737.addFlight(flightBA);

            Flight anotherFlightAB = new Flight("A", "B", Timestamp.valueOf("2017-10-14 10:00:00"),
                    Timestamp.valueOf("2017-10-14 13:00:00"));
            {
                anotherFlightAB.addPassenger(logan);
                anotherFlightAB.addPassenger(jack);
                anotherFlightAB.addPassenger(robin);
                anotherFlightAB.addPassenger(anna);
            }
            boeing737.addFlight(anotherFlightAB);

            Flight anotherFlightBA = new Flight("B", "A", Timestamp.valueOf("2017-10-16 10:00:00"),
                    Timestamp.valueOf("2017-10-16 13:00:00"));
            {
                anotherFlightBA.addPassenger(emily);
                anotherFlightBA.addPassenger(logan);
            }
            boeing737.addFlight(anotherFlightBA);
        }

        Airplane boeing777 = new Airplane("Boeing777", 200);
        {
            Flight flightAC = new Flight("A", "C", Timestamp.valueOf("2017-10-11 10:00:00"),
                    Timestamp.valueOf("2017-10-11 13:00:00"));
            {
                flightAC.addPassenger(emily);
                flightAC.addPassenger(clark);
                flightAC.addPassenger(joanne);
            }
            boeing777.addFlight(flightAC);

            Flight flightCD = new Flight("C", "D", Timestamp.valueOf("2017-10-13 10:00:00"),
                    Timestamp.valueOf("2017-10-13 13:00:00"));
            {
                flightCD.addPassenger(joanne);
                flightCD.addPassenger(anna);
            }
            boeing777.addFlight(flightCD);

            Flight flightDA = new Flight("D", "A", Timestamp.valueOf("2017-10-15 10:00:00"),
                    Timestamp.valueOf("2017-10-15 13:00:00"));
            {
                flightDA.addPassenger(robin);
                flightDA.addPassenger(logan);
                flightDA.addPassenger(john);
                flightDA.addPassenger(clark);
                flightDA.addPassenger(jaime);
            }
            boeing777.addFlight(flightDA);
        }

        log.debug("Populating database with prepared data...");

        AirplaneService airplaneService = context.getBean(AirplaneService.class);
        airplaneService.save(boeing737);

        log.debug("Database populated");
    }
}

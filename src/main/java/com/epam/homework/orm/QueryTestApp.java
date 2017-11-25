package com.epam.homework.orm;

import com.epam.homework.orm.db.QueryHelper;
import com.epam.homework.orm.domain.Passenger;

import java.util.List;

public class QueryTestApp {

    public static void main(String[] args) {

        long id = 7L;
        System.out.println("*** Finding passengers by flight id and ordering by name ***");

        System.out.println("\n--- PSQL ---");
        List<Passenger> flightPassengersPSQL = new QueryHelper().findPassengersByFlightOrderByNameJPQL(id);
        flightPassengersPSQL.forEach(System.out::println);

        System.out.println("\n--- Named Query ---");
        List<Passenger> flightPassengersNamed = new QueryHelper().findPassengersByFlightOrderByNameNamedQuery(id);
        flightPassengersNamed.forEach(System.out::println);

        System.out.println("\n--- Native Query ---");
        List<Passenger> flightPassengersNative = new QueryHelper().findPassengersByFlightOrderByNameNativeQuery(id);
        flightPassengersNative.forEach(System.out::println);

        System.out.println("\n--- Criteria API ---");
        List<Passenger> flightPassengersCriteria = new QueryHelper().findPassengersByFlightOrderByNameCriteriaAPI(id);
        flightPassengersCriteria.forEach(System.out::println);
    }
}

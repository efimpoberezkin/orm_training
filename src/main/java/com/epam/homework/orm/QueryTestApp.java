package com.epam.homework.orm;

import com.epam.homework.orm.db.QueryHelper;
import com.epam.homework.orm.domain.Passenger;

import java.util.List;

public class QueryTestApp {

    public static void main(String[] args) {

        System.out.println("*** Finding passengers by flight id and ordering by name ***");

        System.out.println("\n--- PSQL ---");
        List<Passenger> flightPassengersPSQL = new QueryHelper().findPassengersByFlightOrderByNameJPQL(7L);
        flightPassengersPSQL.forEach(System.out::println);

        System.out.println("\n--- Named Query ---");
        List<Passenger> flightPassengersNamed = new QueryHelper().findPassengersByFlightOrderByNameNamedQuery(7L);
        flightPassengersNamed.forEach(System.out::println);

        System.out.println("\n--- Native Query ---");
        List<Passenger> flightPassengersNative = new QueryHelper().findPassengersByFlightOrderByNameNativeQuery(7L);
        flightPassengersNative.forEach(System.out::println);

        System.out.println("\n--- Criteria API ---");
        List<Passenger> flightPassengersCriteria = new QueryHelper().findPassengersByFlightOrderByNameCriteriaAPI(7L);
        flightPassengersCriteria.forEach(System.out::println);
    }
}

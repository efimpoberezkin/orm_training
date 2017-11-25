package com.epam.homework.orm;

import com.epam.homework.orm.db.QueryHelper;
import com.epam.homework.orm.domain.Passenger;

import javax.persistence.Tuple;
import java.util.List;

public class QueryTestApp {

    public static void main(String[] args) {

        long id = 7L;
        System.out.println("*** Finding passengers by flight id and ordering by name ***");

        System.out.println("\n--- JPQL ---");
        List<Passenger> flightPassengersJPQL = new QueryHelper().findPassengersByFlightOrderByNameJPQL(id);
        flightPassengersJPQL.forEach(System.out::println);

        System.out.println("\n--- Named Query ---");
        List<Passenger> flightPassengersNamed = new QueryHelper().findPassengersByFlightOrderByNameNamedQuery(id);
        flightPassengersNamed.forEach(System.out::println);

        System.out.println("\n--- Native Query ---");
        List<Passenger> flightPassengersNative = new QueryHelper().findPassengersByFlightOrderByNameNativeQuery(id);
        flightPassengersNative.forEach(System.out::println);

        System.out.println("\n--- Criteria API ---");
        List<Passenger> flightPassengersCriteria = new QueryHelper().findPassengersByFlightOrderByNameCriteriaAPI(id);
        flightPassengersCriteria.forEach(System.out::println);

        int filter = 4;
        System.out.println("\n*** Finding flights with less than " + filter + " passengers ***");

        String format = "%s --- %s passengers";

        System.out.println("\n--- JPQL ---");
        List<Tuple> flightsJPQL = new QueryHelper().findFlightsWithLessThanFilterPassengersJPQL(filter);
        flightsJPQL.forEach((Tuple t) -> System.out.println(String.format(format, t.get(0), t.get(1))));

        System.out.println("\n--- Named Query ---");
        List<Tuple> flightsNamed = new QueryHelper().findFlightsWithLessThanFilterPassengersNamedQuery(filter);
        flightsNamed.forEach((Tuple t) -> System.out.println(String.format(format, t.get(0), t.get(1))));

        System.out.println("\n--- Native Query ---");
        List<Object[]> flightsNative = new QueryHelper().findFlightsWithLessThanFilterPassengersNativeQuery(filter);
        flightsNative.forEach((Object[] o) -> System.out.println(String.format(format, o[0], o[1])));

        System.out.println("\n--- Criteria API ---");
        List<Tuple> flightsCriteria = new QueryHelper().findFlightsWithLessThanFilterPassengersCriteriaAPI(filter);
        flightsCriteria.forEach((Tuple t) -> System.out.println(String.format(format, t.get(0), t.get(1))));
    }
}

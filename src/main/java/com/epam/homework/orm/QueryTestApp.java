package com.epam.homework.orm;

import com.epam.homework.orm.db.QueryHelper;
import com.epam.homework.orm.domain.Passenger;

import javax.persistence.Tuple;
import java.util.List;

public class QueryTestApp {

    public static void main(String[] args) {

        QueryHelper queryHelper = QueryHelper.getInstance();

        long id = 7L;
        System.out.println("*** Finding passengers by flight id and ordering by name ***");

        System.out.println("\n--- JPQL ---");
        List<Passenger> flightPassengersJPQL = queryHelper.findPassengersByFlightOrderByNameJPQL(id);
        flightPassengersJPQL.forEach(System.out::println);

        System.out.println("\n--- Named Query ---");
        List<Passenger> flightPassengersNamed = queryHelper.findPassengersByFlightOrderByNameNamedQuery(id);
        flightPassengersNamed.forEach(System.out::println);

        System.out.println("\n--- Native Query ---");
        List<Passenger> flightPassengersNative = queryHelper.findPassengersByFlightOrderByNameNativeQuery(id);
        flightPassengersNative.forEach(System.out::println);

        System.out.println("\n--- Criteria API ---");
        List<Passenger> flightPassengersCriteria = queryHelper.findPassengersByFlightOrderByNameCriteriaAPI(id);
        flightPassengersCriteria.forEach(System.out::println);

        int filter = 4;
        System.out.println("\n*** Finding flights with less than " + filter + " passengers ***");

        String format = "%s --- %s passengers";

        System.out.println("\n--- JPQL ---");
        List<Tuple> flightsJPQL = queryHelper.findFlightsWithLessThanFilterPassengersJPQL(filter);
        flightsJPQL.forEach((Tuple t) -> System.out.println(String.format(format, t.get(0), t.get(1))));

        System.out.println("\n--- Named Query ---");
        List<Tuple> flightsNamed = queryHelper.findFlightsWithLessThanFilterPassengersNamedQuery(filter);
        flightsNamed.forEach((Tuple t) -> System.out.println(String.format(format, t.get(0), t.get(1))));

        System.out.println("\n--- Native Query ---");
        List<Object[]> flightsNative = queryHelper.findFlightsWithLessThanFilterPassengersNativeQuery(filter);
        flightsNative.forEach((Object[] o) -> System.out.println(String.format(format, o[0], o[1])));

        System.out.println("\n--- Criteria API ---");
        List<Tuple> flightsCriteria = queryHelper.findFlightsWithLessThanFilterPassengersCriteriaAPI(filter);
        flightsCriteria.forEach((Tuple t) -> System.out.println(String.format(format, t.get(0), t.get(1))));

        id = 3L;
        System.out.println("\n*** Finding airplane details for flight ***");

        System.out.println("\n--- JPQL ---");
        Tuple flightAirplaneJPQL = queryHelper.findAirplaneDetailsForFlightJPQL(id);
        System.out.println(flightAirplaneJPQL.get(0) + " --- " + flightAirplaneJPQL.get(1));

        System.out.println("\n--- Named Query ---");
        Tuple flightAirplaneNamed = queryHelper.findAirplaneDetailsForFlightNamedQuery(id);
        System.out.println(flightAirplaneNamed.get(0) + " --- " + flightAirplaneNamed.get(1));

        System.out.println("\n--- Native Query ---");
        Object[] flightAirplaneNative = queryHelper.findAirplaneDetailsForFlightNativeQuery(id);
        System.out.println(flightAirplaneNative[0] + " --- " + flightAirplaneNative[1]);

        System.out.println("\n--- Criteria API ---");
        Tuple flightAirplaneCriteria = queryHelper.findAirplaneDetailsForFlightCriteriaAPI(id);
        System.out.println(flightAirplaneCriteria.get(0) + " --- " + flightAirplaneCriteria.get(1));
    }
}

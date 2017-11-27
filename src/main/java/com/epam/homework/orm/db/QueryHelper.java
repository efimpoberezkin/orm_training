package com.epam.homework.orm.db;

import com.epam.homework.orm.domain.Airplane;
import com.epam.homework.orm.domain.Flight;
import com.epam.homework.orm.domain.Passenger;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

public class QueryHelper {

    private static final String FIND_PASSENGERS_BY_FLIGHT_JPQL =
            "SELECT DISTINCT p FROM Passenger p "
                    + "INNER JOIN p.flights f "
                    + "WHERE f.id = :id "
                    + "ORDER BY p.name";

    private static final String FIND_FLIGHTS_WITH_LESS_THAN_FILTER_PASSENGERS_JPQL =
            "SELECT f, COUNT(p) "
                    + "FROM Flight f "
                    + "INNER JOIN f.passengers p "
                    + "GROUP BY f "
                    + "HAVING COUNT(p) < :filter";

    private static final String FIND_AIRPLANE_DETAILS_FOR_FLIGHT_JPQL =
            "SELECT f, a "
                    + "FROM Flight f "
                    + "INNER JOIN f.airplane a "
                    + "WHERE f.id = :id";

    private EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(FLIGHT_BOOKING_PERSISTENCE_UNIT);

    public static QueryHelper getInstance() {
        return new QueryHelper();
    }

    public List<Passenger> findPassengersByFlightOrderByNameJPQL(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers = entityManager.createQuery(FIND_PASSENGERS_BY_FLIGHT_JPQL, Passenger.class)
                .setParameter(ID, id)
                .getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Passenger> findPassengersByFlightOrderByNameNamedQuery(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers =
                entityManager.createNamedQuery(Passenger.FIND_PASSENGERS_BY_FLIGHT_NAMED_QUERY, Passenger.class)
                        .setParameter(ID, id)
                        .getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Passenger> findPassengersByFlightOrderByNameNativeQuery(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers =
                entityManager.createNamedQuery(Passenger.FIND_PASSENGERS_BY_FLIGHT_NATIVE_QUERY, Passenger.class)
                        .setParameter(ID, id)
                        .getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Passenger> findPassengersByFlightOrderByNameCriteriaAPI(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Passenger> criteriaQuery = criteriaBuilder.createQuery(Passenger.class);
        Root<Passenger> passenger = criteriaQuery.from(Passenger.class);
        Join<Passenger, Flight> flight = passenger.join(FLIGHTS);
        criteriaQuery.select(passenger).where(criteriaBuilder.equal(flight.get(ID), id)).distinct(true);
        criteriaQuery.orderBy(criteriaBuilder.asc(passenger.get(NAME)));
        List<Passenger> passengers = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Tuple> findFlightsWithLessThanFilterPassengersJPQL(int filter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Tuple> flights = entityManager.createQuery(FIND_FLIGHTS_WITH_LESS_THAN_FILTER_PASSENGERS_JPQL, Tuple.class)
                .setParameter(FILTER, (long) filter)
                .getResultList();

        entityManager.close();
        return flights;
    }

    public List<Tuple> findFlightsWithLessThanFilterPassengersNamedQuery(int filter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Tuple> flights =
                entityManager.createNamedQuery(Flight.FIND_FLIGHTS_WITH_LESS_THAN_FILTER_PASSENGERS_NAMED_QUERY, Tuple.class)
                        .setParameter(FILTER, (long) filter)
                        .getResultList();

        entityManager.close();
        return flights;
    }

    public List<Object[]> findFlightsWithLessThanFilterPassengersNativeQuery(int filter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Tuple> tuples =
                entityManager.createNamedQuery(Flight.FIND_FLIGHTS_WITH_LESS_THAN_FILTER_PASSENGERS_NATIVE_QUERY, Tuple.class)
                        .setParameter(FILTER, (long) filter)
                        .getResultList();

        List<Object[]> flights = new ArrayList<>();
        for (Tuple t : tuples) {
            flights.add(flightAndPassengerCountMapper(t));
        }

        entityManager.close();
        return flights;
    }

    public List<Tuple> findFlightsWithLessThanFilterPassengersCriteriaAPI(int filter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        Root<Flight> flight = criteriaQuery.from(Flight.class);
        Join<Flight, Passenger> passenger = flight.join(PASSENGERS);
        criteriaQuery.multiselect(flight, criteriaBuilder.count(passenger))
                .groupBy(flight).having(criteriaBuilder.lessThan(criteriaBuilder.count(passenger), (long) filter));
        List<Tuple> flights = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.close();
        return flights;
    }

    public Tuple findAirplaneDetailsForFlightJPQL(long flightId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Tuple result = entityManager.createQuery(FIND_AIRPLANE_DETAILS_FOR_FLIGHT_JPQL, Tuple.class)
                .setParameter(ID, flightId)
                .getSingleResult();

        entityManager.close();
        return result;
    }

    public Tuple findAirplaneDetailsForFlightNamedQuery(long flightId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Tuple result = entityManager.createNamedQuery(Flight.FIND_AIRPLANE_DETAILS_FOR_FLIGHT_NAMED_QUERY, Tuple.class)
                .setParameter(ID, flightId)
                .getSingleResult();

        entityManager.close();
        return result;
    }

    public Object[] findAirplaneDetailsForFlightNativeQuery(long flightId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Tuple result = entityManager.createNamedQuery(Flight.FIND_AIRPLANE_DETAILS_FOR_FLIGHT_NATIVE_QUERY, Tuple.class)
                .setParameter(ID, flightId)
                .getSingleResult();

        Object[] objArr = flightAndAirplaneMapper(result);

        entityManager.close();
        return objArr;
    }

    public Tuple findAirplaneDetailsForFlightCriteriaAPI(long flightId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        Root<Flight> flight = criteriaQuery.from(Flight.class);
        Join<Flight, Airplane> airplane = flight.join(AIRPLANE);
        criteriaQuery.multiselect(flight, airplane).where(criteriaBuilder.equal(flight.get(ID), flightId));
        Tuple result = entityManager.createQuery(criteriaQuery).getSingleResult();

        entityManager.close();
        return result;
    }

    private Object[] flightAndPassengerCountMapper(Tuple tuple) {
        Flight flight = new Flight();
        flight.setId(((BigInteger) tuple.get(0)).longValue());
        flight.setTo((String) tuple.get(1));
        flight.setFrom((String) tuple.get(2));
        flight.setDeparture((Timestamp) tuple.get(3));
        flight.setArrival((Timestamp) tuple.get(4));

        return new Object[]{flight, tuple.get(5)};
    }

    private Object[] flightAndAirplaneMapper(Tuple tuple) {
        Flight flight = new Flight();
        flight.setId(((BigInteger) tuple.get(0)).longValue());
        flight.setTo((String) tuple.get(1));
        flight.setFrom((String) tuple.get(2));
        flight.setDeparture((Timestamp) tuple.get(3));
        flight.setArrival((Timestamp) tuple.get(4));

        Airplane airplane = new Airplane();
        airplane.setId(((BigInteger) tuple.get(5)).longValue());
        airplane.setModelNumber((String) tuple.get(6));
        airplane.setCapacity((Integer) tuple.get(7));

        return new Object[]{flight, airplane};
    }
}

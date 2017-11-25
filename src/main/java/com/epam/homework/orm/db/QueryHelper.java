package com.epam.homework.orm.db;

import com.epam.homework.orm.domain.Flight;
import com.epam.homework.orm.domain.Passenger;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

public class QueryHelper {

    private static final String FIND_PASSENGERS_BY_FLIGHT_JPQL =
            "SELECT DISTINCT p FROM Passenger p "
                    + "INNER JOIN p.flights f "
                    + "WHERE f.id = :id "
                    + "ORDER BY p.name";

    private EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("flight_booking_unit");

    public List<Passenger> findPassengersByFlightOrderByNameJPQL(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers = entityManager.createQuery(FIND_PASSENGERS_BY_FLIGHT_JPQL)
                .setParameter(ID, id)
                .getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Passenger> findPassengersByFlightOrderByNameNamedQuery(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers = entityManager.createNamedQuery(Passenger.FIND_PASSENGERS_BY_FLIGHT_NAMED_QUERY)
                .setParameter(ID, id)
                .getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Passenger> findPassengersByFlightOrderByNameNativeQuery(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers = entityManager.createNamedQuery(Passenger.FIND_PASSENGERS_BY_FLIGHT_NATIVE_QUERY)
                .setParameter(1, id)
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
}

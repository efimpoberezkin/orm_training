package com.epam.homework.orm.db;

import com.epam.homework.orm.domain.Flight;
import com.epam.homework.orm.domain.Passenger;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class QueryHelper {

    private static final String FIND_PASSENGERS_BY_FLIGHT_PSQL =
            "SELECT DISTINCT p FROM Passenger p "
                    + "INNER JOIN p.flights f "
                    + "WHERE f.id = :id "
                    + "ORDER BY p.name";

    private EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("flight_booking_unit");

    public List<Passenger> findPassengersByFlightOrderByNameJPQL(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers = entityManager.createQuery(FIND_PASSENGERS_BY_FLIGHT_PSQL)
                .setParameter("id", id)
                .getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Passenger> findPassengersByFlightOrderByNameNamedQuery(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers = entityManager.createNamedQuery(Passenger.FIND_PASSENGERS_BY_FLIGHT_NAMED_QUERY)
                .setParameter("id", id)
                .getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Passenger> findPassengersByFlightOrderByNameNativeQuery(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers = entityManager.createNamedQuery(Passenger.FIND_PASSENGERS_BY_FLIGHT_NATIVE_QUERY)
                .setParameter(1, id)
                .getResultList();

        entityManager.close();
        return passengers;
    }

    public List<Passenger> findPassengersByFlightOrderByNameCriteriaAPI(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Passenger> criteriaQuery = criteriaBuilder.createQuery(Passenger.class);
        Root<Passenger> passenger = criteriaQuery.from(Passenger.class);
        Join<Passenger, Flight> flight = passenger.join("flights");
        criteriaQuery.select(passenger).where(criteriaBuilder.equal(flight.get("id"), id)).distinct(true);
        criteriaQuery.orderBy(criteriaBuilder.asc(passenger.get("name")));
        List<Passenger> passengers = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.close();
        return passengers;
    }
}

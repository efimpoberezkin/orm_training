package com.epam.homework.orm.db.dao;

import com.epam.homework.orm.domain.Flight;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    private EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("flight_booking_unit");

    @Override
    public void save(Flight flight) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(flight);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public List<Flight> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Flight> flights = entityManager.createNamedQuery(Flight.FIND_ALL_FLIGHTS).getResultList();

        entityManager.close();
        return flights;
    }

    @Override
    public Flight findBy(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Flight flight =
                (Flight) entityManager.createNamedQuery(Flight.FIND_FLIGHT_BY_ID)
                        .setParameter("id", id)
                        .getSingleResult();

        entityManager.close();
        return flight;
    }

    @Override
    public Flight update(Flight flight) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Flight mergedFlight = entityManager.merge(flight);
        entityManager.getTransaction().commit();

        entityManager.close();
        return mergedFlight;
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(findBy(id)));
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}

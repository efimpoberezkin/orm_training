package com.epam.homework.orm.db.dao;

import com.epam.homework.orm.domain.Flight;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    private static final String FIND_ALL_FLIGHTS = "SELECT f FROM Flight f";
    private static final String FIND_FLIGHT_BY_ID = "SELECT f FROM Flight f WHERE id = :id";

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
        return null;//entityManager.createQuery(FIND_ALL_FLIGHTS).getResultList();
    }

    @Override
    public Flight findBy(long id) {
        return null;//(Flight) entityManager.createQuery(FIND_FLIGHT_BY_ID).setParameter("id", id).getSingleResult();
    }

    @Override
    public Flight update(Flight flight) {
        return null;//entityManager.merge(flight);
    }

    @Override
    public void delete(long id) {
        //entityManager.remove(findBy(id));
    }
}

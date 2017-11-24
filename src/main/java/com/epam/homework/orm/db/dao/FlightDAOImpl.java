package com.epam.homework.orm.db.dao;

import com.epam.homework.orm.domain.Flight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    private static final String FIND_ALL_FLIGHTS = "SELECT f FROM Flight f";
    private static final String FIND_FLIGHT_BY_ID = "SELECT f FROM Flight f WHERE id = :id";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Flight flight) {
        entityManager.persist(flight);
    }

    @Override
    public List<Flight> findAll() {
        return entityManager.createQuery(FIND_ALL_FLIGHTS).getResultList();
    }

    @Override
    public Flight findBy(long id) {
        return (Flight) entityManager.createQuery(FIND_FLIGHT_BY_ID).setParameter("id", id).getSingleResult();
    }

    @Override
    public Flight update(Flight flight) {
        return entityManager.merge(flight);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findBy(id));
    }
}

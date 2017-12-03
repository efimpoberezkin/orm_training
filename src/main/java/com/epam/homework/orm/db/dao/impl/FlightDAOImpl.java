package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.db.dao.FlightDAO;
import com.epam.homework.orm.db.domain.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

@Repository
public class FlightDAOImpl implements FlightDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Flight save(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    @Override
    public List<Flight> findAll() {
        return entityManager.createNamedQuery(Flight.FIND_ALL_FLIGHTS, Flight.class).getResultList();
    }

    @Override
    public Flight findBy(long id) {
        return entityManager.createNamedQuery(Flight.FIND_FLIGHT_BY_ID, Flight.class)
                .setParameter(ID, id)
                .getSingleResult();
    }

    @Override
    public Flight update(Flight flight) {
        return entityManager.merge(flight);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.merge(findBy(id)));
    }
}

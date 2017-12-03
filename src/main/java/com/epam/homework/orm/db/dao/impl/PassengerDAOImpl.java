package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.db.dao.PassengerDAO;
import com.epam.homework.orm.db.domain.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Passenger save(Passenger passenger) {
        entityManager.persist(passenger);
        return passenger;
    }

    @Override
    public List<Passenger> findAll() {
        return entityManager.createNamedQuery(Passenger.FIND_ALL_PASSENGERS, Passenger.class).getResultList();
    }

    @Override
    public Passenger findBy(long id) {
        return entityManager.createNamedQuery(Passenger.FIND_PASSENGER_BY_ID, Passenger.class)
                .setParameter(ID, id)
                .getSingleResult();
    }

    @Override
    public Passenger update(Passenger passenger) {
        return entityManager.merge(passenger);
    }

    @Override
    public void delete(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }
}

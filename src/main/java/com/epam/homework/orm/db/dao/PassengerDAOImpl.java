package com.epam.homework.orm.db.dao;

import com.epam.homework.orm.domain.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

public class PassengerDAOImpl implements PassengerDAO {

    private EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(FLIGHT_BOOKING_PERSISTENCE_UNIT);

    @Override
    public void save(Passenger passenger) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(passenger);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public List<Passenger> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Passenger> passengers =
                entityManager.createNamedQuery(Passenger.FIND_ALL_PASSENGERS, Passenger.class).getResultList();

        entityManager.close();
        return passengers;
    }

    @Override
    public Passenger findBy(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Passenger passenger =
                entityManager.createNamedQuery(Passenger.FIND_PASSENGER_BY_ID, Passenger.class)
                        .setParameter(ID, id)
                        .getSingleResult();

        entityManager.close();
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Passenger mergedPassenger = entityManager.merge(passenger);
        entityManager.getTransaction().commit();

        entityManager.close();
        return mergedPassenger;
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }
}

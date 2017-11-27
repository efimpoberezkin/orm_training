package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.db.dao.AirplaneDAO;
import com.epam.homework.orm.domain.Airplane;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

public class AirplaneDAOImpl implements AirplaneDAO {

    private static final String FIND_ALL_AIRPLANES = "SELECT a FROM Airplane a";
    private static final String FIND_AIRPLANE_BY_ID = "SELECT a FROM Airplane a WHERE id = :id";

    private EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(FLIGHT_BOOKING_PERSISTENCE_UNIT);

    @Override
    public void save(Airplane airplane) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(airplane);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public List<Airplane> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Airplane> airplanes = entityManager.createQuery(FIND_ALL_AIRPLANES, Airplane.class).getResultList();

        entityManager.close();
        return airplanes;
    }

    @Override
    public Airplane findBy(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Airplane airplane =
                entityManager.createQuery(FIND_AIRPLANE_BY_ID, Airplane.class)
                        .setParameter(ID, id)
                        .getSingleResult();

        entityManager.close();
        return airplane;
    }

    @Override
    public Airplane update(Airplane airplane) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Airplane mergedAirplane = entityManager.merge(airplane);
        entityManager.getTransaction().commit();

        entityManager.close();
        return mergedAirplane;
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
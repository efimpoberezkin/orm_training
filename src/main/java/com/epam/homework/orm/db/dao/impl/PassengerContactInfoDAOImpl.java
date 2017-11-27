package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.db.dao.PassengerContactInfoDAO;
import com.epam.homework.orm.domain.PassengerContactInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

public class PassengerContactInfoDAOImpl implements PassengerContactInfoDAO {

    private EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(FLIGHT_BOOKING_PERSISTENCE_UNIT);

    @Override
    public void save(PassengerContactInfo passengerContactInfo) {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @Override
    public List<PassengerContactInfo> findAll() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public PassengerContactInfo findBy(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PassengerContactInfo> criteriaQuery = criteriaBuilder.createQuery(PassengerContactInfo.class);
        Root<PassengerContactInfo> info = criteriaQuery.from(PassengerContactInfo.class);
        criteriaQuery.select(info).where(criteriaBuilder.equal(info.get(ID), id));
        PassengerContactInfo passengerContactInfo = entityManager.createQuery(criteriaQuery).getSingleResult();

        entityManager.close();
        return passengerContactInfo;
    }

    @Override
    public PassengerContactInfo update(PassengerContactInfo passengerContactInfo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        PassengerContactInfo mergedPassengerContactInfo = entityManager.merge(passengerContactInfo);
        entityManager.getTransaction().commit();

        entityManager.close();
        return mergedPassengerContactInfo;
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

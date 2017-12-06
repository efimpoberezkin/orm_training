package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.db.dao.PassengerContactInfoDAO;
import com.epam.homework.orm.db.domain.PassengerContactInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

@Repository
public class PassengerContactInfoDAOImpl implements PassengerContactInfoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PassengerContactInfo save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @Override
    public List<PassengerContactInfo> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public PassengerContactInfo findBy(long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PassengerContactInfo> criteriaQuery = criteriaBuilder.createQuery(PassengerContactInfo.class);
        Root<PassengerContactInfo> info = criteriaQuery.from(PassengerContactInfo.class);
        criteriaQuery.select(info).where(criteriaBuilder.equal(info.get(PASSENGER_ID), id));
        PassengerContactInfo passengerContactInfo = entityManager.createQuery(criteriaQuery).getSingleResult();
        return passengerContactInfo;
    }

    @Override
    public PassengerContactInfo update(PassengerContactInfo passengerContactInfo) {
        return entityManager.merge(passengerContactInfo);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.merge(findBy(id)));
    }
}

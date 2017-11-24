package com.epam.homework.orm.db.dao;

import com.epam.homework.orm.domain.Airplane;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

public class AirplaneDAOImpl implements AirplaneDAO {

    private static final String FIND_ALL_AIRPLANES = "SELECT a FROM Airplane a";
    private static final String FIND_AIRPLANE_BY_ID = "SELECT a FROM Airplane WHERE id = :id";

    @PersistenceContext(unitName = "flight_booking_unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public void save(Airplane airplane) {
        entityManager.persist(airplane);
    }

    @Override
    public List<Airplane> findAll() {
        return entityManager.createQuery(FIND_ALL_AIRPLANES).getResultList();
    }

    @Override
    public Airplane findBy(long id) {
        return (Airplane) entityManager.createQuery(FIND_AIRPLANE_BY_ID).setParameter("id", id).getSingleResult();
    }

    @Override
    public Airplane update(Airplane airplane) {
        return entityManager.merge(airplane);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findBy(id));
    }
}

package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.db.dao.AirplaneDAO;
import com.epam.homework.orm.db.domain.Airplane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

@Repository
public class AirplaneDAOImpl implements AirplaneDAO {

    private static final String FIND_ALL_AIRPLANES = "SELECT a FROM Airplane a";
    private static final String FIND_AIRPLANE_BY_ID = "SELECT a FROM Airplane a WHERE id = :id";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Airplane save(Airplane airplane) {
        entityManager.persist(airplane);
        return airplane;
    }

    @Override
    public List<Airplane> findAll() {
        return entityManager.createQuery(FIND_ALL_AIRPLANES, Airplane.class).getResultList();
    }

    @Override
    public Airplane findBy(long id) {
        return entityManager.createQuery(FIND_AIRPLANE_BY_ID, Airplane.class)
                .setParameter(ID, id)
                .getSingleResult();
    }

    @Override
    public Airplane update(Airplane airplane) {
        return entityManager.merge(airplane);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.merge(findBy(id)));
    }
}

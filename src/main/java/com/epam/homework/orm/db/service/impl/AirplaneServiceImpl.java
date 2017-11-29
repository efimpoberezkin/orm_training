package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.impl.AirplaneDAOImpl;
import com.epam.homework.orm.db.service.AirplaneService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.domain.Airplane;

import javax.persistence.NoResultException;
import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {

    @Override
    public Airplane save(Airplane airplane) {
        return new AirplaneDAOImpl().save(airplane);
    }

    @Override
    public List<Airplane> findAll() {
        return new AirplaneDAOImpl().findAll();
    }

    @Override
    public Airplane findBy(long id) throws ServiceException {
        try {
            return new AirplaneDAOImpl().findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find airplane by id " + id, e);
        }
    }

    @Override
    public Airplane update(Airplane airplane) {
        return new AirplaneDAOImpl().update(airplane);
    }

    @Override
    public void delete(long id) throws ServiceException {
        try {
            new AirplaneDAOImpl().delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find airplane by id " + id, e);
        }
    }
}

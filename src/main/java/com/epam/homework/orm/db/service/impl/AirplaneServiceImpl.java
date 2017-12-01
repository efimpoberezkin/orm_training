package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.DAO;
import com.epam.homework.orm.db.dao.impl.AirplaneDAOImpl;
import com.epam.homework.orm.db.service.AirplaneService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.domain.Airplane;

import javax.persistence.NoResultException;
import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {

    private final DAO<Airplane> airplaneDAO = new AirplaneDAOImpl();

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneDAO.save(airplane);
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneDAO.findAll();
    }

    @Override
    public Airplane findBy(long id) throws ServiceException {
        try {
            return airplaneDAO.findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find airplane by id " + id, e);
        }
    }

    @Override
    public Airplane update(Airplane airplane) {
        return airplaneDAO.update(airplane);
    }

    @Override
    public void delete(long id) throws ServiceException {
        try {
            airplaneDAO.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find airplane by id " + id, e);
        }
    }
}

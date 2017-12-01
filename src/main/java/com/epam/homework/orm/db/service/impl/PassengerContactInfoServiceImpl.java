package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.DAO;
import com.epam.homework.orm.db.dao.impl.PassengerContactInfoDAOImpl;
import com.epam.homework.orm.db.service.PassengerContactInfoService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.domain.PassengerContactInfo;

import javax.persistence.NoResultException;
import java.util.List;

public class PassengerContactInfoServiceImpl implements PassengerContactInfoService {

    private final DAO<PassengerContactInfo> passengerContactInfoDAO = new PassengerContactInfoDAOImpl();

    @Override
    public PassengerContactInfo save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @Override
    public List<PassengerContactInfo> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public PassengerContactInfo findBy(long id) throws ServiceException {
        try {
            return passengerContactInfoDAO.findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger contact info by id " + id, e);
        }
    }

    @Override
    public PassengerContactInfo update(PassengerContactInfo passengerContactInfo) {
        return passengerContactInfoDAO.update(passengerContactInfo);
    }

    @Override
    public void delete(long id) throws ServiceException {
        try {
            passengerContactInfoDAO.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger contact info by id " + id, e);
        }
    }
}

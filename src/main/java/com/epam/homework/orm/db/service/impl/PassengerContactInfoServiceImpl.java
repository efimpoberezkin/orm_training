package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.DAO;
import com.epam.homework.orm.db.service.PassengerContactInfoService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.domain.PassengerContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PassengerContactInfoServiceImpl implements PassengerContactInfoService {

    @Autowired
    private DAO<PassengerContactInfo> passengerContactInfoDAO;

    @Override
    @Transactional
    public PassengerContactInfo save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @Override
    @Transactional
    public List<PassengerContactInfo> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    @Transactional
    public PassengerContactInfo findBy(long id) throws ServiceException {
        try {
            return passengerContactInfoDAO.findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger contact info by id " + id, e);
        }
    }

    @Override
    @Transactional
    public PassengerContactInfo update(PassengerContactInfo passengerContactInfo) {
        return passengerContactInfoDAO.update(passengerContactInfo);
    }

    @Override
    @Transactional
    public void delete(long id) throws ServiceException {
        try {
            passengerContactInfoDAO.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger contact info by id " + id, e);
        }
    }
}

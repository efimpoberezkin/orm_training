package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.DAO;
import com.epam.homework.orm.db.service.PassengerService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.domain.Passenger;
import com.epam.homework.orm.db.domain.PassengerContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private DAO<Passenger> passengerDAO;

    @Override
    @Transactional
    public Passenger save(Passenger passenger) {
        return passengerDAO.save(passenger);
    }

    @Override
    @Transactional
    public List<Passenger> findAll() {
        return passengerDAO.findAll();
    }

    @Override
    @Transactional
    public Passenger findBy(long id) throws ServiceException {
        try {
            return passengerDAO.findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger by id " + id, e);
        }
    }

    @Override
    @Transactional
    public Passenger update(Passenger passenger) {
        return passengerDAO.update(passenger);
    }

    @Override
    @Transactional
    public void delete(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }

    @Override
    @Transactional
    public Passenger addContactInfoToPassenger(long passengerId, PassengerContactInfo info) throws ServiceException {
        try {
            Passenger passenger = passengerDAO.findBy(passengerId);
            passenger.setPassengerContactInfo(info);
            return passengerDAO.update(passenger);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to add contact info to passenger: could not find passenger by id " + passengerId, e);
        }
    }
}

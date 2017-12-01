package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.DAO;
import com.epam.homework.orm.db.dao.impl.PassengerDAOImpl;
import com.epam.homework.orm.db.service.PassengerService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.domain.Passenger;
import com.epam.homework.orm.domain.PassengerContactInfo;

import javax.persistence.NoResultException;
import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private final DAO<Passenger> passengerDAO = new PassengerDAOImpl();

    @Override
    public Passenger save(Passenger passenger) {
        return passengerDAO.save(passenger);
    }

    @Override
    public List<Passenger> findAll() {
        return passengerDAO.findAll();
    }

    @Override
    public Passenger findBy(long id) throws ServiceException {
        try {
            return passengerDAO.findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger by id " + id, e);
        }
    }

    @Override
    public Passenger update(Passenger passenger) {
        return passengerDAO.update(passenger);
    }

    @Override
    public void delete(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }

    //TODO make @Transactional after switching to Spring
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

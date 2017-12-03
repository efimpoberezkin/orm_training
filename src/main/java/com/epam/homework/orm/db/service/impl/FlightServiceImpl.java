package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.DAO;
import com.epam.homework.orm.db.service.FlightService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.domain.Flight;
import com.epam.homework.orm.db.domain.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private DAO<Flight> flightDAO;
    @Autowired
    private DAO<Passenger> passengerDAO;

    @Override
    @Transactional
    public Flight save(Flight flight) {
        return flightDAO.save(flight);
    }

    @Override
    @Transactional
    public List<Flight> findAll() {
        return flightDAO.findAll();
    }

    @Override
    @Transactional
    public Flight findBy(long id) throws ServiceException {
        try {
            return flightDAO.findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find flight by id " + id, e);
        }
    }

    @Override
    @Transactional
    public Flight update(Flight flight) {
        return flightDAO.update(flight);
    }

    @Override
    @Transactional
    public void delete(long id) throws ServiceException {
        try {
            flightDAO.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find flight by id " + id, e);
        }
    }

    @Override
    @Transactional
    public Flight addPassengerToFlight(long flightId, long passengerId) throws ServiceException {
        try {
            Flight flight = flightDAO.findBy(flightId);
            try {
                Passenger passenger = passengerDAO.findBy(passengerId);
                flight.addPassenger(passenger);
                return flightDAO.update(flight);
            } catch (NoResultException e) {
                throw new ServiceException("Failed to add passenger to flight: could not find passenger by id " + passengerId, e);
            }
        } catch (NoResultException e) {
            throw new ServiceException("Failed to add passenger to flight: could not find flight by id " + flightId, e);
        }
    }

    @Override
    @Transactional
    public void removePassengerFromFlight(long flightId, long passengerId) throws ServiceException {
        try {
            Flight flight = flightDAO.findBy(flightId);
            try {
                Passenger passenger = passengerDAO.findBy(passengerId);
                flight.removePassenger(passenger);
                flightDAO.update(flight);
            } catch (NoResultException e) {
                throw new ServiceException("Failed to remove passenger from flight: could not find passenger by id " + passengerId, e);
            }
        } catch (NoResultException e) {
            throw new ServiceException("Failed to remove passenger from flight: could not find flight by id " + flightId, e);
        }
    }
}

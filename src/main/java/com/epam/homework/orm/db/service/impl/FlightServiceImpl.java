package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.DAO;
import com.epam.homework.orm.db.dao.impl.FlightDAOImpl;
import com.epam.homework.orm.db.dao.impl.PassengerDAOImpl;
import com.epam.homework.orm.db.service.FlightService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.domain.Flight;
import com.epam.homework.orm.domain.Passenger;

import javax.persistence.NoResultException;
import java.util.List;

public class FlightServiceImpl implements FlightService {

    private final DAO<Flight> flightDAO = new FlightDAOImpl();

    @Override
    public Flight save(Flight flight) {
        return flightDAO.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightDAO.findAll();
    }

    @Override
    public Flight findBy(long id) throws ServiceException {
        try {
            return flightDAO.findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find flight by id " + id, e);
        }
    }

    @Override
    public Flight update(Flight flight) {
        return flightDAO.update(flight);
    }

    @Override

    public void delete(long id) throws ServiceException {
        try {
            flightDAO.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find flight by id " + id, e);
        }
    }

    //TODO make @Transactional after switching to Spring
    public Flight addPassengerToFlight(long flightId, long passengerId) throws ServiceException {
        try {
            Flight flight = flightDAO.findBy(flightId);
            try {
                Passenger passenger = new PassengerDAOImpl().findBy(passengerId);
                flight.addPassenger(passenger);
                return flightDAO.update(flight);
            } catch (NoResultException e) {
                throw new ServiceException("Failed to add passenger to flight: could not find passenger by id " + passengerId, e);
            }
        } catch (NoResultException e) {
            throw new ServiceException("Failed to add passenger to flight: could not find flight by id " + flightId, e);
        }
    }

    //TODO make @Transactional after switching to Spring
    public void removePassengerFromFlight(long flightId, long passengerId) throws ServiceException {
        try {
            Flight flight = flightDAO.findBy(flightId);
            try {
                Passenger passenger = new PassengerDAOImpl().findBy(passengerId);
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

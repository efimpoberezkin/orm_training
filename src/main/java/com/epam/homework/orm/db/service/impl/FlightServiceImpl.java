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

    @Override
    public void save(Flight flight) {
        new FlightDAOImpl().save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return new FlightDAOImpl().findAll();
    }

    @Override
    public Flight findBy(long id) throws ServiceException {
        try {
            return new FlightDAOImpl().findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find flight by id " + id, e);
        }
    }

    @Override
    public Flight update(Flight flight) {
        return new FlightDAOImpl().update(flight);
    }

    @Override
    public void delete(long id) throws ServiceException {
        try {
            new FlightDAOImpl().delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find flight by id " + id, e);
        }
    }

    //TODO make @Transactional after switching to Spring
    public void addPassengerToFlight(long flightId, long passengerId) throws ServiceException {
        try {
            DAO<Flight> flightDAO = new FlightDAOImpl();
            Flight flight = flightDAO.findBy(flightId);
            try {
                Passenger passenger = new PassengerDAOImpl().findBy(passengerId);
                flight.addPassenger(passenger);
                flightDAO.update(flight);
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
            DAO<Flight> flightDAO = new FlightDAOImpl();
            Flight flight = flightDAO.findBy(flightId);
            flight.getPassengers().removeIf(passenger -> passenger.getId() == passengerId);
            flightDAO.update(flight);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to add passenger to flight: could not find flight by id " + flightId, e);
        }
    }
}

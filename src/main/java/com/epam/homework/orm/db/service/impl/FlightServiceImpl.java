package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.impl.FlightDAOImpl;
import com.epam.homework.orm.db.service.FlightService;
import com.epam.homework.orm.domain.Flight;

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
    public Flight findBy(long id) {
        return new FlightDAOImpl().findBy(id);
    }

    @Override
    public Flight update(Flight flight) {
        return new FlightDAOImpl().update(flight);
    }

    @Override
    public void delete(long id) {
        new FlightDAOImpl().delete(id);
    }
}

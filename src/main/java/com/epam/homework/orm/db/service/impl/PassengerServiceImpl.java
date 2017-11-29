package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.impl.PassengerDAOImpl;
import com.epam.homework.orm.db.service.PassengerService;
import com.epam.homework.orm.domain.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    @Override
    public void save(Passenger passenger) {
        new PassengerDAOImpl().save(passenger);
    }

    @Override
    public List<Passenger> findAll() {
        return new PassengerDAOImpl().findAll();
    }

    @Override
    public Passenger findBy(long id) {
        return new PassengerDAOImpl().findBy(id);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return new PassengerDAOImpl().update(passenger);
    }

    @Override
    public void delete(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }
}

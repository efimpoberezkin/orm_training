package com.epam.homework.orm.db.service;

import com.epam.homework.orm.db.domain.Passenger;
import com.epam.homework.orm.db.domain.PassengerContactInfo;

import java.util.List;

public interface PassengerService extends DatabaseService<Passenger> {

    @Override
    Passenger save(Passenger passenger);

    @Override
    List<Passenger> findAll();

    @Override
    Passenger findBy(long id);

    @Override
    Passenger update(Passenger passenger);

    @Override
    void delete(long id) throws UnsupportedOperationException;

    Passenger addContactInfoToPassenger(long passengerId, PassengerContactInfo info);
}

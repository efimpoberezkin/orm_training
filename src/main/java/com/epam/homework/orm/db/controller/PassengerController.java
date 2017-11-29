package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.Passenger;

import java.util.List;

public interface PassengerController extends Controller<Passenger> {

    @Override
    void save(Passenger passenger);

    @Override
    List<Passenger> findAll();

    @Override
    Passenger findBy(long id);

    @Override
    Passenger update(Passenger passenger);

    @Override
    void delete(long id) throws UnsupportedOperationException;
}

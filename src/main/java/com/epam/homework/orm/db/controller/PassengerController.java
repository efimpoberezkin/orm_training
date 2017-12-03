package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.db.domain.Passenger;

import java.util.List;

public interface PassengerController extends Controller<Passenger> {

    @Override
    List<Passenger> getAll();

    @Override
    Passenger getById(long id);

    @Override
    Passenger add(Passenger passenger);

    @Override
    Passenger update(Passenger passenger);

    @Override
    void delete(long id) throws UnsupportedOperationException;
}

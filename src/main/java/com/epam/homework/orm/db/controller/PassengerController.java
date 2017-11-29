package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.Passenger;

import java.util.List;

public interface PassengerController extends Controller<Passenger> {

    @Override
    void add(Passenger passenger);

    @Override
    List<Passenger> getAll();

    @Override
    Passenger getById(long id);

    @Override
    Passenger update(Passenger passenger);

    @Override
    void delete(long id) throws UnsupportedOperationException;
}

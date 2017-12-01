package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.Passenger;

import javax.ws.rs.core.Response;
import java.util.List;

public interface PassengerController extends Controller<Passenger> {

    @Override
    List<Passenger> getAll();

    @Override
    Passenger getById(long id);

    @Override
    Response add(Passenger passenger);

    @Override
    Passenger update(Passenger passenger);

    @Override
    void delete(long id) throws UnsupportedOperationException;
}

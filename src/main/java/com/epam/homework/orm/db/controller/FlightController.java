package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.Flight;

import javax.ws.rs.core.Response;
import java.util.List;

public interface FlightController extends Controller<Flight> {

    @Override
    List<Flight> getAll();

    @Override
    Flight getById(long id);

    @Override
    Response add(Flight flight);

    @Override
    Flight update(Flight flight);

    @Override
    void delete(long id);
}

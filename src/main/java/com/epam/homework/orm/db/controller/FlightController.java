package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.Flight;

import java.util.List;

public interface FlightController extends Controller<Flight> {

    @Override
    void save(Flight flight);

    @Override
    List<Flight> findAll();

    @Override
    Flight findBy(long id);

    @Override
    Flight update(Flight flight);

    @Override
    void delete(long id);
}

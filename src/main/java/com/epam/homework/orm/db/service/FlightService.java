package com.epam.homework.orm.db.service;

import com.epam.homework.orm.domain.Flight;

import java.util.List;

public interface FlightService extends DatabaseService<Flight> {

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
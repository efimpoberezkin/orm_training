package com.epam.homework.orm.db.dao;

import com.epam.homework.orm.domain.Flight;

import java.util.List;

public interface FlightDAO extends DAO<Flight> {

    @Override
    Flight save(Flight flight);

    @Override
    List<Flight> findAll();

    @Override
    Flight findBy(long id);

    @Override
    Flight update(Flight flight);

    @Override
    void delete(long id);
}

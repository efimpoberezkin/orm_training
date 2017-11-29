package com.epam.homework.orm.db.service;

import com.epam.homework.orm.domain.Airplane;

import java.util.List;

public interface AirplaneService extends DatabaseService<Airplane> {

    @Override
    void save(Airplane airplane);

    @Override
    List<Airplane> findAll();

    @Override
    Airplane findBy(long id);

    @Override
    Airplane update(Airplane airplane);

    @Override
    void delete(long id);
}

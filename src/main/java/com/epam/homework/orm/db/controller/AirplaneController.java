package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.Airplane;

import java.util.List;

public interface AirplaneController extends Controller<Airplane> {

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

package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.db.domain.Airplane;

import java.util.List;

public interface AirplaneController extends Controller<Airplane> {

    @Override
    List<Airplane> getAll();

    @Override
    Airplane getById(long id);

    @Override
    Airplane add(Airplane airplane);

    @Override
    Airplane update(Airplane airplane);

    @Override
    void delete(long id);
}

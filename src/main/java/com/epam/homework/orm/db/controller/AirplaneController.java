package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.Airplane;

import javax.ws.rs.core.Response;
import java.util.List;

public interface AirplaneController extends Controller<Airplane> {

    @Override
    List<Airplane> getAll();

    @Override
    Airplane getById(long id);

    @Override
    Response add(Airplane airplane);

    @Override
    Airplane update(Airplane airplane);

    @Override
    void delete(long id);
}

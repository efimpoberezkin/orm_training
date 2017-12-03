package com.epam.homework.orm.db.dao;

import com.epam.homework.orm.db.domain.Airplane;

import java.util.List;

public interface AirplaneDAO extends DAO<Airplane> {

    @Override
    Airplane save(Airplane airplane);

    @Override
    List<Airplane> findAll();

    @Override
    Airplane findBy(long id);

    @Override
    Airplane update(Airplane airplane);

    @Override
    void delete(long id);
}

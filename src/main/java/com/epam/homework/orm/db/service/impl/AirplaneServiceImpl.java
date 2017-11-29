package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.impl.AirplaneDAOImpl;
import com.epam.homework.orm.db.service.AirplaneService;
import com.epam.homework.orm.domain.Airplane;

import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {

    @Override
    public void save(Airplane airplane) {
        new AirplaneDAOImpl().save(airplane);
    }

    @Override
    public List<Airplane> findAll() {
        return new AirplaneDAOImpl().findAll();
    }

    @Override
    public Airplane findBy(long id) {
        return new AirplaneDAOImpl().findBy(id);
    }

    @Override
    public Airplane update(Airplane airplane) {
        return new AirplaneDAOImpl().update(airplane);
    }

    @Override
    public void delete(long id) {
        new AirplaneDAOImpl().delete(id);
    }
}

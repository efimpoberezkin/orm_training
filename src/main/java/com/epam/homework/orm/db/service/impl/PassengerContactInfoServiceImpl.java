package com.epam.homework.orm.db.service.impl;

import com.epam.homework.orm.db.dao.impl.PassengerContactInfoDAOImpl;
import com.epam.homework.orm.db.service.PassengerContactInfoService;
import com.epam.homework.orm.domain.PassengerContactInfo;

import java.util.List;

public class PassengerContactInfoServiceImpl implements PassengerContactInfoService {

    @Override
    public void save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @Override
    public List<PassengerContactInfo> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public PassengerContactInfo findBy(long id) {
        return new PassengerContactInfoDAOImpl().findBy(id);
    }

    @Override
    public PassengerContactInfo update(PassengerContactInfo passengerContactInfo) {
        return new PassengerContactInfoDAOImpl().update(passengerContactInfo);
    }

    @Override
    public void delete(long id) {
        new PassengerContactInfoDAOImpl().delete(id);
    }
}

package com.epam.homework.orm.db.service;

import com.epam.homework.orm.db.domain.PassengerContactInfo;

import java.util.List;

public interface PassengerContactInfoService extends DatabaseService<PassengerContactInfo> {

    @Override
    PassengerContactInfo save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException;

    @Override
    List<PassengerContactInfo> findAll() throws UnsupportedOperationException;

    @Override
    PassengerContactInfo findBy(long id);

    @Override
    PassengerContactInfo update(PassengerContactInfo passengerContactInfo);

    @Override
    void delete(long id);
}

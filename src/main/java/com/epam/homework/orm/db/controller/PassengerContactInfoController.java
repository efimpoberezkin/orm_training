package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.PassengerContactInfo;

import java.util.List;

public interface PassengerContactInfoController extends Controller<PassengerContactInfo> {

    @Override
    void save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException;

    @Override
    List<PassengerContactInfo> findAll() throws UnsupportedOperationException;

    @Override
    PassengerContactInfo findBy(long id);

    @Override
    PassengerContactInfo update(PassengerContactInfo passengerContactInfo);

    @Override
    void delete(long id);
}

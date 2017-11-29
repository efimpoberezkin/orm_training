package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.domain.PassengerContactInfo;

import java.util.List;

public interface PassengerContactInfoController extends Controller<PassengerContactInfo> {

    @Override
    void add(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException;

    @Override
    List<PassengerContactInfo> getAll() throws UnsupportedOperationException;

    @Override
    PassengerContactInfo getById(long id);

    @Override
    PassengerContactInfo update(PassengerContactInfo passengerContactInfo);

    @Override
    void delete(long id);
}

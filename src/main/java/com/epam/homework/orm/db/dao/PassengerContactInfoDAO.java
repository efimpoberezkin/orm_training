package com.epam.homework.orm.db.dao;

import com.epam.homework.orm.domain.PassengerContactInfo;

import java.util.List;

public interface PassengerContactInfoDAO extends DAO<PassengerContactInfo> {

    @Override
    void save(PassengerContactInfo passengerContactInfo);

    @Override
    List<PassengerContactInfo> findAll();

    @Override
    PassengerContactInfo findBy(long id);

    @Override
    PassengerContactInfo update(PassengerContactInfo passengerContactInfo);

    @Override
    void delete(long id);
}

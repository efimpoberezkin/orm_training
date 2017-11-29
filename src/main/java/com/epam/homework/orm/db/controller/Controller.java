package com.epam.homework.orm.db.controller;

import java.util.List;

public interface Controller<T> {

    void save(T object);

    List<T> findAll();

    T findBy(long id);

    T update(T object);

    void delete(long id);
}

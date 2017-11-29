package com.epam.homework.orm.db.controller;

import java.util.List;

public interface Controller<T> {

    List<T> getAll();

    T getById(long id);

    void add(T object);

    T update(T object);

    void delete(long id);
}

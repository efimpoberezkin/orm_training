package com.epam.homework.orm.db.controller;

import java.util.List;

public interface Controller<T> {

    void add(T object);

    List<T> getAll();

    T getById(long id);

    T update(T object);

    void delete(long id);
}

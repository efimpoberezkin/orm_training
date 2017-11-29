package com.epam.homework.orm.db.service;

import java.util.List;

public interface DatabaseService<T> {

    void save(T object);

    List<T> findAll();

    T findBy(long id);

    T update(T object);

    void delete(long id);
}

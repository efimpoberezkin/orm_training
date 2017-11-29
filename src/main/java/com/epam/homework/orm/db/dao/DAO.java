package com.epam.homework.orm.db.dao;

import java.util.List;

public interface DAO<T> {

    T save(T object);

    List<T> findAll();

    T findBy(long id);

    T update(T object);

    void delete(long id);
}

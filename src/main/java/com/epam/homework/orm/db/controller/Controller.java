package com.epam.homework.orm.db.controller;

import javax.ws.rs.core.Response;
import java.util.List;

public interface Controller<T> {

    List<T> getAll();

    T getById(long id);

    Response add(T object);

    T update(T object);

    void delete(long id);
}

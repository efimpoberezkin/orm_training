package com.epam.homework.orm.db.controller;

public class ControllerException extends RuntimeException {

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Exception e) {
        super(message, e);
    }
}

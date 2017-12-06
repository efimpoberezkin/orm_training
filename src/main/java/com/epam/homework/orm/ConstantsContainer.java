package com.epam.homework.orm;

public final class ConstantsContainer {

    // db specific
    public static final String URL = "jdbc:postgresql://localhost:5432/";
    public static final String DB_NAME = "flight_booking";

    public static final String USER = "postgres";
    public static final String PASSWORD = "123";

    // table names
    public static final String FLIGHT = "flight";
    public static final String AIRPLANE = "airplane";
    public static final String BOOKING = "booking";
    public static final String PASSENGER = "passenger";
    public static final String PASSENGER_CONTACT_INFO = "passenger_contact_info";

    // field names
    public static final String MODEL_NUMBER = "model_number";
    public static final String FROM_LOC = "fromloc";
    public static final String TO_LOC = "toloc";
    public static final String AIRPLANE_ID = "airplane_id";
    public static final String FLIGHT_ID = "flight_id";
    public static final String PASSENGER_ID = "passenger_id";

    // both entity and db
    public static final String ID = "id";

    private ConstantsContainer() {
    }
}

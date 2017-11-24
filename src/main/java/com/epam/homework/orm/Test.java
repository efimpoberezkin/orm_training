package com.epam.homework.orm;

import com.epam.homework.orm.db.dao.AirplaneDAOImpl;
import com.epam.homework.orm.db.dao.DAO;
import com.epam.homework.orm.db.dao.FlightDAOImpl;
import com.epam.homework.orm.domain.Airplane;
import com.epam.homework.orm.domain.Flight;

import java.sql.Timestamp;

public class Test {

    public static void main(String[] args) {
        Airplane airplane = new Airplane("Boeing", 200);
        Flight flight = new Flight("A", "B", Timestamp.valueOf("2015-10-10 10:10:10.0"),
                Timestamp.valueOf("2015-10-10 13:10:10.0"));
        airplane.addFlight(flight);

        DAO<Airplane> airplaneDAO = new AirplaneDAOImpl();

        airplaneDAO.save(airplane);
    }
}

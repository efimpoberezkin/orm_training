package com.epam.homework.orm;

import com.epam.homework.orm.db.dao.*;
import com.epam.homework.orm.domain.Airplane;
import com.epam.homework.orm.domain.Flight;
import com.epam.homework.orm.domain.Passenger;
import com.epam.homework.orm.domain.PassengerContactInfo;

import java.sql.Timestamp;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        DAO<Airplane> airplaneDAO = new AirplaneDAOImpl();
        DAO<Flight> flightDAO = new FlightDAOImpl();
        DAO<Passenger> passengerDAO = new PassengerDAOImpl();
        DAO<PassengerContactInfo> passengerContactInfoDAO = new PassengerContactInfoDAOImpl();

//        Airplane airplane = new Airplane("Boeing", 200);
//        Flight flight = new Flight("A", "B", Timestamp.valueOf("2015-10-10 10:10:10.0"),
//                Timestamp.valueOf("2015-10-10 13:10:10.0"));
//        airplane.addFlight(flight);

//        airplaneDAO.save(airplane);

//        List<Airplane> airplanes = airplaneDAO.findAll();
//        airplanes.forEach((Airplane a) -> System.out.println(a.getId() + ", " + a.getModelNumber() + ", " + a.getCapacity()));

//        Airplane loadedAirplane = airplaneDAO.findBy(1);
//        System.out.println(loadedAirplane.getId() + ", " + loadedAirplane.getModelNumber() + ", " + loadedAirplane.getCapacity());

//        loadedAirplane.setCapacity(300);
//        airplaneDAO.update(loadedAirplane);

//        airplaneDAO.delete(1);

//        flightDAO.save(flight);

//        List<Flight> flights = flightDAO.findAll();
//        flights.forEach((Flight f) -> System.out.println(f.getId() + ", " + f.getFrom() + ", " + f.getTo() + ", "
//                + f.getDeparture() + ", " + f.getArrival()));

//        Flight loadedFlight = flightDAO.findBy(1);
//        System.out.println(loadedFlight.getId() + ", " + loadedFlight.getFrom() + ", " + loadedFlight.getTo() + ", "
//                + loadedFlight.getDeparture() + ", " + loadedFlight.getArrival());
//
//        loadedFlight.setTo("C");
//        flightDAO.update(loadedFlight);

//        flightDAO.delete(1);
    }
}

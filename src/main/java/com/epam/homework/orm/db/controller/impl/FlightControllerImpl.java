package com.epam.homework.orm.db.controller.impl;

import com.epam.homework.orm.db.controller.ControllerException;
import com.epam.homework.orm.db.controller.FlightController;
import com.epam.homework.orm.db.service.FlightService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightControllerImpl implements FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    @Override
    public List<Flight> getAll() {
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public Flight getById(@PathVariable long id) throws ControllerException {
        try {
            return flightService.findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get flight", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public Flight add(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @PutMapping
    @Override
    public Flight update(@RequestBody Flight flight) {
        return flightService.update(flight);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable long id) throws ControllerException {
        try {
            flightService.delete(id);
        } catch (ServiceException e) { //ignore
        }
    }

    @PutMapping("/{flightid}/passengers/{passengerid}")
    public Flight addPassengerToFlight(
            @PathVariable("flightid") long flightId,
            @PathVariable("passengerid") long passengerId) throws ControllerException {
        try {
            return flightService.addPassengerToFlight(flightId, passengerId);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to add passenger to flight", e);
        }
    }

    @DeleteMapping("/{flightid}/passengers/{passengerid}")
    public void removePassengerFromFlight(
            @PathVariable("flightid") long flightId,
            @PathVariable("passengerid") long passengerId) throws ControllerException {
        try {
            flightService.removePassengerFromFlight(flightId, passengerId);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to remove passenger from flight", e);
        }
    }
}

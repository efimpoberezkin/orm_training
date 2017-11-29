package com.epam.homework.orm.db.controller.impl;

import com.epam.homework.orm.db.controller.ControllerException;
import com.epam.homework.orm.db.controller.FlightController;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.service.impl.FlightServiceImpl;
import com.epam.homework.orm.domain.Flight;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/flights")
public class FlightControllerImpl implements FlightController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Flight> getAll() {
        return new FlightServiceImpl().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Flight getById(@PathParam("id") long id) throws ControllerException {
        try {
            return new FlightServiceImpl().findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get flight", e);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Flight add(Flight flight) {
        return new FlightServiceImpl().save(flight);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Flight update(Flight flight) {
        return new FlightServiceImpl().update(flight);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void delete(@PathParam("id") long id) throws ControllerException {
        try {
            new FlightServiceImpl().delete(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to delete flight", e);
        }
    }

    @PUT
    @Path("/{flightid}/passengers/{passengerid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight addPassengerToFlight(
            @PathParam("flightid") long flightId,
            @PathParam("passengerid") long passengerId) throws ControllerException {
        try {
            return new FlightServiceImpl().addPassengerToFlight(flightId, passengerId);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to add passenger to flight", e);
        }
    }

    @DELETE
    @Path("/{flightid}/passengers/{passengerid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removePassengerFromFlight(
            @PathParam("flightid") long flightId,
            @PathParam("passengerid") long passengerId) throws ControllerException {
        try {
            new FlightServiceImpl().removePassengerFromFlight(flightId, passengerId);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to remove passenger from flight", e);
        }
    }
}

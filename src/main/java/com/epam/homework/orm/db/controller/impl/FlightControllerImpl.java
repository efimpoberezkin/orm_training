package com.epam.homework.orm.db.controller.impl;

import com.epam.homework.orm.db.controller.ControllerException;
import com.epam.homework.orm.db.controller.FlightController;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.service.impl.FlightServiceImpl;
import com.epam.homework.orm.domain.Flight;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/flights")
public class FlightControllerImpl implements FlightController {

    private final FlightServiceImpl flightService = new FlightServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Flight> getAll() {
        return flightService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Flight getById(@PathParam("id") long id) throws ControllerException {
        try {
            return flightService.findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get flight", e);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response add(Flight flight) {
        return Response.status(Response.Status.CREATED).entity(flightService.save(flight)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Flight update(Flight flight) {
        return flightService.update(flight);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void delete(@PathParam("id") long id) throws ControllerException {
        try {
            flightService.delete(id);
        } catch (ServiceException e) { //ignore
        }
    }

    @PUT
    @Path("/{flightid}/passengers/{passengerid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight addPassengerToFlight(
            @PathParam("flightid") long flightId,
            @PathParam("passengerid") long passengerId) throws ControllerException {
        try {
            return flightService.addPassengerToFlight(flightId, passengerId);
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
            flightService.removePassengerFromFlight(flightId, passengerId);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to remove passenger from flight", e);
        }
    }
}

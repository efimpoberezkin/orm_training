package com.epam.homework.orm.db.controller.impl;

import com.epam.homework.orm.db.service.impl.FlightServiceImpl;
import com.epam.homework.orm.domain.Flight;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/flights")
public class FlightControllerImpl {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> getFlights() {
        return new FlightServiceImpl().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight getFlightById(@PathParam("id") long id) {
        return new FlightServiceImpl().findBy(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addFlight(Flight flight) {
        new FlightServiceImpl().save(flight);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Flight updateFlight(Flight flight) {
        return new FlightServiceImpl().update(flight);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteFlight(@PathParam("id") long id) {
        new FlightServiceImpl().delete(id);
    }
}

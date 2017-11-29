package com.epam.homework.orm.db.controller;

import com.epam.homework.orm.db.service.impl.AirplaneServiceImpl;
import com.epam.homework.orm.domain.Airplane;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/airplanes")
public class AirplaneController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Airplane> getAirplanes() {
        return new AirplaneServiceImpl().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Airplane getAirplaneById(@PathParam("id") long id) {
        return new AirplaneServiceImpl().findBy(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addAirplane(Airplane airplane) {
        new AirplaneServiceImpl().save(airplane);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Airplane updateAirplane(Airplane airplane) {
        return new AirplaneServiceImpl().update(airplane);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("id") long id) {
        new AirplaneServiceImpl().delete(id);
    }
}

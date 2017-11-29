package com.epam.homework.orm.db.controller.impl;

import com.epam.homework.orm.db.controller.AirplaneController;
import com.epam.homework.orm.db.controller.ControllerException;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.service.impl.AirplaneServiceImpl;
import com.epam.homework.orm.domain.Airplane;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/airplanes")
public class AirplaneControllerImpl implements AirplaneController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Airplane> getAll() {
        return new AirplaneServiceImpl().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Airplane getById(@PathParam("id") long id) throws ControllerException {
        try {
            return new AirplaneServiceImpl().findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get airplane", e);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void add(Airplane airplane) {
        new AirplaneServiceImpl().save(airplane);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Airplane update(Airplane airplane) {
        return new AirplaneServiceImpl().update(airplane);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void delete(@PathParam("id") long id) throws ControllerException {
        try {
            new AirplaneServiceImpl().delete(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to delete airplane", e);
        }
    }
}

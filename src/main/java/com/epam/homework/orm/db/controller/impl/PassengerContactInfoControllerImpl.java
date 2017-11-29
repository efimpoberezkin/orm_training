package com.epam.homework.orm.db.controller.impl;

import com.epam.homework.orm.db.controller.ControllerException;
import com.epam.homework.orm.db.controller.PassengerContactInfoController;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.service.impl.PassengerContactInfoServiceImpl;
import com.epam.homework.orm.domain.PassengerContactInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/passengerinfo")
public class PassengerContactInfoControllerImpl implements PassengerContactInfoController {

    @Override
    public List<PassengerContactInfo> getAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public PassengerContactInfo getById(@PathParam("id") long id) throws ControllerException {
        try {
            return new PassengerContactInfoServiceImpl().findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get passenger info", e);
        }
    }

    @Override
    public void add(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public PassengerContactInfo update(PassengerContactInfo passengerContactInfo) {
        return new PassengerContactInfoServiceImpl().update(passengerContactInfo);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void delete(@PathParam("id") long id) throws ControllerException {
        try {
            new PassengerContactInfoServiceImpl().delete(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to delete passenger info", e);
        }
    }
}

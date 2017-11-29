package com.epam.homework.orm.db.controller.impl;

import com.epam.homework.orm.db.controller.ControllerException;
import com.epam.homework.orm.db.controller.PassengerController;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.service.impl.PassengerServiceImpl;
import com.epam.homework.orm.domain.Passenger;
import com.epam.homework.orm.domain.PassengerContactInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/passengers")
public class PassengerControllerImpl implements PassengerController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Passenger> getAll() {
        return new PassengerServiceImpl().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Passenger getById(@PathParam("id") long id) throws ControllerException {
        try {
            return new PassengerServiceImpl().findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get passenger", e);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Passenger add(Passenger passenger) {
        return new PassengerServiceImpl().save(passenger);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Passenger update(Passenger passenger) {
        return new PassengerServiceImpl().update(passenger);
    }

    @Override
    public void delete(@PathParam("id") long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }

    @PUT
    @Path("/{passengerid}/passengerinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Passenger addPassengerToFlight(
            @PathParam("passengerid") long passengerId,
            PassengerContactInfo passengerContactInfo) throws ControllerException {
        try {
            return new PassengerServiceImpl().addContactInfoToPassenger(passengerId, passengerContactInfo);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to add contact info to passenger", e);
        }
    }
}

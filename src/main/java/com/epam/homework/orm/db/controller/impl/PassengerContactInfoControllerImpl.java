package com.epam.homework.orm.db.controller.impl;

import com.epam.homework.orm.db.controller.ControllerException;
import com.epam.homework.orm.db.controller.PassengerContactInfoController;
import com.epam.homework.orm.db.service.DatabaseService;
import com.epam.homework.orm.db.service.ServiceException;
import com.epam.homework.orm.db.domain.PassengerContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengerinfo")
public class PassengerContactInfoControllerImpl implements PassengerContactInfoController {

    @Autowired
    private DatabaseService<PassengerContactInfo> passengerContactInfoService;

    @Override
    public List<PassengerContactInfo> getAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @GetMapping("/{id}")
    @Override
    public PassengerContactInfo getById(@PathVariable long id) throws ControllerException {
        try {
            return passengerContactInfoService.findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get passenger info", e);
        }
    }

    @Override
    public PassengerContactInfo add(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @PutMapping
    @Override
    public PassengerContactInfo update(@RequestBody PassengerContactInfo passengerContactInfo) {
        return passengerContactInfoService.update(passengerContactInfo);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable long id) throws ControllerException {
        try {
            passengerContactInfoService.delete(id);
        } catch (ServiceException e) { //ignore
        }
    }
}

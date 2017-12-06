package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.config.DataSourceConfig;
import com.epam.homework.orm.config.PersistenceJPAConfig;
import com.epam.homework.orm.db.dao.FlightDAO;
import com.epam.homework.orm.db.domain.Airplane;
import com.epam.homework.orm.db.domain.Flight;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, PersistenceJPAConfig.class})
@ActiveProfiles("dev")
public class FlightDAOImplTest {

    @Autowired
    FlightDAO flightDAO;

    @Test
    public void testFindBy() {
        Flight flight = flightDAO.findBy(3);

        Assert.assertEquals(3, flight.getId());
        Assert.assertEquals("B", flight.getFromLoc());
        Assert.assertEquals("A", flight.getToLoc());
        Assert.assertEquals(Timestamp.valueOf("2017-10-16 10:00:00"), flight.getDeparture());
        Assert.assertEquals(Timestamp.valueOf("2017-10-16 13:00:00"), flight.getArrival());

        Airplane flightAirplane = flight.getAirplane();

        Assert.assertEquals(1, flightAirplane.getId());
        Assert.assertEquals("Boeing737", flightAirplane.getModelNumber());
        Assert.assertEquals(150, flightAirplane.getCapacity());
    }
}

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
        Assert.assertEquals("C", flight.getFrom());
        Assert.assertEquals("D", flight.getTo());
        Assert.assertEquals(Timestamp.valueOf("2017-10-14 10:00:00"), flight.getDeparture());
        Assert.assertEquals(Timestamp.valueOf("2017-10-14 13:00:00"), flight.getArrival());

        Airplane flightAirplane = flight.getAirplane();

        Assert.assertEquals(2, flightAirplane.getId());
        Assert.assertEquals("Boeing777", flightAirplane.getModelNumber());
        Assert.assertEquals(200, flightAirplane.getCapacity());
    }
}

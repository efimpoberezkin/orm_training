package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.config.DataSourceConfig;
import com.epam.homework.orm.config.PersistenceJPAConfig;
import com.epam.homework.orm.db.dao.PassengerDAO;
import com.epam.homework.orm.db.domain.Gender;
import com.epam.homework.orm.db.domain.Passenger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, PersistenceJPAConfig.class})
@ActiveProfiles("dev")
public class PassengerDAOImplTest {

    @Autowired
    PassengerDAO passengerDAO;

    @Test
    public void testFindBy() {
        Passenger passenger = passengerDAO.findBy(4);

        Assert.assertEquals(4, passenger.getId());
        Assert.assertEquals("Jack", passenger.getName());
        Assert.assertEquals(Gender.MALE, passenger.getGender());
    }
}

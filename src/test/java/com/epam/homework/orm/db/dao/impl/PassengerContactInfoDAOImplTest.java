package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.config.DataSourceConfig;
import com.epam.homework.orm.config.PersistenceJPAConfig;
import com.epam.homework.orm.db.dao.PassengerContactInfoDAO;
import com.epam.homework.orm.db.domain.PassengerContactInfo;
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
public class PassengerContactInfoDAOImplTest {

    @Autowired
    PassengerContactInfoDAO passengerContactInfoDAO;

    @Test
    public void testFindBy() {
        PassengerContactInfo info = passengerContactInfoDAO.findBy(3);

        Assert.assertEquals(3, info.getPassengerId());
        Assert.assertEquals("Logans email", info.getEmail());
        Assert.assertEquals("Logans phone", info.getPhone());
    }
}

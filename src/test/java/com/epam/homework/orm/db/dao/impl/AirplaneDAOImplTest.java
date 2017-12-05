package com.epam.homework.orm.db.dao.impl;

import com.epam.homework.orm.config.DataSourceConfig;
import com.epam.homework.orm.config.PersistenceJPAConfig;
import com.epam.homework.orm.db.dao.AirplaneDAO;
import com.epam.homework.orm.db.domain.Airplane;
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
public class AirplaneDAOImplTest {

    @Autowired
    AirplaneDAO airplaneDAO;

    @Test
    public void testFindBy() {
        Airplane airplane = airplaneDAO.findBy(1);

        Assert.assertEquals(1, airplane.getId());
        Assert.assertEquals("Boeing737", airplane.getModelNumber());
        Assert.assertEquals(150, airplane.getCapacity());
    }
}

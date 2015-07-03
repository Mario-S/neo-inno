package org.inno.dao;

import org.inno.model.Technology;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author spindizzy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = TestConfig.class)
@Ignore
public class TechnologyRepositoryTest {
    
    @Autowired
    private GraphDatabaseService databaseService;

    @Autowired
    private TechnologyRepository classUnderTest;

    private Technology technology;

    @Before
    public void setUp() {
        technology = new Technology();
        technology.setName("test");

        technology = classUnderTest.save(technology);
    }

    @After
    public void tearDown() {
        classUnderTest.delete(technology);
        databaseService.shutdown();
    }

    @Test
    public void testFindAll() {
        Result<Technology> result = classUnderTest.findAll();
        assertTrue(result.iterator().hasNext());
    }

}

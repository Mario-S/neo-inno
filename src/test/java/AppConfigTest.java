/*
 * Created by Schuetze Consulting Informationssysteme AG, Berlin.
 */


import org.inno.AppConfig;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.neo4j.graphdb.GraphDatabaseService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


/**
 * @author schroeder
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class AppConfigTest {
    @Autowired
    private GraphDatabaseService databaseService;

    /**
     * Test of graphDatabaseService method, of class AppConfig.
     */
    @Test
    public void testGraphDatabaseService() {
        assertNotNull(databaseService);
    }
}

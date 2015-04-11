package org.inno.export;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.inno.model.Project;
import org.inno.model.Technology;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author spindizzy
 */
public class ExporterFactoryTest {
    
    private ExporterFactory instance;
    
    @Before
    public void setUp() {
        instance = new ExporterFactory();
    }

    /**
     * Test of createProjectExporter method, of class ExporterFactory.
     */
    @Test
    public void testCreateProjectExporter() {
        Exportable<List<Project>> result = instance.createProjectExporter();
        assertNotNull(result);
    }

    /**
     * Test of createTechnology method, of class ExporterFactory.
     */
    @Test
    public void testCreateTechnology() {
        Exportable<List<Technology>> result = instance.createTechnology();
        assertNotNull(result);
    }

    /**
     * Test of createRelationExporter method, of class ExporterFactory.
     */
    @Test
    public void testCreateRelationExporter() {
        Exportable<Map<Project, Set<Technology>>> result = instance.createRelationExporter();
        assertNotNull(result);
    }
    
}

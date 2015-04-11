package org.inno.export;

import java.util.Collection;
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
        Exportable<Collection<Project>> result = instance.createProjectExporter();
        assertNotNull(result);
    }

    /**
     * Test of createTechnology method, of class ExporterFactory.
     */
    @Test
    public void testCreateTechnologyExporter() {
        Exportable<Collection<Technology>> result = instance.createTechnologyExporter();
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

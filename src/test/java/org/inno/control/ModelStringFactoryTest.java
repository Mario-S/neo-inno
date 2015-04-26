/*
 * 
 */
package org.inno.control;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import java.util.Collection;
import java.util.HashMap;
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

public class ModelStringFactoryTest {
    
    private ModelStringFactory classUnderTest;
    
    private Context context;
    
    private Map<Project,Set<Technology>> relations;
    
    @Before
    public void setUp() {
        context = Context.Instance;
        
        classUnderTest = new ModelStringFactory(context.getLookup());

        Project project = new Project("test", "test");
        context.getContent().add(project);
        
        Technology tech = new Technology();
        tech.setName("test");
        context.getContent().add(tech);

        relations = new HashMap<>(1);
        relations.put(project, newHashSet(tech));
        context.getContent().add(relations);
    }

    /**
     * Test of create method, of class ModelStringFactory.
     */
    @Test
    public void testCreate() {
        String result = classUnderTest.create();
        assertNotNull(result);
    }
    
}

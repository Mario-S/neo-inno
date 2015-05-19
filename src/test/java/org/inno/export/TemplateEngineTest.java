package org.inno.export;

import static com.google.common.collect.Sets.newHashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.inno.model.Project;
import org.inno.model.Technology;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author spindizzy
 */
public class TemplateEngineTest {
    private TemplateEngine classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new TemplateEngine();
    }

    /**
     * Test of parse method, of class TemplateEngine.
     */
    @Test
    public void testParse_Project() {
        Project project = new Project();
        project.setName("test");
        project.setVersion("1.0.0");

        String result = classUnderTest.parse(project);
        assertEquals("create(p:Project{name:'test', version:'1.0.0'});", result);
    }

    /**
     * Test of parse method, of class TemplateEngine.
     */
    @Test
    public void testParse_Technology() {
        Technology tech = new Technology();
        tech.setName("test");
        tech.setLayer("none");
        tech.setVersion("1.0.0");
        tech.setGroupId("test");
        tech.setArtifactId("test");

        String result = classUnderTest.parse(tech);
        String expected =
            "create(tech:Technology{name:'test', layer:'none', version:'1.0.0', status:'Red', groupId:'test', artifactId:'test');";
        assertEquals(expected, result);
    }
    
    @Test
    public void testParse_Entry() {
        Project project = new Project();
        project.setName("project");
        Technology tech = new Technology();
        tech.setName("technology");
        Map<Project, Set<Technology>> map = new HashMap<>();
        map.put(project, newHashSet(tech));
        String result = classUnderTest.parse(map.entrySet().iterator().next());
        assertTrue(result.contains("name"));
    }
}

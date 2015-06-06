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

    private Technology technology;

    @Before
    public void setUp() {
        classUnderTest = new TemplateEngine();

        technology = new Technology();
        technology.setName("test");
        technology.setLayer("none");
        technology.setVersion("1.0.0");
        technology.setGroupId("test");
        technology.setArtifactId("test");
    }

    /**
     * Test of parse method, of class TemplateEngine.
     */
    @Test
    public void testParse_Project() {
        Project project = new Project();
        project.setName("test");
        project.setVersion("1.0.0");

        project.add(technology);

        String result = classUnderTest.parse(project);
        assertTrue(result.contains("create(p:Project{name:'test', version:'1.0.0'});"));
        assertTrue(result.contains("MATCH (p:Project {name:'test'}), (t:Technology {name:'test'}) CREATE (p)-[:USES]->(t);"));
    }

    /**
     * Test of parse method, of class TemplateEngine.
     */
    @Test
    public void testParse_Technology() {
        String result = classUnderTest.parse(technology);
        String expected
                = "create(tech:Technology{name:'test', layer:'none', version:'1.0.0', status:'Red', groupId:'test', artifactId:'test');";
        assertEquals(expected, result);
    }

}

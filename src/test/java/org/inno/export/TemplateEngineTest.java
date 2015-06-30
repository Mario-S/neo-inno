package org.inno.export;

import org.inno.model.Project;
import org.inno.model.State;
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
        technology.setStatus(State.Red);
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
        assertTrue(
            result.contains(
                "WITH test, test MATCH (p:Project {name:'test'}) CREATE (test)-[:USES]->(test) "));
        assertTrue(result.startsWith("create(test:Project{name:'test', version:'1.0.0'}) "));
    }

    /**
     * Test of parse method, of class TemplateEngine.
     */
    @Test
    public void testParse_Technology() {
        String result = classUnderTest.parse(technology);
        String expected =
            "create(test:Technology{name:'test', layer:'none', version:'1.0.0', status:'Red', groupId:'test', artifactId:'test'}) ";
        assertEquals(expected, result);
    }
}

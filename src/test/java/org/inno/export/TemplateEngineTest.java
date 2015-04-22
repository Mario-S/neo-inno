package org.inno.export;

import java.util.Optional;
import org.inno.model.Project;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
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
        String result = classUnderTest.parse(project);
        assertFalse(result.isEmpty());
        //TODO fix the test
        assertTrue(result.contains("test"));
    }
    
}

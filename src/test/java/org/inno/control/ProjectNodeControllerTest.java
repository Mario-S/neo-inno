package org.inno.control;

import java.util.ResourceBundle;
import org.controlsfx.validation.ValidationSupport;
import org.inno.model.Project;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author spindizzy
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectNodeControllerTest {
    
    @Mock
    private ValidationSupport validationSupport;

    private ProjectNodeController classUnderTest;
    
    @Mock
    private ResourceBundle bundle;
    
    @Before
    public void setUp() {
        classUnderTest = new ProjectNodeController(validationSupport){

            @Override
            void initialize(MessageFactory factory) {
                initialize(validationSupport, factory);
            }
        };
        
       classUnderTest.initialize(null, bundle);
    }

    /**
     * Test of getModel method, of class ProjectNodeController.
     */
    @Test
    public void testGetModel() {
        assertNotNull(classUnderTest.getModel());
    }

    /**
     * Test of onPostAdd method, of class ProjectNodeController.
     */
    @Test
    public void testOnPostAdd() {
        Project model = classUnderTest.getModel();
        classUnderTest.onPostAdd();
        assertFalse(model == classUnderTest.getModel());//a new model wa created
    }

}

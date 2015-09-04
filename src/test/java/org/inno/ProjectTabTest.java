package org.inno;

import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author spindizzy
 */
public class ProjectTabTest extends FxRobot{
    
    @BeforeClass
    public static void setUp() throws Exception {
        ApplicationTest.launch(ProjectTab.class);
    }

    @AfterClass
    public static void shutDown() throws TimeoutException {
        FxToolkit.cleanupStages();
    }
    
    /**
     * Test of getModel method, of class ProjectNodeController.
     */
    @Test
    public void testAddProject() throws InterruptedException {
        clickOn("#txtName");
        write("Test");
        clickOn("#txtVersion");
        write("Test");
        clickOn("#btnAddProj");
//        verifyThat("#colName", hasText("Test"));
    }

}

package org.inno;

import java.util.Set;
import java.util.concurrent.TimeoutException;
import javafx.scene.control.TableView;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import org.testfx.service.query.NodeQuery;

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

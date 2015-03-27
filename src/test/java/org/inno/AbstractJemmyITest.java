package org.inno;

import org.jemmy.fx.AppExecutor;
import org.jemmy.fx.SceneDock;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import javafx.application.Platform;
import javafx.scene.Node;
import static java.awt.GraphicsEnvironment.isHeadless;

/**
 * Parent class for all Jemmy tests which allows us to run several test in a
 * complete build.
 *
 * @author schroeder
 *
 */
public abstract class AbstractJemmyITest {

    private Node testContent;
    private SceneDock sceneDock;
    
    private static boolean jemmyStarted;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        if (!isHeadless() && ! jemmyStarted) {
            AppExecutor.executeNoBlock(JemmyTestApp.class);
            jemmyStarted = true;
        }
    }


    @Before
    public void setUp() {
        if (!isHeadless()) {
            sceneDock = new SceneDock();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    JemmyTestApp.addContent(getTestContent());
                }
            });
        }
    }

    @After
    public void shutDown() {
        if (!isHeadless()) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    JemmyTestApp.removeContent(getTestContent());
                }
            });
        }
    }

    private Node getTestContent() {
        if (testContent == null) {
            testContent = createTestContent();
        }
        return testContent;
    }

    /**
     * Return the wrapper to interact with the scene.
     *
     * @return {@link SceneDock}
     */
    protected SceneDock getSceneDock() {
        return sceneDock;
    }

    /**
     * This method should create the actual content for test purpose.
     *
     * @return the node for testing
     */
    protected abstract Node createTestContent();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.scag.inno;

import static java.awt.GraphicsEnvironment.isHeadless;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import org.jemmy.Point;
import org.jemmy.fx.TextDock;
import org.jemmy.fx.control.TabDock;
import org.jemmy.fx.control.TabPaneDock;
import org.jemmy.lookup.LookupCriteria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

/**
 *
 * @author schroeder
 */
public class GuiITest extends AbstractJemmyITest {

    @Override
    protected Node createTestContent() {
        Node node = null;

        try {
            Gui gui = new Gui();
            node = gui.getParent();
        } catch (IOException ex) {
        }
        return node;
    }

    private TabPaneDock getTabPaneDock() {
        return new TabPaneDock(getSceneDock().asParent(), "tabPane");
    }

    @Test
    public void testTabCount() {
        assumeTrue(!isHeadless());
        TabPaneDock tabPaneDock = getTabPaneDock();
        assertEquals(2, tabPaneDock.getTabs().size());
    }

    @Test
    public void testTechnolgieTab() {
        assumeTrue(!isHeadless());
        
        TabPaneDock tabPaneDock = getTabPaneDock();
        TabDock tabDock = new TabDock(tabPaneDock.asTabParent(), (LookupCriteria<Tab>) (Tab cntrl) -> cntrl.getId().equals("techTab"));
        tabDock.mouse().press();

        for (int i = 0; i < 6; i++) {
            TextDock txtDock = new TextDock(tabDock.asParent(), i);
            assertNotNull(txtDock);
            assertFalse((boolean) txtDock.isDisabled());
        }
    }

    @Test
    public void testProjektTab() {
        assumeTrue(!isHeadless());

        TabPaneDock tabPaneDock = getTabPaneDock();
        TabDock tabDock = new TabDock(tabPaneDock.asTabParent(), (LookupCriteria<Tab>) (Tab cntrl) -> cntrl.getId().equals("projTab"));
        tabDock.mouse().press();

        for (int i = 0; i < 2; i++) {
            TextDock txtDock = new TextDock(tabDock.asParent(), i);
            assertNotNull(txtDock);
            assertFalse((boolean) txtDock.isDisabled());
        }
    }

}

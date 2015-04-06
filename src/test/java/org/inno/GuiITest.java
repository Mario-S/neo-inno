/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inno;

import static java.awt.GraphicsEnvironment.isHeadless;
import java.io.IOException;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import org.jemmy.fx.TextDock;
import org.jemmy.fx.control.ControlDock;
import org.jemmy.fx.control.TabDock;
import org.jemmy.fx.control.TabPaneDock;
import org.jemmy.lookup.LookupCriteria;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

/**
 *
 * @author spindizzy
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

    private ControlDock getButton(String id) {
        return new ControlDock(getSceneDock().asParent(), id);
    }

    private TabDock selectTab(String id) {
        TabPaneDock tabPaneDock = getTabPaneDock();
        TabDock tabDock = new TabDock(tabPaneDock.asTabParent(), (LookupCriteria<Tab>) (Tab tab) -> tab.getId().equals(id));
        tabPaneDock.asSelectable().selector().select((Tab) tabDock.control());
        return tabDock;
    }

    @Test
    public void testStartup() {
        assumeTrue(!isHeadless());
        TabPaneDock tabPaneDock = getTabPaneDock();
        List<Tab> tabs = tabPaneDock.asSelectable().getStates();
        assertEquals(3, tabs.size());
        for (Tab t : tabs) {
            if (!t.isDisabled()) {
                System.out.println("Selecting " + t.getText());
                tabPaneDock.asSelectable().selector().select(t);
            }
        }

        ControlDock btnCreate = getButton("btnCreate");
        assertTrue((boolean) btnCreate.isDisabled());
    }

    @Test
    public void testTechnologyTab() {
        assumeTrue(!isHeadless());

        TabDock tabDock = selectTab("techTab");

        for (int i = 0; i < 6; i++) {
            TextDock txtDock = new TextDock(tabDock.asParent(), i);
            assertFalse((boolean) txtDock.isDisabled());
        }

    }

    @Test
    public void testProjektTab() {
        assumeTrue(!isHeadless());

        TabDock tabDock = selectTab("projTab");

        for (int i = 0; i < 2; i++) {
            TextDock txtDock = new TextDock(tabDock.asParent(), i);
            assertNotNull(txtDock);
            assertFalse((boolean) txtDock.isDisabled());
        }
    }

}

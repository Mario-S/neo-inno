package org.inno;

import java.net.URL;

/**
 *
 * @author spindizzy
 */
public final class ProjectTab extends AbstractTab {

    @Override
    protected URL getResource() {
        return getClass().getResource("tab_proj.fxml");
    }

}

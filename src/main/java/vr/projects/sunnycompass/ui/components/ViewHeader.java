package vr.projects.sunnycompass.ui.components;

import com.vaadin.flow.component.html.H2;
import vr.projects.sunnycompass.ui.HTMLConstants;

public class ViewHeader extends H2 {

    public ViewHeader(final String text) {
        super(text);
        this.setWidth(HTMLConstants.WIDTH_MAX_CONTENT);
    }
}

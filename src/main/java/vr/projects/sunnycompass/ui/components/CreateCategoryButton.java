package vr.projects.sunnycompass.ui.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import vr.projects.sunnycompass.ui.HTMLConstants;
import vr.projects.sunnycompass.ui.UIConstants;

public class CreateCategoryButton extends Button {

    public CreateCategoryButton() {
        super(UIConstants.BUTTON_CREATE_CATEGORY_TEXT);
        this.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.setWidth(HTMLConstants.WIDTH_MIN_CONTENT);
    }
}

package vr.projects.sunnycompass.ui.components;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import java.util.List;
import vr.projects.sunnycompass.berrytracker.CategoryResource;
import vr.projects.sunnycompass.ui.HTMLConstants;

public class CategoryGrid extends Grid<CategoryResource> {

    public CategoryGrid(final List<CategoryResource> data) {
        this.addColumn(CategoryResource::name).setHeader("Category");
        this.addColumn(CategoryResource::type).setHeader("Type");
        this.addColumn(CategoryResource::tags).setHeader("Tags");
        this.addColumn(CategoryResource::id).setVisible(false);

        this.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_ROW_STRIPES);
        this.setWidth(HTMLConstants.SIZE_100);
        this.getStyle().set(HTMLConstants.SC_FLEX_GROW, "0");
        this.setAllRowsVisible(true);

        this.setItems(data);
    }
}

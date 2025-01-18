package vr.projects.sunnycompass.ui.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.springframework.beans.factory.annotation.Autowired;
import vr.projects.sunnycompass.berrytracker.CategoryApi;
import vr.projects.sunnycompass.ui.HTMLConstants;
import vr.projects.sunnycompass.ui.UIConstants;
import vr.projects.sunnycompass.ui.components.CategoryGrid;
import vr.projects.sunnycompass.ui.components.CreateCategoryButton;
import vr.projects.sunnycompass.ui.components.ViewHeader;

@PageTitle("Categories")
@Route("categories")
public class CategoryView extends Composite<VerticalLayout> {

    private final CategoryApi categoryApi;

    public CategoryView(@Autowired final CategoryApi categoryApi) {

        this.categoryApi = categoryApi;

        // main layout components
        final var layoutRow = new HorizontalLayout();
        final var layoutColumn = new VerticalLayout();

        // vertical layout components
        final var header = new ViewHeader(UIConstants.VIEW_HEADER_CATEGORIES);
        final var button = new CreateCategoryButton();
        final var grid = new CategoryGrid(this.categoryApi.findAllCategories());

        // composite view styling
        this.getContent().setWidth(HTMLConstants.SIZE_100);
        this.getContent().getStyle().set(HTMLConstants.SC_FLEX_GROW, HTMLConstants.FG_VAL_1);

        // horizontal layout styling
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth(HTMLConstants.SIZE_100);
        layoutRow.getStyle().set(HTMLConstants.SC_FLEX_GROW, HTMLConstants.FG_VAL_1);

        // vertical layout styling
        layoutColumn.setAlignSelf(FlexComponent.Alignment.END, button);
        layoutColumn.setAlignSelf(FlexComponent.Alignment.CENTER, grid);
        layoutColumn.setWidth(HTMLConstants.SIZE_100);
        layoutColumn.getStyle().set(HTMLConstants.SC_FLEX_GROW, HTMLConstants.FG_VAL_1);

        // add components to the vertical layout
        layoutColumn.add(header);
        layoutColumn.add(button);
        layoutColumn.add(grid);

        // add components to the horizontal layout
        layoutRow.add(layoutColumn);

        // add components to the main composite view
        this.getContent().add(layoutRow);
    }
}

package vr.projects.sunnycompass.berrytracker.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vr.projects.sunnycompass.berrytracker.CategoryApi;
import vr.projects.sunnycompass.berrytracker.CategoryResource;
import vr.projects.sunnycompass.berrytracker.application.commands.CreateCategoryCommand;
import vr.projects.sunnycompass.berrytracker.core.cqrs.CommandDispatcher;
import vr.projects.sunnycompass.berrytracker.domain.Category;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryApi {

    private final CommandDispatcher dispatcher;

    @Override
    public CategoryResource create(final String name, final String type, final List<String> tags) {
        final var categoryEntity = (Category) this.dispatcher.dispatch(new CreateCategoryCommand(name, type, tags));
        return new CategoryResource(
                categoryEntity.getId().id(),
                categoryEntity.getName(),
                categoryEntity.getType().name(),
                categoryEntity.getTags().tagTexts());
    }
}

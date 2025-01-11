package vr.projects.sunnycompass.berrytracker.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vr.projects.sunnycompass.berrytracker.CategoryApi;
import vr.projects.sunnycompass.berrytracker.CategoryBountyResource;
import vr.projects.sunnycompass.berrytracker.CategoryResource;
import vr.projects.sunnycompass.berrytracker.application.commands.CreateCategoryBountyCommand;
import vr.projects.sunnycompass.berrytracker.application.commands.CreateCategoryCommand;
import vr.projects.sunnycompass.berrytracker.core.cqrs.CommandDispatcher;
import vr.projects.sunnycompass.berrytracker.domain.Bounty;
import vr.projects.sunnycompass.berrytracker.domain.Category;
import vr.projects.sunnycompass.berrytracker.infrastructure.QueryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryApi {

    private final CommandDispatcher dispatcher;
    private final QueryRepository queryRepository;

    @Override
    public CategoryResource create(final String name, final String type, final List<String> tags) {
        final var categoryEntity = (Category) this.dispatcher.dispatch(new CreateCategoryCommand(name, type, tags));
        return this.getCategoryResource(categoryEntity);
    }

    private CategoryResource getCategoryResource(final Category categoryEntity) {
        return new CategoryResource(
                categoryEntity.getId().id(),
                categoryEntity.getName(),
                categoryEntity.getType().name(),
                categoryEntity.getTags().tagTexts());
    }

    @Override
    public CategoryBountyResource addBounty(
            final String categoryName, final Long totalBerries, final Integer month, final Integer year) {
        final var command = new CreateCategoryBountyCommand(categoryName, totalBerries, month, year);
        final var categoryBounty = (Bounty) this.dispatcher.dispatch(command);
        return new CategoryBountyResource(
                categoryBounty.getId().id(),
                categoryBounty.getCategoryId().id(),
                categoryBounty.getTotalBerries(),
                categoryBounty.getMonth(),
                categoryBounty.getYear());
    }

    @Override
    public List<CategoryResource> findAllCategories() {
        return this.queryRepository.findAll().stream()
                .map(this::getCategoryResource)
                .toList();
    }
}

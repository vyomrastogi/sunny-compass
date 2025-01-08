package vr.projects.sunnycompass.berrytracker.application.handlers;

import org.springframework.stereotype.Component;
import vr.projects.sunnycompass.berrytracker.application.commands.CreateCategoryCommand;
import vr.projects.sunnycompass.berrytracker.core.cqrs.Command;
import vr.projects.sunnycompass.berrytracker.core.cqrs.CommandHandler;
import vr.projects.sunnycompass.berrytracker.domain.Category;
import vr.projects.sunnycompass.berrytracker.domain.CategoryType;
import vr.projects.sunnycompass.berrytracker.domain.Tags;
import vr.projects.sunnycompass.berrytracker.infrastructure.CategoryRepository;

@Component
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand, Category> {

    private final CategoryRepository categoryRepository;

    public CreateCategoryCommandHandler(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category handle(final CreateCategoryCommand command) {
        final var categoryEntity =
                Category.create(command.name(), CategoryType.valueOf(command.type()), new Tags(command.tags()));
        final var savedEntity = this.categoryRepository.save(categoryEntity);
        return savedEntity;
    }

    @Override
    public Class<? extends Command> getType() {
        return CreateCategoryCommand.class;
    }
}

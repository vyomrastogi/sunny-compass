package vr.projects.sunnycompass.berrytracker.application.handlers;

import org.springframework.stereotype.Component;
import vr.projects.sunnycompass.berrytracker.application.commands.CreateCategoryCommand;
import vr.projects.sunnycompass.berrytracker.core.cqrs.Command;
import vr.projects.sunnycompass.berrytracker.core.cqrs.CommandHandler;
import vr.projects.sunnycompass.berrytracker.domain.Category;
import vr.projects.sunnycompass.berrytracker.domain.CategoryType;
import vr.projects.sunnycompass.berrytracker.domain.Tags;

@Component
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand, Category> {

    @Override
    public Category handle(final CreateCategoryCommand command) {
        return Category.create(command.name(), CategoryType.valueOf(command.type()), new Tags(command.tags()));
    }

    @Override
    public Class<? extends Command> getType() {
        return CreateCategoryCommand.class;
    }
}

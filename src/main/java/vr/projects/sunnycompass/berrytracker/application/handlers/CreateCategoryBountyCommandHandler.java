package vr.projects.sunnycompass.berrytracker.application.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vr.projects.sunnycompass.berrytracker.application.commands.CreateCategoryBountyCommand;
import vr.projects.sunnycompass.berrytracker.core.cqrs.Command;
import vr.projects.sunnycompass.berrytracker.core.cqrs.CommandHandler;
import vr.projects.sunnycompass.berrytracker.domain.bounties.Bounty;
import vr.projects.sunnycompass.berrytracker.domain.categories.CategoryId;
import vr.projects.sunnycompass.berrytracker.infrastructure.BountyRepository;
import vr.projects.sunnycompass.berrytracker.infrastructure.CategoryRepository;

@Component
@RequiredArgsConstructor
public class CreateCategoryBountyCommandHandler implements CommandHandler<CreateCategoryBountyCommand, Bounty> {

    private final BountyRepository bountyRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Bounty handle(final CreateCategoryBountyCommand command) {
        final var requestedCategoryId = CategoryId.from(command.categoryName());
        final var category =
                this.categoryRepository.findById(requestedCategoryId).orElseThrow();
        final var bountyEntity =
                Bounty.create(category.getId(), command.totalBerries(), command.month(), command.year());
        final var savedBounty = this.bountyRepository.save(bountyEntity);
        return savedBounty;
    }

    @Override
    public Class<? extends Command> getType() {
        return CreateCategoryBountyCommand.class;
    }
}

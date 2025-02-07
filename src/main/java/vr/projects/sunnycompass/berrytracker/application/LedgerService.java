package vr.projects.sunnycompass.berrytracker.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vr.projects.sunnycompass.berrytracker.LedgerApi;
import vr.projects.sunnycompass.berrytracker.LedgerEntryResource;
import vr.projects.sunnycompass.berrytracker.application.commands.AddLedgerEntryCommand;
import vr.projects.sunnycompass.berrytracker.core.cqrs.CommandDispatcher;
import vr.projects.sunnycompass.berrytracker.domain.logpose.LedgerEntry;

@Service
@RequiredArgsConstructor
public class LedgerService implements LedgerApi {

    private final CommandDispatcher dispatcher;

    @Override
    public LedgerEntryResource addLedgerEntry(
            final String postedDate,
            final Double berries,
            final String description,
            String category,
            final String source) {
        final Double cents = berries * 100;
        final Long simpleCents = Long.valueOf(cents.longValue());

        final var entity = (LedgerEntry)
                dispatcher.dispatch(new AddLedgerEntryCommand(postedDate, description, category, simpleCents, source));

        return new LedgerEntryResource(
                entity.getId(),
                entity.getDescription(),
                entity.getPostedDate(),
                Double.valueOf(entity.getBerries() / 100),
                entity.getCategory(),
                entity.getType());
    }
}

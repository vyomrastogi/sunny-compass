package vr.projects.sunnycompass.berrytracker.application.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vr.projects.sunnycompass.berrytracker.application.commands.AddLedgerEntryCommand;
import vr.projects.sunnycompass.berrytracker.core.cqrs.Command;
import vr.projects.sunnycompass.berrytracker.core.cqrs.CommandHandler;
import vr.projects.sunnycompass.berrytracker.domain.logpose.LedgerEntry;
import vr.projects.sunnycompass.berrytracker.infrastructure.LedgerEntryRepository;

@Component
@RequiredArgsConstructor
public class AddLedgerEntryCommandHandler implements CommandHandler<AddLedgerEntryCommand, LedgerEntry> {

    private final LedgerEntryRepository ledgerRepository;

    @Override
    public LedgerEntry handle(final AddLedgerEntryCommand command) {
        final var ledgerEntry = LedgerEntry.createLedgerEntry(
                command.postedDate(), command.berries(), command.description(), command.source());
        ledgerEntry.addLedgerEntryCreatedEvent();
        final var savedLedgerEntry = ledgerRepository.save(ledgerEntry);
        return savedLedgerEntry;
    }

    @Override
    public Class<? extends Command> getType() {
        return AddLedgerEntryCommand.class;
    }
}

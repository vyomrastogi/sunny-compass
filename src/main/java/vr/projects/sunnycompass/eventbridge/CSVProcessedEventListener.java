package vr.projects.sunnycompass.eventbridge;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import vr.projects.sunnycompass.berrytracker.LedgerApi;
import vr.projects.sunnycompass.csv.CSVProcessedEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class CSVProcessedEventListener {

    private final LedgerApi ledgerApi;

    @EventListener
    @Async
    public void handleCSVProcessedEvent(final CSVProcessedEvent event) {
        log.info("handling csvprocessevent...");
        final var source = event.payload().source();
        final var entries = event.payload().entries();
        entries.parallelStream()
                .forEach(entry -> ledgerApi.addLedgerEntry(
                        entry.postedDate(), entry.getLedgerEntryValue(), entry.description(), source));
    }
}

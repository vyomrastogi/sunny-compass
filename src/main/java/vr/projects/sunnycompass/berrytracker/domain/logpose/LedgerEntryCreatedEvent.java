package vr.projects.sunnycompass.berrytracker.domain.logpose;

import java.time.Instant;
import vr.projects.sunnycompass.eventbridge.SunnyCompassEvents;

public record LedgerEntryCreatedEvent(LedgerEntry payload, String eventName, Instant createdAt)
        implements SunnyCompassEvents<LedgerEntry> {

    public static final String EVENT_NAME = "LedgerEntryCreatedEvent";

    public LedgerEntryCreatedEvent(final LedgerEntry ledgerEntry) {
        this(ledgerEntry, EVENT_NAME, Instant.now());
    }
}

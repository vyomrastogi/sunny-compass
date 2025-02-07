package vr.projects.sunnycompass.csv;

import java.time.Instant;
import java.util.List;
import vr.projects.sunnycompass.eventbridge.SunnyCompassEvents;

public record CSVProcessedEvent(CSVProcessedPayload payload, String eventName, Instant createdAt)
        implements SunnyCompassEvents<CSVProcessedPayload> {

    public static final String EVENT_NAME = "CSVProcessedEvent";

    public CSVProcessedEvent(final List<TransactionEntry> entries, final String source) {
        this(new CSVProcessedPayload(entries, source), EVENT_NAME, Instant.now());
    }
}

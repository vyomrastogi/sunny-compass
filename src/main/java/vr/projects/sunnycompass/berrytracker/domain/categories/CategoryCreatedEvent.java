package vr.projects.sunnycompass.berrytracker.domain.categories;

import java.time.Instant;
import vr.projects.sunnycompass.eventbridge.SunnyCompassEvents;

public record CategoryCreatedEvent(Object payload, String eventName, Instant createdAt) implements SunnyCompassEvents {

    private static final String EVENT_NAME = "CategoryCreated";

    public CategoryCreatedEvent(final Object payload) {
        this(payload, EVENT_NAME, Instant.now());
    }
}

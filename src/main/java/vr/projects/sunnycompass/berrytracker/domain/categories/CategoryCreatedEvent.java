package vr.projects.sunnycompass.berrytracker.domain.categories;

import java.time.Instant;
import vr.projects.sunnycompass.eventbridge.SunnyCompassEvents;

public record CategoryCreatedEvent(Category payload, String eventName, Instant createdAt)
        implements SunnyCompassEvents<Category> {

    private static final String EVENT_NAME = "CategoryCreated";

    public CategoryCreatedEvent(final Category payload) {
        this(payload, EVENT_NAME, Instant.now());
    }
}

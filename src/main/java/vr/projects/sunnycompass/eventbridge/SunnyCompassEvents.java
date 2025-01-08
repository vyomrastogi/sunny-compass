package vr.projects.sunnycompass.eventbridge;

import java.time.Instant;

public interface SunnyCompassEvents {
    String eventName();

    Instant createdAt();

    Object payload();
}

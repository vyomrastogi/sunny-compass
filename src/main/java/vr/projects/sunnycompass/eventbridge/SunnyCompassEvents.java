package vr.projects.sunnycompass.eventbridge;

import java.time.Instant;

public interface SunnyCompassEvents<T> {
    String eventName();

    Instant createdAt();

    T payload();
}

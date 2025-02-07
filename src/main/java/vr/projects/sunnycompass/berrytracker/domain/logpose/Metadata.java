package vr.projects.sunnycompass.berrytracker.domain.logpose;

import java.time.Instant;

public record Metadata(Instant processingTimestamp, String source) {}

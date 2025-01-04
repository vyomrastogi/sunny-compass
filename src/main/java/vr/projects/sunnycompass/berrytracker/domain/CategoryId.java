package vr.projects.sunnycompass.berrytracker.domain;

import java.util.UUID;

public record CategoryId(String id) {

    public static CategoryId create() {
        return new CategoryId(UUID.randomUUID().toString());
    }
}

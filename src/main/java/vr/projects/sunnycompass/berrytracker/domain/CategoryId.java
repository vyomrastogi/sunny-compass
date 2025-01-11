package vr.projects.sunnycompass.berrytracker.domain;

import java.util.Objects;

public record CategoryId(String id) {

    public static final String CATEGORYID_PATTERN = "CATEGORY#%s";

    public static CategoryId from(final String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("category name must not be non-blank value");
        }
        final var nameId = name.trim().toUpperCase().replaceAll("\\s", "_");
        return new CategoryId(String.format(CATEGORYID_PATTERN, nameId));
    }
}

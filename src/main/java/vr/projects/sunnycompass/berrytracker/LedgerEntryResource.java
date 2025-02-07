package vr.projects.sunnycompass.berrytracker;

public record LedgerEntryResource(
        String id, String description, String postedDate, Double berries, String category, String entryType) {}

package vr.projects.sunnycompass.berrytracker;

public interface LedgerApi {

    public LedgerEntryResource addLedgerEntry(
            String postedDate, Double berries, String description, String category, String source);
}

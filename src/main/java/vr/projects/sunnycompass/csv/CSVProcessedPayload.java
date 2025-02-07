package vr.projects.sunnycompass.csv;

import java.util.List;

public record CSVProcessedPayload(List<TransactionEntry> entries, String source) {}

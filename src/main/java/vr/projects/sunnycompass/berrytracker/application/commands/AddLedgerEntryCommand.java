package vr.projects.sunnycompass.berrytracker.application.commands;

import vr.projects.sunnycompass.berrytracker.core.cqrs.Command;

public record AddLedgerEntryCommand(String postedDate, String description, String category, Long berries, String source)
        implements Command {}

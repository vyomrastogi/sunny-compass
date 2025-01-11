package vr.projects.sunnycompass.berrytracker.application.commands;

import vr.projects.sunnycompass.berrytracker.core.cqrs.Command;

public record CreateCategoryBountyCommand(String categoryName, Long totalBerries, Integer month, Integer year)
        implements Command {}

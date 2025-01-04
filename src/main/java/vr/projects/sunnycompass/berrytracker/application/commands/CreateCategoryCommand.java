package vr.projects.sunnycompass.berrytracker.application.commands;

import java.util.List;
import vr.projects.sunnycompass.berrytracker.core.cqrs.Command;

public record CreateCategoryCommand(String name, String type, List<String> tags) implements Command {}

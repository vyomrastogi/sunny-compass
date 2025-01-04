package vr.projects.sunnycompass.berrytracker;

import java.util.List;

public record CategoryResource(String id, String name, String type, List<String> tags) {}

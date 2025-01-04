package vr.projects.sunnycompass.restapi.categories;

import java.util.List;

public record CreateCategoryRequest(String name, String type, List<String> tags) {}

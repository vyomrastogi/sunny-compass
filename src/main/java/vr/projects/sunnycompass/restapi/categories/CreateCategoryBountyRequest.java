package vr.projects.sunnycompass.restapi.categories;

public record CreateCategoryBountyRequest(String categoryName, Long totalBerries, Integer month, Integer year) {}

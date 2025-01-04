package vr.projects.sunnycompass.berrytracker.domain;

public class Category {

    private CategoryId id;
    private String name;
    private CategoryType type;
    private Tags tags;

    public Category(CategoryId id, String name, CategoryType type, Tags tags) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.tags = tags;
    }

    public static Category create(String name, CategoryType type, Tags tags) {
        return new Category(CategoryId.create(), name, type, tags);
    }

    public CategoryId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryType getType() {
        return type;
    }

    public Tags getTags() {
        return tags;
    }
}

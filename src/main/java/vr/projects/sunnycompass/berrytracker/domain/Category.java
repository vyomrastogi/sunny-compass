package vr.projects.sunnycompass.berrytracker.domain;

public class Category {

    private final CategoryId id;
    private final String name;
    private final CategoryType type;
    private final Tags tags;

    public Category(final CategoryId id, final String name, final CategoryType type, final Tags tags) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.tags = tags;
    }

    public static Category create(final String name, final CategoryType type, final Tags tags) {
        return new Category(CategoryId.create(), name, type, tags);
    }

    public CategoryId getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public CategoryType getType() {
        return this.type;
    }

    public Tags getTags() {
        return this.tags;
    }
}

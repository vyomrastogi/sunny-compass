package vr.projects.sunnycompass.berrytracker.domain.categories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.mongodb.core.mapping.Document;
import vr.projects.sunnycompass.berrytracker.domain.Tags;

@Document(collection = "berry-tracker")
public class Category {

    @Id
    private final CategoryId id;

    private final String name;
    private final CategoryType type;
    private final Tags tags;

    @Transient
    private final List<Object> domainEvents = new ArrayList<>();

    public Category(final CategoryId id, final String name, final CategoryType type, final Tags tags) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.tags = tags;
    }

    public static Category create(final String name, final CategoryType type, final Tags tags) {
        final var category = new Category(CategoryId.from(name), name, type, tags);
        category.addCategoryCreatedEvent();
        return category;
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

    @DomainEvents
    Collection<Object> getDomainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }

    @AfterDomainEventPublication
    void cleanup() {
        this.domainEvents.clear();
    }

    private void addCategoryCreatedEvent() {
        this.domainEvents.add(new CategoryCreatedEvent(this));
    }

    @Override
    public String toString() {
        return "Category [id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", tags=" + this.tags + "]";
    }
}

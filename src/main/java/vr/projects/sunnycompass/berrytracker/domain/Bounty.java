package vr.projects.sunnycompass.berrytracker.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "berry-tracker")
public class Bounty {

    @Id
    private final BountyId id;

    private final CategoryId categoryId;
    private final Long totalBerries;
    private final Integer month;
    private final Integer year;

    public Bounty(
            final BountyId id,
            final CategoryId categoryId,
            final Long totalBerries,
            final Integer month,
            final Integer year) {
        this.id = id;
        this.categoryId = categoryId;
        this.totalBerries = totalBerries;
        this.month = month;
        this.year = year;
    }

    public static Bounty create(
            final CategoryId categoryId, final Long totalBerries, final Integer month, final Integer year) {
        return new Bounty(BountyId.from(categoryId, month, year), categoryId, totalBerries, month, year);
    }

    public BountyId getId() {
        return this.id;
    }

    public CategoryId getCategoryId() {
        return this.categoryId;
    }

    public Long getTotalBerries() {
        return this.totalBerries;
    }

    public Integer getMonth() {
        return this.month;
    }

    public Integer getYear() {
        return this.year;
    }
}

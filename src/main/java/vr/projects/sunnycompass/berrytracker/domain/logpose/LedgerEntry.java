package vr.projects.sunnycompass.berrytracker.domain.logpose;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "log-pose")
public class LedgerEntry {

    @Id
    private String id;

    private String postedDate;
    private Long berries;
    private String description;
    private String type;
    private String category;
    private Metadata metadata;

    @Transient
    private final List<LedgerEntryCreatedEvent> domainEvents = new ArrayList<>();

    public LedgerEntry(
            String id,
            String postedDate,
            Long berries,
            String description,
            String type,
            String category,
            Metadata metadata) {
        this.id = id;
        this.postedDate = postedDate;
        this.berries = berries;
        this.description = description;
        this.type = type;
        this.category = category;
        this.metadata = metadata;
    }

    public static LedgerEntry createLedgerEntry(
            final String postedDate, final Long berries, final String description, String source) {
        if (berries != null && berries > 0) {
            return new LedgerEntry(
                    UUID.randomUUID().toString(),
                    postedDate,
                    berries,
                    description,
                    "CREDIT",
                    "",
                    new Metadata(Instant.now(), source));
        } else {
            return new LedgerEntry(
                    UUID.randomUUID().toString(),
                    postedDate,
                    berries,
                    description,
                    "DEBIT",
                    "",
                    new Metadata(Instant.now(), source));
        }
    }

    public String getId() {
        return id;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public Long getBerries() {
        return berries;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    @DomainEvents
    Collection<Object> getDomainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }

    @AfterDomainEventPublication
    void cleanup() {
        this.domainEvents.clear();
    }

    public void addLedgerEntryCreatedEvent() {
        this.domainEvents.add(new LedgerEntryCreatedEvent(this));
    }
}

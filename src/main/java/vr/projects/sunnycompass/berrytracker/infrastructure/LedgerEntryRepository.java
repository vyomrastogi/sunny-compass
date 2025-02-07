package vr.projects.sunnycompass.berrytracker.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import vr.projects.sunnycompass.berrytracker.domain.logpose.LedgerEntry;

public interface LedgerEntryRepository extends MongoRepository<LedgerEntry, String> {}

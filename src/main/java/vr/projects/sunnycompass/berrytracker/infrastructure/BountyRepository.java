package vr.projects.sunnycompass.berrytracker.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import vr.projects.sunnycompass.berrytracker.domain.Bounty;
import vr.projects.sunnycompass.berrytracker.domain.BountyId;

public interface BountyRepository extends MongoRepository<Bounty, BountyId> {}

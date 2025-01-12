package vr.projects.sunnycompass.berrytracker.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import vr.projects.sunnycompass.berrytracker.domain.bounties.Bounty;
import vr.projects.sunnycompass.berrytracker.domain.bounties.BountyId;

public interface BountyRepository extends MongoRepository<Bounty, BountyId> {}

package vr.projects.sunnycompass.berrytracker.domain.bounties;

import java.util.Objects;
import vr.projects.sunnycompass.berrytracker.domain.categories.CategoryId;

public record BountyId(String id) {

    public static final String BOUNTYID_PATTERN = "BOUNTY#%s#%s#%s";

    public static BountyId from(final CategoryId categoryId, final Integer month, final Integer year) {
        if (Objects.isNull(categoryId)) {
            throw new IllegalArgumentException("category must be associated with a bounty(budget)");
        }

        if (Objects.isNull(month) || Objects.isNull(year)) {
            throw new IllegalArgumentException("year-month must be assigned to a bounty(budget)");
        }

        return new BountyId(String.format(BOUNTYID_PATTERN, year, month, categoryId.id()));
    }
}

package vr.projects.sunnycompass.berrytracker.infrastructure;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import vr.projects.sunnycompass.berrytracker.domain.Category;
import vr.projects.sunnycompass.berrytracker.domain.CategoryId;

@Repository
@RequiredArgsConstructor
public class QueryRepository {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        final var categoryIdPrefix = String.format(CategoryId.CATEGORYID_PATTERN, "");
        final var idRegex = String.format("^%s", categoryIdPrefix);
        return this.categoryRepository.findByIdStartingWith(idRegex);
    }
}

package vr.projects.sunnycompass.berrytracker.infrastructure;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import vr.projects.sunnycompass.berrytracker.domain.categories.Category;
import vr.projects.sunnycompass.berrytracker.domain.categories.CategoryId;

@Repository
@RequiredArgsConstructor
public class QueryRepository {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        final var categoryIdPrefix = String.format(CategoryId.CATEGORYID_PATTERN, "");
        final var idRegex = String.format("^%s", categoryIdPrefix);
        return this.categoryRepository.findCategories(idRegex);
    }
}

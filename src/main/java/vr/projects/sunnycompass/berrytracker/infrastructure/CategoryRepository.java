package vr.projects.sunnycompass.berrytracker.infrastructure;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import vr.projects.sunnycompass.berrytracker.domain.categories.Category;
import vr.projects.sunnycompass.berrytracker.domain.categories.CategoryId;

public interface CategoryRepository extends MongoRepository<Category, CategoryId> {

    @Query("{ '_id._id': { $regex: ?0 } }")
    List<Category> findCategories(String idRegex);
}

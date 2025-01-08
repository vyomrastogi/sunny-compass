package vr.projects.sunnycompass.berrytracker.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import vr.projects.sunnycompass.berrytracker.domain.Category;
import vr.projects.sunnycompass.berrytracker.domain.CategoryId;

public interface CategoryRepository extends MongoRepository<Category, CategoryId> {}

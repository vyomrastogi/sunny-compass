package vr.projects.sunnycompass.berrytracker.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vr.projects.sunnycompass.berrytracker.application.commands.CreateCategoryCommand;
import vr.projects.sunnycompass.berrytracker.core.cqrs.CommandDispatcher;
import vr.projects.sunnycompass.berrytracker.domain.Tags;
import vr.projects.sunnycompass.berrytracker.domain.categories.Category;
import vr.projects.sunnycompass.berrytracker.domain.categories.CategoryId;
import vr.projects.sunnycompass.berrytracker.domain.categories.CategoryType;
import vr.projects.sunnycompass.berrytracker.infrastructure.QueryRepository;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    private static final String TYPE_SINK = "SINK";

    private static final String TAG_TEXT = "flex";

    private static final String CATEGORY_NAME = "test";

    @Mock
    private CommandDispatcher dispatcher;

    @Mock
    private QueryRepository queryRepository;

    private CategoryService categoryService;

    @BeforeEach
    void setup() {
        this.categoryService = new CategoryService(this.dispatcher, this.queryRepository);
    }

    @Test
    void testCreateIsSuccess() {
        final var entity = new Category(
                CategoryId.from(CATEGORY_NAME), CATEGORY_NAME, CategoryType.SINK, new Tags(List.of(TAG_TEXT)));

        when(this.dispatcher.dispatch(any(CreateCategoryCommand.class))).thenReturn(entity);
        final var actual = this.categoryService.create(CATEGORY_NAME, TYPE_SINK, List.of(TAG_TEXT));

        Assertions.assertThat(actual)
                .isNotNull()
                .extracting("id", "name", "type", "tags")
                .containsExactly("CATEGORY#TEST", CATEGORY_NAME, TYPE_SINK, List.of(TAG_TEXT));
    }
}

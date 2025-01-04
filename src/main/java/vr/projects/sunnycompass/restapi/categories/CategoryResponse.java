package vr.projects.sunnycompass.restapi.categories;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import vr.projects.sunnycompass.berrytracker.CategoryResource;
import vr.projects.sunnycompass.restapi.RestError;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record CategoryResponse(Object data, List<RestError> errors) {

    public static CategoryResponse success(final CategoryResource categoryResource) {
        return new CategoryResponse(categoryResource, null);
    }
}

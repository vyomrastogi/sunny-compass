package vr.projects.sunnycompass.restapi.categories;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import vr.projects.sunnycompass.restapi.RestError;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record RestResponse(Object data, List<RestError> errors) {

    public static RestResponse success(final Object resource) {
        return new RestResponse(resource, null);
    }
}

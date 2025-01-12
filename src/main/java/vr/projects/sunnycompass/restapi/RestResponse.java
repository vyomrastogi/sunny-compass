package vr.projects.sunnycompass.restapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record RestResponse(Object data, List<RestError> errors) {

    public static RestResponse success(final Object resource) {
        return new RestResponse(resource, null);
    }
}

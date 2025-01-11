package vr.projects.sunnycompass.restapi.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vr.projects.sunnycompass.berrytracker.CategoryApi;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {

    private final CategoryApi categoryApi;

    @PostMapping("")
    public RestResponse addCategory(@RequestBody final CreateCategoryRequest request) {
        return RestResponse.success(this.categoryApi.create(request.name(), request.type(), request.tags()));
    }

    @PostMapping("/bounties")
    public RestResponse addCategoryBounty(@RequestBody final CreateCategoryBountyRequest request) {
        return RestResponse.success(this.categoryApi.addBounty(
                request.categoryName(), request.totalBerries(), request.month(), request.year()));
    }

    @GetMapping("")
    public RestResponse getAllCategories() {
        return RestResponse.success(this.categoryApi.findAllCategories());
    }
}

package micnusz.backend.category.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import micnusz.backend.category.Category;
import micnusz.backend.category.service.CategoryService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Getting categories
    @GetMapping
    public Flux<Category> getCategories() {
        return categoryService.getCategories();
    }

    // Getting category by id
    @GetMapping("/{id}")
    public Mono<Category> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // Getting category by slug
    @GetMapping("/slug/{slug}")
    public Mono<Category> getCategoryBySlug(@PathVariable String slug) {
        return categoryService.getCategoryBySlug(slug);
    }

}

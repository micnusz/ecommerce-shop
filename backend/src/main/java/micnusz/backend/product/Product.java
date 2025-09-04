package micnusz.backend.product;

import java.util.List;

import micnusz.backend.category.Category;

public record Product(Integer id, String title, String slug, Double price, String description, Category category,
        List<String> images) {

}

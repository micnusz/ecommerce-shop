package micnusz.backend.product;

import java.util.List;

public record Product(Integer id, String title, String slug, Double price, String description, Category category,
        List<String> images) {

}

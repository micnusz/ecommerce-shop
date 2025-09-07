package micnusz.backend.product.map;

import micnusz.backend.category.Category;
import micnusz.backend.product.Product;
import micnusz.backend.product.dto.ProductApiDto;
import micnusz.backend.product.dto.ProductResponseDto;

public class ProductMapper {

    public static Product toDomain(ProductApiDto dto) {
        return new Product(
                dto.id(),
                dto.title(),
                dto.title().toLowerCase().replace(" ", "-"),
                dto.price(),
                dto.description(),
                new Category(
                        dto.category().id(),
                        dto.category().name(),
                        dto.category().image(),
                        dto.category().slug()),
                dto.images());
    }

    public static ProductResponseDto toResponse(Product product) {
        return new ProductResponseDto(
                product.id(),
                product.title(),
                product.price(),
                product.description(),
                product.category().name(),
                product.images());
    }
}

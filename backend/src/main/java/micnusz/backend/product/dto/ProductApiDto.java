package micnusz.backend.product.dto;

import java.util.List;

import micnusz.backend.category.dto.CategoryApiDto;

public record ProductApiDto(Integer id, String title, String slug, Double price, String description,
        CategoryApiDto category, List<String> images) {
}
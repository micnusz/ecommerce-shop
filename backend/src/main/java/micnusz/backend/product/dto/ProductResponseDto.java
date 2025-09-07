package micnusz.backend.product.dto;

import java.util.List;

public record ProductResponseDto(
        Integer id,
        String title,
        Double price,
        String description,
        String categoryName,
        List<String> images) {

}

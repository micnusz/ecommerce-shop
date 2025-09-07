package micnusz.backend.product;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import micnusz.backend.product.dto.DummyJsonResponse;
import micnusz.backend.product.dto.ProductApiDto;
import micnusz.backend.product.map.ProductMapper;
import reactor.core.publisher.Mono;

@Component
public class ProductClient {

    private final WebClient webClient;

    public ProductClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://dummyjson.com").build();
    }

    public Mono<PagedResponse<Product>> getAllProducts(String title, Double price, Double priceMin, Double priceMax,
            Integer categoryId, String categorySlug, Integer skip, Integer limit) {
        return webClient.get().uri(uriBuilder -> {
            var builder = uriBuilder.path("/products");
            if (title != null)
                builder.queryParam("title", title);
            if (price != null)
                builder.queryParam("price", price);
            if (priceMin != null)
                builder.queryParam("priceMin", priceMin);
            if (priceMax != null)
                builder.queryParam("priceMax", priceMax);
            if (categoryId != null)
                builder.queryParam("categoryId", categoryId);
            if (categorySlug != null)
                builder.queryParam("categorySlug", categorySlug);
            if (skip != null)
                builder.queryParam("skip", skip);
            if (limit != null)
                builder.queryParam("limit", limit);
            return builder.build();
        }).retrieve()
                .bodyToMono(DummyJsonResponse.class)
                .map(resp -> new PagedResponse<>(
                        resp.products().stream()
                                .map(ProductMapper::toDomain)
                                .toList(),
                        resp.total(),
                        resp.skip(),
                        resp.limit()));

    }

    public Mono<Product> getProductById(Integer id) {
        return webClient.get().uri("/products/{id}", id).retrieve().bodyToMono(ProductApiDto.class)
                .map(ProductMapper::toDomain);
    }
}

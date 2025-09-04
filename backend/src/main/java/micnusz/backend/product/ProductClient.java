package micnusz.backend.product;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductClient {

    private final WebClient webClient;

    public ProductClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.escuelajs.co/api/v1").build();
    }

    public Flux<Product> getAllProducts(String title, Double price, Double priceMin, Double priceMax,
            Integer categoryId, String categorySlug) {
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
            return builder.build();
        }).retrieve().bodyToFlux(Product.class);
    }

    public Mono<Product> getProductById(Integer id) {
        return webClient.get().uri("/products/{id}", id).retrieve().bodyToMono(Product.class);
    }
}

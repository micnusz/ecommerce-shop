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

    public Flux<Product> getAllProducts() {
        return webClient.get().uri("/products").retrieve().bodyToFlux(Product.class);
    }

    public Mono<Product> getProductById(Integer id) {
        return webClient.get().uri("/products/{id}", id).retrieve().bodyToMono(Product.class);
    }
}

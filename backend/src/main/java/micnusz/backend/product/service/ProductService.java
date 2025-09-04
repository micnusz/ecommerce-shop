package micnusz.backend.product.service;

import org.springframework.stereotype.Service;

import micnusz.backend.product.Product;
import micnusz.backend.product.ProductClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final ProductClient productClient;

    public ProductService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public Flux<Product> getProducts() {
        return productClient.getAllProducts();
    }

    public Mono<Product> getProduct(Integer id) {
        return productClient.getProductById(id);

    }
}

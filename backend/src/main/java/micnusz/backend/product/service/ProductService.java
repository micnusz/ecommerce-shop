package micnusz.backend.product.service;

import org.springframework.stereotype.Service;

import micnusz.backend.product.PagedResponse;
import micnusz.backend.product.Product;
import micnusz.backend.product.ProductClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final ProductClient productClient;

    public ProductService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public Mono<PagedResponse<Product>> getProducts(String title, Double price, Double priceMin, Double priceMax,
            Integer categoryId, String categorySlug, Integer skip, Integer limit) {
        return productClient.getAllProducts(title, price, priceMin, priceMax, categoryId, categorySlug, skip, limit);
    }

    public Mono<Product> getProduct(Integer id) {
        return productClient.getProductById(id);

    }
}

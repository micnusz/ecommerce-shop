package micnusz.backend.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import micnusz.backend.product.Product;
import micnusz.backend.product.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/products")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> getProducts(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Double priceMin,
            @RequestParam(required = false) Double priceMax,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String categorySlug) {
        return productService.getProducts(title, price, priceMin, priceMax, categoryId, categorySlug);
    }

    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

}

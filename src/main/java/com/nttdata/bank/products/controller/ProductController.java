package com.nttdata.bank.products.controller;

import com.nttdata.bank.products.api.ProductsApi;
import com.nttdata.bank.products.mapper.ProductMapper;
import com.nttdata.bank.products.model.Product;
import com.nttdata.bank.products.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController implements ProductsApi {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<ResponseEntity<Product>> addProduct(Mono<Product> product, ServerWebExchange exchange) {
        return productService.save(product.map(productMapper::toDomain))
                .map(productMapper::toModel)
                .map(c -> {
                    return ResponseEntity.status(HttpStatus.CREATED).body(c);
                });
    }

    @Override
    public Mono<ResponseEntity<Product>> getProductById(String id, ServerWebExchange exchange) {
        return productService.findById(id)
                .map(productMapper::toModel)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<Flux<Product>>> getProducts(ServerWebExchange exchange) {
        Flux<Product> transactionsFlux = productService.findAll()
                .map(productMapper::toModel);

        return Mono.just(ResponseEntity.ok(transactionsFlux))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

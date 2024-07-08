package com.nttdata.bank.products.service.impl;

import com.nttdata.bank.products.domain.Product;
import com.nttdata.bank.products.repository.ProductRepository;
import com.nttdata.bank.products.service.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> save(Mono<Product> product) {
        return product.flatMap(productRepository::save);
    }

    @Override
    public Mono<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }
}

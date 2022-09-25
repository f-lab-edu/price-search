package com.flab.pricesearch.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductInfo {
    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity findById(long id) {
        return productRepository.getById(id);
    }

    public List<ProductEntity> findAll(long id) {
        return productRepository.findAll();
    }

    public ProductEntity insertProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public ProductEntity updateProduct(long id) {
        return productRepository.save(productRepository.getById(id));
    }
}

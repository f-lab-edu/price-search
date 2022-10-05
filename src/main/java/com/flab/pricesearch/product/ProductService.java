package com.flab.pricesearch.product;

import com.flab.pricesearch.image.ProductImage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService implements ProductInfo {
    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(long id) {
        return productRepository.findById(id).orElseGet(Product::new);
    }

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> ProductDto.productOf(product))
                .collect(Collectors.toList());
    }

    public ProductDto insertProduct(Product product) {
        return ProductDto.productOf(productRepository.save(product));
    }

    public ProductDto updateProduct(long id) {
        return ProductDto.productOf(productRepository.save(productRepository.getById(id)));
    }

    @Override
    public List<ProductImage> getImages() {
        return null;
    }

    @Override
    public String createSearchWord(ProductDto productDto) {
        return null;
    }

    @Override
    public void crawlProductInfo(String searchWord) {

    }
}

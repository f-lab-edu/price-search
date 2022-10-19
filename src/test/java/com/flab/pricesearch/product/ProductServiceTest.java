package com.flab.pricesearch.product;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    @BeforeEach
    void init() {
        logger.debug( "★★★★★Before All★★★★★" );
    }
    @Test
    public void ProductInsertTest() {
        Product product = new Product();
        product.setName("test");
        ProductDto productEntity = productService.insertProduct(product);
        assertThat( productEntity.getName() ).isEqualTo("test");
    }

    @Test
    public void ProductReadTest() {
        List<ProductDto> productDtoList = productService.findAll();
        productDtoList.forEach(productDto -> {
            assertThat( productDto.getId() ).isEqualTo( 1 );
            assertThat( productDto.getName() ).isEqualTo( "TEST1" );
        });
    }

    @Test
    public void ProductUpdateTest() {
        ProductDto product = productService.findById(1);
        product.setName( "test2" );
        ProductDto productEntity = productService.updateProduct(1);
        assertThat( productEntity.getName() ).isEqualTo( "test2" );
    }
}

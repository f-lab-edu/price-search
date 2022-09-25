package com.flab.pricesearch.product;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;

@SpringBootTest
//@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    //@Autowired
    DataSource dataSource;
    @Autowired
    ProductService productService;

    @BeforeAll
    void init() {
        System.out.println( "Before All");
        try(Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("/resources/db/h2/testData.sql"));
            System.out.println( "insert success!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void ProductInsertTest() {
        ProductEntity product = new ProductEntity();
        product.setName("test");
        ProductEntity productEntity = productService.insertProduct(product);
        assertThat( productEntity.getName() ).isEqualTo("test");
    }

    @Test
    public void ProductUpdateTest() {
        ProductEntity product = productService.findById(1);
        product.setName("test2");
        ProductEntity productEntity = productService.updateProduct(1);
        assertThat( productEntity.getName() ).isEqualTo( "test2" );
    }

    @Test
    public void ProductReadTest() {
        ProductEntity product = productService.findById(1);
        assertThat( product.getName() ).isEqualTo( "TEST1" );
    }
}

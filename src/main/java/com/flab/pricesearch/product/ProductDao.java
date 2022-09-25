package com.flab.pricesearch.product;

import com.flab.pricesearch.image.ProductImage;
import org.springframework.beans.BeanUtils;

public class ProductDao {
    private long id;
    private String name;
    private ProductImage productImage;

    public ProductDao() {
    }

    public static ProductDao productOf(ProductEntity productEntity) {
        ProductDao product = new ProductDao();
        BeanUtils.copyProperties(productEntity, product);
        return product;
    }

    public ProductEntity asProduct() {
        ProductEntity product = new ProductEntity();
        BeanUtils.copyProperties(this, product);
        return product;
    }
}

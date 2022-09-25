package com.flab.pricesearch.image;

import javax.persistence.*;


public class ProductImage extends Image {

    @Column(name = "product_image_id")
    private long id;

    public ProductImage() {
    }

    public long getId() {
        return id;
    }
}

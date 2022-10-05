package com.flab.pricesearch.cart;

import com.flab.pricesearch.product.Product;
import com.flab.pricesearch.user.domain.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name = "CART_PRODUCT")
    private List<Product> productList;

}

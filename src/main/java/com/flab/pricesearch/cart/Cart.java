package com.flab.pricesearch.cart;

import com.flab.pricesearch.product.Product;
import com.flab.pricesearch.user.domain.User;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name = "CART_PRODUCT")
    private List<Product> productList;

}

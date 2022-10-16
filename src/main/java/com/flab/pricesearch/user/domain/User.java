package com.flab.pricesearch.user.domain;

import com.flab.pricesearch.cart.Cart;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    private String userId;

    private String password;

    private String platformType;

    private String token;

    private String userName;

    private String birthDate;

    private String gender;

    private String tel;

    private String email;

    private String address;

    private String regDate;

    private String termsAgreeYn;

    private String termsAgreeDateTime;

    private String dormantYn;

    private String dormantDate;

    private String withdrawalDate;

    private String status;

    private String lastUpdateDate;

    @OneToMany(mappedBy = "user")
    private List<Cart> cartList;

}

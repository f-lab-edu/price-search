package com.flab.pricesearch.price;

import com.flab.pricesearch.market.MarketCode;
import com.flab.pricesearch.product.Product;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICE")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id; // id

    @Column(name = "MARKET_CODE")
    @Enumerated
    private MarketCode marketCode; // 마켓 코드

    @Column(name = "PRICE")
    private BigDecimal price; // 가격

    @Column(name = "URL")
    private String url; // 결제 가능 url

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product; // 매핑된 상품정보
}

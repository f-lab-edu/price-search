package com.flab.pricesearch.price;

import com.flab.pricesearch.market.MarketCode;
import com.flab.pricesearch.product.Product;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id; // id

    @Column(name = "market_code")
    @Enumerated(EnumType.STRING)
    private MarketCode marketCode; // 마켓 코드

    @Column(name = "price")
    private BigDecimal price; // 가격

    @Column(name = "url")
    private String url; // 결제 가능 url

    @ManyToOne
    @JoinColumn
    private Product product; // 매핑된 상품정보
}

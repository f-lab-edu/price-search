package com.flab.pricesearch.image;

import com.flab.pricesearch.price.Price;
import com.flab.pricesearch.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage implements Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "PRICE_ID")
    private Price price;

    @Override
    public void uploadImage(Image image) {
        // input param 정보에 해당하는 storage 주소에 이미지 저장
        // TBD
    }

    @Override
    public Image downloadImage() {
        // 해당 product 이미지 정보에 해당하는 storage 주소에서 이미지 다운로드
        // TBD
        return null;
    }
}

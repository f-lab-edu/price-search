package com.flab.pricesearch.product;

import com.flab.pricesearch.image.ProductImage;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    @NotBlank(message = "상품 id는 필수값입니다.")
    private long id;

    @NotBlank(message = "상품명을 확인하세요.")
    private String name;

    @NotBlank(message = "상품이미지를 확인하세요.")
    private List<ProductImage> productImageList;

    public static ProductDto productOf(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public Product asProduct() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }
}

package com.flab.pricesearch.price;

import com.flab.pricesearch.market.MarketCode;
import com.flab.pricesearch.product.Product;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PriceDto {

    @NotBlank(message = "가격정보 id는 필수값입니다.")
    private long id;

    @NotBlank(message = "마켓 코드를 확인하세요.")
    private MarketCode marketCode;

    @NotBlank(message = "가격을 확인하세요.")
    private BigDecimal price;

    @NotBlank(message = "url을 확인하세요.")
    private String url;

    @NotBlank(message = "상품 정보는 필수입니다.")
    private Product product;

    public static PriceDto priceOf(Price price) {
        PriceDto priceDto = new PriceDto();
        BeanUtils.copyProperties(price, priceDto);
        return priceDto;
    }

    public Price asPrice() {
        Price price = new Price();
        BeanUtils.copyProperties(this, price);
        return price;
    }
}

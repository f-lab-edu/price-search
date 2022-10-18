package com.flab.pricesearch.price;


import com.flab.pricesearch.market.MarketCode;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PriceServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PriceService priceService;
    Price initPrice;

    PriceDto initPriceDto;

    @BeforeEach
    void init() {
        initPrice = new Price();
        initPrice.setMarketCode(MarketCode.COUPANG);
        initPrice.setPrice(new BigDecimal("10000"));
        initPrice.setUrl("www.coupang.com");
        initPriceDto = priceService.insertPrice(initPrice);
    }

    @Test
    public void PriceInsertTest() {
        Price price = new Price();
        price.setMarketCode(MarketCode.NAVER);
        PriceDto priceDto = priceService.insertPrice(price);
        assertThat( priceDto.getMarketCode() ).isEqualTo(MarketCode.NAVER);
    }

    @Test
    public void PriceReadTest() {
        List<PriceDto> priceDtoList = priceService.findAll();
        priceDtoList.forEach(priceDto -> {
            assertThat( priceDto.getMarketCode() ).isEqualTo( initPriceDto.getMarketCode() );
            assertThat( priceDto.getPrice() ).isEqualByComparingTo( initPriceDto.getPrice() );
            assertThat( priceDto.getUrl() ).isEqualTo( initPriceDto.getUrl() );
        });
    }

    @Test
    public void PriceUpdateTest() {
        /*
        initPriceDto.setUrl("www.naver.com");
        initPriceDto.setPrice(new BigDecimal("20000"));
        initPriceDto.setMarketCode(MarketCode.NAVER);
        */
        initPrice.setUrl("www.naver.com");
        initPrice.setPrice(new BigDecimal("20000"));
        initPrice.setMarketCode(MarketCode.NAVER);
        PriceDto priceDto = priceService.updatePrice(initPrice.getId());
        assertThat( priceDto.getPrice() ).isEqualByComparingTo( new BigDecimal("20000"));
        assertThat( priceDto.getMarketCode() ).isEqualTo( MarketCode.NAVER );
        assertThat( priceDto.getUrl() ).isEqualTo( "www.naver.com" );
    }

}

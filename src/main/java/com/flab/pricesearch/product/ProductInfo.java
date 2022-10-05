package com.flab.pricesearch.product;

import com.flab.pricesearch.image.ProductImage;
import java.util.List;

public interface ProductInfo {
    /**
     * 해당하는 상품의 이미지 정보들을 조회한다.
     *
     * @return List
     */
    List<ProductImage> getImages();

    /**
     * 입력한 상품정보를 토대로 웹 크롤링에 사용가능한 검색어를 생성한다.
     *
     * @param productDto 상품정보
     * @return String searchWord
     */
    String createSearchWord(ProductDto productDto);
    /**
     * 웹 상의 상품정보를 조회해 DB에 저장한다.
     * TBD
     *
     * @param searchWord 입력문자열
     *
     */
    void crawlProductInfo(String searchWord);
}

package com.flab.pricesearch.product;

import com.flab.pricesearch.image.ProductImage;
import java.util.List;

public interface ProductInfo {

    List<ProductImage> getImages();

    String createSearchWord(ProductDto productDto);

    void crawlProductInfo(String searchWord);

}

package com.flab.pricesearch.image;

import javax.persistence.*;

public interface Image {
    void uploadImage(Image image);
    Image downloadImage();

}

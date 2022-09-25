package com.flab.pricesearch.image;

import javax.persistence.*;

@Entity
@Embeddable
public abstract class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Image() {
    }

    public abstract long getId();
}

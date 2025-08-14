package com.hun.sudalmarket.domain.product.entity;

import com.hun.sudalmarket.domain.BaseEntity;
import com.hun.sudalmarket.domain.product.enums.ProductStatus;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Product extends BaseEntity {

    private String name;
    private String content;
    private int price;
    private String image1;
    private String image2;
    private String image3;
    private ProductStatus status;

    @Builder
    private Product(String name, String content, int price, String image1, String image2, String image3, ProductStatus status) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.status = status;
    }

    public void updateStatus(ProductStatus status) {
        this.status = status;
    }
}

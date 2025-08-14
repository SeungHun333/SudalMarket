package com.hun.sudalmarket.domain.product.dto.request;

import com.hun.sudalmarket.domain.product.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProductRegisterRequest(

        @NotBlank
        String name,

        @NotNull
        int price,
        String content,

        @NotNull
        List<String> imageUrls
) {
    public static Product toEntity(ProductRegisterRequest request) {
        return Product.builder()
                .name(request.name())
                .content(request.content())
                .price(request.price())
                .image1(!request.imageUrls().isEmpty() ? request.imageUrls().get(0) : null)
                .image2(request.imageUrls().size() > 1 ? request.imageUrls().get(1) : null)
                .image3(request.imageUrls().size() > 2 ? request.imageUrls().get(2) : null)
                .build();
    }
}

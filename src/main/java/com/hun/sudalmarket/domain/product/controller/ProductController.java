package com.hun.sudalmarket.domain.product.controller;

import com.hun.sudalmarket.domain.product.dto.request.ProductRegisterRequest;
import com.hun.sudalmarket.domain.product.entity.Product;
import com.hun.sudalmarket.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Validated @RequestBody ProductRegisterRequest request) {

        Product newProduct = ProductRegisterRequest.toEntity(request);

        return ResponseEntity.ok(productService.createProduct(newProduct));
    }
}

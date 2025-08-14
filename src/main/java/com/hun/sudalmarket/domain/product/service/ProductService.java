package com.hun.sudalmarket.domain.product.service;

import com.hun.sudalmarket.domain.product.entity.Product;
import com.hun.sudalmarket.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;


    public String createProduct(Product newProduct) {
        productRepository.save(newProduct);

        return "success";
    }
}

package com.example.reprice_backend.repository;

import com.example.reprice_backend.entity.ProductImage;
import com.example.reprice_backend.mapper.ProductImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductImageRepository {
    private final ProductImageMapper productImageMapper;

    public int addProductImageList(List<ProductImage> productImageList) {
        return productImageMapper.addProductImageList(productImageList);
    }
}

package com.example.reprice_backend.mapper;

import com.example.reprice_backend.entity.ProductImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductImageMapper {
    int addProductImageList(List<ProductImage> productImageList);
}

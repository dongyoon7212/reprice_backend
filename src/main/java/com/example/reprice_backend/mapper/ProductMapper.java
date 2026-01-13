package com.example.reprice_backend.mapper;

import com.example.reprice_backend.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int addProduct(Product product);
}

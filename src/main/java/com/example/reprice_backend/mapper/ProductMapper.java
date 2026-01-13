package com.example.reprice_backend.mapper;

import com.example.reprice_backend.dto.ProductListDto;
import com.example.reprice_backend.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ProductMapper {
    int addProduct(Product product);
    List<ProductListDto> getProductList(int limit, LocalDateTime cursorCreateDt, Integer cursorProductId, String status, String keyword);
}

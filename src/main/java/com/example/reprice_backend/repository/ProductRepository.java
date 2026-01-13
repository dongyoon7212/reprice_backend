package com.example.reprice_backend.repository;

import com.example.reprice_backend.dto.ProductListDto;
import com.example.reprice_backend.entity.Product;
import com.example.reprice_backend.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final ProductMapper productMapper;

    public Optional<Product> addProduct(Product product) {
        try {
            int result = productMapper.addProduct(product);

            if (result != 1) {
                throw new RuntimeException("물품 추가에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return Optional.empty();
        }
        return Optional.of(product);
    }

    public List<ProductListDto> getProductList(int limit, LocalDateTime cursorCreateDt, Integer cursorProductId, String status, String keyword) {
        return productMapper.getProductList(limit, cursorCreateDt,  cursorProductId, status, keyword);
    }
}

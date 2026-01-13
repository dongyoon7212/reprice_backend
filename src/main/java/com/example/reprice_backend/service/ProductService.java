package com.example.reprice_backend.service;

import com.example.reprice_backend.dto.AddProductReqDto;
import com.example.reprice_backend.dto.ApiRespDto;
import com.example.reprice_backend.entity.Product;
import com.example.reprice_backend.entity.ProductImage;
import com.example.reprice_backend.repository.ProductImageRepository;
import com.example.reprice_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    @Transactional(rollbackFor = Exception.class)
    public ApiRespDto<?> addProduct(AddProductReqDto addProductReqDto) {
        System.out.println(addProductReqDto);
        Optional<Product> optionalProduct = productRepository.addProduct(addProductReqDto.toProductEntity());
        if (optionalProduct.isEmpty()) {
            return new ApiRespDto<>("failed", "물품을 추가하는데 실패했습니다. 다시 시도해주세요.", null);
        }

        Product product = optionalProduct.get();

        int result = productImageRepository.addProductImageList(addProductReqDto.toProductImageList(product.getProductId()));
        if (result != addProductReqDto.getProductImageUrls().size()) {
            return new ApiRespDto<>("failed", "물품 이미지를 추가하는데 실패했습니다. 다시 시도해주세요.", null);
        }

        return new ApiRespDto<>("success", "추가되었습니다.", product);
    }

}

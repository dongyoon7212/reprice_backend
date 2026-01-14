package com.example.reprice_backend.dto;

import com.example.reprice_backend.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetProductWithProductImageRespDto {
    private GetProductRespDto product;
    private List<ProductImage> productImageList;
}

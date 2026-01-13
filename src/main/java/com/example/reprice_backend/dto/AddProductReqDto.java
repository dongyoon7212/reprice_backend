package com.example.reprice_backend.dto;

import com.example.reprice_backend.entity.Product;
import com.example.reprice_backend.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
public class AddProductReqDto {
    private Integer userId;
    private String title;
    private String description;
    private Integer price;
    private String category;
    private String conditionGrade;
    private String tradeType;
    private List<String> productImageUrls;

    public Product toProductEntity() {
        return Product.builder()
                .sellerId(userId)
                .title(title)
                .description(description)
                .category(category)
                .price(price)
                .conditionGrade(conditionGrade)
                .tradeType(tradeType)
                .status("FOR_SALE")
                .build();
    }

    public List<ProductImage> toProductImageList(Integer productId) {
        return IntStream.range(0, productImageUrls.size())
                .mapToObj(i -> ProductImage.builder()
                        .productId(productId)
                        .imageUrl(productImageUrls.get(i))
                        .thumbnail(i == 0 ? 1 : 0)   // 첫 번째만 1, 나머지 0
                        .build())
                .toList();
    }

}

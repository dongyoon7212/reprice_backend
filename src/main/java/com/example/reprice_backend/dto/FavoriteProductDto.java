package com.example.reprice_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FavoriteProductDto {
    private Integer productId;
    private String title;
    private Integer price;
    private String status;
    private String category;
    private String conditionGrade;
    private String tradeType;
    private LocalDateTime createDt;
    private String thumbnail;
    private LocalDateTime favoriteDt;
}

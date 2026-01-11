package com.example.reprice_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer productId;
    private Integer sellerId;
    private String title;
    private String description;
    private Integer categoryId;
    private Integer price;
    private String conditionGrade;
    private String tradeType;
    private String status;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}

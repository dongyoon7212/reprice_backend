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
    private String category;
    private Integer price;
    private String conditionGrade; //NEW/GOOD/USED/BREAK
    private String tradeType; //MEETUP/DELIVERY/BOTH
    private String status; //FOR_SALE/RESERVED/SOLD/DELETED
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}

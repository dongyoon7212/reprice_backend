package com.example.reprice_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GetProductRespDto {
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
    private String displayName;
}

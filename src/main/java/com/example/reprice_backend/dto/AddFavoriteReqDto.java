package com.example.reprice_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddFavoriteReqDto {
    private Integer userId;
    private Integer productId;
}

package com.example.reprice_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductCursorDto {
    private Integer cursorProductId;
    private LocalDateTime cursorCreateDt;
}

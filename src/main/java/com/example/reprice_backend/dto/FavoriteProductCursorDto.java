package com.example.reprice_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FavoriteProductCursorDto {
    private LocalDateTime cursorFavoriteDt;
    private Integer cursorProductId;
}

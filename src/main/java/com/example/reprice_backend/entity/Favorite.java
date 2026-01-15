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
public class Favorite {
    private Integer favoriteId;
    private Integer userId;
    private Integer productId;
    private LocalDateTime createDt;
}

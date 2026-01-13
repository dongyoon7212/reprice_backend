package com.example.reprice_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetProductInfiniteRespDto {
    private List<ProductListDto> items;
    private boolean hasNext;
    private ProductCursorDto nextCursor;
}

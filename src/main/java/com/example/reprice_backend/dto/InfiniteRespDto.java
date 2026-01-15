package com.example.reprice_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InfiniteRespDto<T> {
    private List<T> items;
    private boolean hasNext;
    private Object nextCursor;
}

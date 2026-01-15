package com.example.reprice_backend.service;

import com.example.reprice_backend.dto.*;
import com.example.reprice_backend.repository.FavoriteRepository;
import com.example.reprice_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final ProductRepository productRepository;

    public ApiRespDto<?> getFavoriteByUserIdAndProductId(Integer userId, Integer productId) {
        return new ApiRespDto<>("success", "조회완료", favoriteRepository.getFavoriteByUserIdAndProductId(userId, productId).isPresent());
    }

    public ApiRespDto<?> addFavorite(AddFavoriteReqDto addFavoriteReqDto) {
        int result = favoriteRepository.addFavorite(addFavoriteReqDto.getUserId(), addFavoriteReqDto.getProductId());

        if (result != 1) {
            return new ApiRespDto<>("failed", "좋아요 추가 실패", null);
        }

        return new ApiRespDto<>("success", "좋아요 추가 성공", null);
    }

    public ApiRespDto<?> removeFavorite(Integer userId, Integer productId) {
        int result = favoriteRepository.removeFavorite(userId, productId);
        if (result != 1) {
            return new ApiRespDto<>("failed", "좋아요 삭제 실패", null);
        }

        return new ApiRespDto<>("success", "좋아요 삭제 성공", null);
    }

    public ApiRespDto<?> getFavoriteProductInfinite(int limit, LocalDateTime cursorFavoriteDt, Integer cursorProductId, Integer userId) {
        int fetchLimit = limit + 1;

        List<FavoriteProductDto> rows = favoriteRepository.getFavoriteProductInfinite(fetchLimit, cursorFavoriteDt, cursorProductId, userId);

        boolean hasNext = rows.size() > limit;
        if (hasNext) {
            rows = rows.subList(0, limit);
        }

        FavoriteProductCursorDto nextCursor = null;
        if (!rows.isEmpty() && hasNext) {
            FavoriteProductDto last = rows.get(rows.size() - 1);
            nextCursor = new FavoriteProductCursorDto(last.getFavoriteDt(), last.getProductId());
        }

        return new ApiRespDto<>("success", "조회완료", new InfiniteRespDto<>(rows, hasNext, nextCursor));
    }
}

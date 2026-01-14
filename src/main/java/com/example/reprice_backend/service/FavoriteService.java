package com.example.reprice_backend.service;

import com.example.reprice_backend.dto.ApiRespDto;
import com.example.reprice_backend.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    public ApiRespDto<?> getFavoriteByUserIdAndProductId(Integer userId, Integer productId) {
        return new ApiRespDto<>("success", "조회완료", favoriteRepository.getFavoriteByUserIdAndProductId(userId, productId));
    }

    public ApiRespDto<?> addFavorite(Integer userId, Integer productId) {
        int result = favoriteRepository.addFavorite(userId, productId);

        if (result != 1) {
            return new ApiRespDto<>("failed", "좋아요 추가 실패", null);
        }

        return new ApiRespDto<>("success", "좋아요 추가 성공", null);
    }

    public ApiRespDto<?> deleteFavorite(Integer userId, Integer productId) {
        int result = favoriteRepository.deleteFavorite(userId, productId);
        if (result != 1) {
            return new ApiRespDto<>("failed", "좋아요 삭제 실패", null);
        }

        return new ApiRespDto<>("success", "좋아요 삭제 성공", null);
    }
}

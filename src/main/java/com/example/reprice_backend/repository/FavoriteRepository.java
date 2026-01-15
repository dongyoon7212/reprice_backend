package com.example.reprice_backend.repository;

import com.example.reprice_backend.dto.FavoriteProductDto;
import com.example.reprice_backend.entity.Favorite;
import com.example.reprice_backend.mapper.FavoriteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FavoriteRepository {
    final FavoriteMapper favoriteMapper;

    public Optional<Favorite> getFavoriteByUserIdAndProductId(Integer userId, Integer productId) {
        return favoriteMapper.getFavoriteByUserIdAndProductId(userId, productId);
    }

    public int addFavorite(Integer userId, Integer productId) {
        return favoriteMapper.addFavorite(userId, productId);
    }

    public int removeFavorite(Integer userId, Integer productId) {
        return favoriteMapper.removeFavorite(userId, productId);
    }

    public List<FavoriteProductDto> getFavoriteProductInfinite(int limit, LocalDateTime cursorFavoriteDt, Integer cursorProductId, Integer userId) {
        return favoriteMapper.getFavoriteProductInfinite(limit, cursorFavoriteDt, cursorProductId, userId);
    }
}

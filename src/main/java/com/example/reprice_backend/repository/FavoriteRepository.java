package com.example.reprice_backend.repository;

import com.example.reprice_backend.entity.Favorite;
import com.example.reprice_backend.mapper.FavoriteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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

    public int deleteFavorite(Integer userId, Integer productId) {
        return favoriteMapper.deleteFavorite(userId, productId);
    }
}

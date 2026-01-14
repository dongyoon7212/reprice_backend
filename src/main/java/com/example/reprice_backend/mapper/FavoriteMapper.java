package com.example.reprice_backend.mapper;

import com.example.reprice_backend.entity.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface FavoriteMapper {
    Optional<Favorite> getFavoriteByUserIdAndProductId(Integer userId, Integer productId);
    int addFavorite(Integer userId, Integer productId);
    int deleteFavorite(Integer userId, Integer productId);
}

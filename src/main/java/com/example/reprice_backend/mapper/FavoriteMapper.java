package com.example.reprice_backend.mapper;

import com.example.reprice_backend.dto.FavoriteProductDto;
import com.example.reprice_backend.entity.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface FavoriteMapper {
    Optional<Favorite> getFavoriteByUserIdAndProductId(Integer userId, Integer productId);
    int addFavorite(Integer userId, Integer productId);
    int removeFavorite(Integer userId, Integer productId);
    List<FavoriteProductDto> getFavoriteProductInfinite(int limit, LocalDateTime cursorFavoriteDt, Integer cursorProductId, Integer userId);
}

package com.example.reprice_backend.controller;

import com.example.reprice_backend.dto.AddFavoriteReqDto;
import com.example.reprice_backend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/favorite")
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @GetMapping("/get")
    public ResponseEntity<?> getFavoriteByUserIdAndProductId(@RequestParam Integer userId, @RequestParam Integer productId) {
        return ResponseEntity.ok(favoriteService.getFavoriteByUserIdAndProductId(userId, productId));
    }

    @GetMapping("/get/infinite")
    public ResponseEntity<?> getFavoriteProductListByUserId(
            @RequestParam(defaultValue = "8") int limit,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime cursorFavoriteDt,
            @RequestParam(required = false) Integer cursorProductId,
            @RequestParam Integer userId
    ) {
        return ResponseEntity.ok(favoriteService.getFavoriteProductInfinite(limit, cursorFavoriteDt, cursorProductId, userId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFavorite(@RequestBody AddFavoriteReqDto addFavoriteReqDto) {
        return ResponseEntity.ok(favoriteService.addFavorite(addFavoriteReqDto));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFavorite(@RequestParam Integer userId, @RequestParam Integer productId) {
        return ResponseEntity.ok(favoriteService.removeFavorite(userId, productId));
    }
}

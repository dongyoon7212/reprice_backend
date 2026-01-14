package com.example.reprice_backend.controller;

import com.example.reprice_backend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorite")
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @GetMapping("/get")
    public ResponseEntity<?> getFavoriteByUserIdAndProductId(@RequestParam Integer userId, @RequestParam Integer productId) {
        return ResponseEntity.ok(favoriteService.getFavoriteByUserIdAndProductId(userId, productId));
    }

    @GetMapping("/add")
    public ResponseEntity<?> addFavorite(@RequestParam Integer userId, @RequestParam Integer productId) {
        return ResponseEntity.ok(favoriteService.addFavorite(userId, productId));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFavorite(@RequestParam Integer userId, @RequestParam Integer productId) {
        return ResponseEntity.ok(favoriteService.deleteFavorite(userId, productId));
    }
}

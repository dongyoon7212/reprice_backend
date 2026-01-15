package com.example.reprice_backend.controller;

import com.example.reprice_backend.dto.AddProductReqDto;
import com.example.reprice_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody AddProductReqDto addProductReqDto) {
        return ResponseEntity.ok(productService.addProduct(addProductReqDto));
    }

    @GetMapping("/get/infinite")
    public ResponseEntity<?> getProductList(
            @RequestParam(defaultValue = "8") int limit,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime cursorCreateDt,
            @RequestParam(required = false) Integer cursorProductId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String status
    ) {
       return ResponseEntity.ok(productService.getProductList(limit, cursorCreateDt, cursorProductId, keyword, status));
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<?> getProductByProductId(@PathVariable Integer productId) {
        return ResponseEntity.ok(productService.getProductByProductId(productId));
    }

}

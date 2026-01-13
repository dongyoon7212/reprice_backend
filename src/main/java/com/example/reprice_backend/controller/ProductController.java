package com.example.reprice_backend.controller;

import com.example.reprice_backend.dto.AddProductReqDto;
import com.example.reprice_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody AddProductReqDto addProductReqDto) {
        return ResponseEntity.ok(productService.addProduct(addProductReqDto));
    }

}

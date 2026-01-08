package com.example.reprice_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String email;
    private String displayName;
    private String provider;
    private String providerUserId;
    private String role;
    private String status;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}

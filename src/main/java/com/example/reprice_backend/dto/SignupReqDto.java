package com.example.reprice_backend.dto;

import com.example.reprice_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupReqDto {
    private String email;
    private String displayName;
    private String provider;
    private String providerUserId;

    public User toEntity() {
        return User.builder()
                .email(email)
                .displayName(displayName)
                .provider(provider)
                .providerUserId(providerUserId)
                .build();
    }
}

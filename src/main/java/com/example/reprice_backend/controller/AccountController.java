package com.example.reprice_backend.controller;

import com.example.reprice_backend.dto.ApiRespDto;
import com.example.reprice_backend.security.model.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    @GetMapping("/principal")
    public ResponseEntity<?> getPrinciple(@AuthenticationPrincipal PrincipalUser principalUser) {
        return ResponseEntity.ok(new ApiRespDto<>("success", "회원 정보 조회완료", principalUser.getUser()));
    }


}

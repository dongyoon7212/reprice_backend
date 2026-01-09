package com.example.reprice_backend.service;

import com.example.reprice_backend.dto.ApiRespDto;
import com.example.reprice_backend.dto.SignupReqDto;
import com.example.reprice_backend.entity.User;
import com.example.reprice_backend.repository.UserRepository;
import com.example.reprice_backend.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @Transactional(rollbackFor = Exception.class)
    public ApiRespDto<?> signup(SignupReqDto signupReqDto) {
        Optional<User> foundUserByDisplayName = userRepository.getUserByDisplayName(signupReqDto.getDisplayName());

        if (foundUserByDisplayName.isPresent()) {
            return new ApiRespDto<>("failed", "이미 존재하는 닉네임입니다.", null);
        }

        Optional<User> optionalUser = userRepository.addUser(signupReqDto.toEntity());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("회원 추가에 문제가 발생했습니다.");
        }

        User user = optionalUser.get();

        String accessToken = jwtUtils.generateToken(user.getUserId().toString());
        return new ApiRespDto<>("success", "가입이 완료되었습니다.", accessToken);
    }
}

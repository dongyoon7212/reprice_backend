package com.example.reprice_backend.repository;

import com.example.reprice_backend.entity.User;
import com.example.reprice_backend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserMapper userMapper;

    public Optional<User> getUserByUserId(Integer userId) {
        return userMapper.getUserByUserId(userId);
    }

    public Optional<User> getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public Optional<User> getUserByDisplayName(String displayName) {
        return userMapper.getUserByDisplayName(displayName);
    }

    public Optional<User> getUserByProviderAndProviderUserId(String provider, String providerUserId) {
        return userMapper.getUserByProviderAndProviderUserId(provider, providerUserId);
    }

    public Optional<User> addUser(User user) {
        try {
            int result = userMapper.addUser(user);
            if (result != 1) {
                throw new RuntimeException("회원정보 추가에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }
}

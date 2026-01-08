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

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }
}

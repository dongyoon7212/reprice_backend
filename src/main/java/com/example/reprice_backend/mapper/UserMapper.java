package com.example.reprice_backend.mapper;

import com.example.reprice_backend.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> getUserByUserId(Integer userId);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByDisplayName(String displayName);
    Optional<User> getUserByProviderAndProviderUserId(String provider, String providerUserId);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(Integer userId);
}

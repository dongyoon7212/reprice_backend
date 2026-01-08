package com.example.reprice_backend.security.model;

import com.example.reprice_backend.entity.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalUser extends DefaultOAuth2User {
    private final User user;

    public PrincipalUser(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes, String nameAttributeKey, User user) {
        super(authorities, attributes, nameAttributeKey);
        this.user = user;
    }

    public static PrincipalUser fromOAuth2(DefaultOAuth2User oAuth2User,
                                           String nameAttributeKey,
                                           User user) {
        return new PrincipalUser(
                oAuth2User.getAuthorities(),
                oAuth2User.getAttributes(),
                nameAttributeKey,
                user
        );
    }

    public static PrincipalUser fromJwt(User user,
                                        Collection<? extends GrantedAuthority> authorities) {
        return new PrincipalUser(
                authorities,
                Map.of("userId", user.getUserId()), // 최소만 넣거나 Map.of()도 가능
                "userId",
                user
        );
    }

    public static PrincipalUser getAuthenticatedPrincipalUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return principalUser;
    }
}

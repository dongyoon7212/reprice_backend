package com.example.reprice_backend.security.filter;

import com.example.reprice_backend.entity.User;
import com.example.reprice_backend.repository.UserRepository;
import com.example.reprice_backend.security.jwt.JwtUtils;
import com.example.reprice_backend.security.model.PrincipalUser;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements Filter {
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        List<String> methods = List.of("GET", "POST", "PUT", "DELETE");
        if (!methods.contains(request.getMethod())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String authorization = request.getHeader("Authorization");

        if (jwtUtils.isBearerToken(authorization)) {
            String accessToken = jwtUtils.removeBearerToken(authorization);

            try {
                Claims claims = jwtUtils.getClaims(accessToken);
                String id = claims.getId();
                Integer userId = Integer.parseInt(id);
                Optional<User> foundUser = userRepository.getUserByUserId(userId);
                foundUser.ifPresentOrElse((user) -> {
                    PrincipalUser principalUser = PrincipalUser.fromJwt(user, List.of(user::getRole));

                    Authentication authentication = new UsernamePasswordAuthenticationToken(principalUser, null, principalUser.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }, () -> {
                    throw new AuthenticationServiceException("Invalid token");
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}

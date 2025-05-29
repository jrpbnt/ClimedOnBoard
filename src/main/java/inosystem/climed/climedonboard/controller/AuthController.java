package inosystem.climed.climedonboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class AuthController{

    @GetMapping("/api/me")
    public Map<String, Object> me(Authentication authentication) {
        return Map.of(
                "username", authentication.getName(),
                "authorities", authentication.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
        );
    }
}
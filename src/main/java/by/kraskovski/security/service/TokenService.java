package by.kraskovski.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    String generate(String username, String password);

    Authentication authenticate(HttpServletRequest request);
}

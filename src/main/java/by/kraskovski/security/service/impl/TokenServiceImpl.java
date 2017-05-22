package by.kraskovski.security.service.impl;

import by.kraskovski.security.service.TokenService;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public class TokenServiceImpl implements TokenService {
    @Override
    public String generate(String username, String password) {
        return null;
    }

    @Override
    public Authentication authenticate(HttpServletRequest request) {
        return null;
    }
}

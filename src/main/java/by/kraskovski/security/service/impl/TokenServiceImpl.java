package by.kraskovski.security.service.impl;

import by.kraskovski.model.User;
import by.kraskovski.security.service.TokenService;
import by.kraskovski.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("secret.key")
    private String secretKey;
    private final UserService userService;

    @Autowired
    public TokenServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String generate(String username, String password) {
        if (username == null || password == null)
            return null;
        User user = userService.findByUsername(username);
        Map<String, Object> tokenData = new HashMap<>();
        if (password.equals(user.getPassword())) {
            tokenData.put("username", user.getUsername());
            tokenData.put("password", user.getPassword());
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setClaims(tokenData);
            return jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey).compact();
        }
        return null;
    }

    @Override
    public Authentication authenticate(HttpServletRequest request) {
        return null;
    }
}

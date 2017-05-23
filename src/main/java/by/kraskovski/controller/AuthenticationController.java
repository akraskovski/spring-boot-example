package by.kraskovski.controller;

import by.kraskovski.converter.UserConverter;
import by.kraskovski.dto.TokenDTO;
import by.kraskovski.dto.UserDTO;
import by.kraskovski.model.User;
import by.kraskovski.security.service.TokenService;
import by.kraskovski.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private final TokenService tokenService;
    private final UserService userService;
    private final UserConverter userConverter;

    @Autowired
    public AuthenticationController(final TokenService tokenService, final UserService userService, final UserConverter userConverter) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserDTO requestUser) {
        LOGGER.info("Start authentication user with username: " + requestUser.getUsername());
        if (isNotEmpty(requestUser.getUsername()) && isNotEmpty(requestUser.getPassword())) {
            User user = userService.findByUsername(requestUser.getUsername());
            String token = tokenService.generate(requestUser.getUsername(), requestUser.getPassword());
            if (token != null) {
                LOGGER.info("Authentication successful! user with username: " + requestUser.getUsername());
                user.setPassword(EMPTY);
                return new ResponseEntity<>(new TokenDTO(token, userConverter.userToDTO(user)), HttpStatus.OK);
            }
        }
        LOGGER.error("Authentication failed user with username: " + requestUser.getUsername());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

package by.kraskovski.controller;

import by.kraskovski.DTO.UserDTO;
import by.kraskovski.converter.UserConverter;
import by.kraskovski.model.User;
import by.kraskovski.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        LOGGER.info("start creating user: ", userDTO);
        User user = userService.create(UserConverter.DTOtoUser(userDTO));
        return new ResponseEntity<>(UserConverter.userToDTO(user), HttpStatus.CREATED);
    }

    @RequestMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.findAll();
            LOGGER.info("Found {} users", users.size());
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (DataAccessException e) {
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

package by.kraskovski.converter;

import by.kraskovski.DTO.UserDTO;
import by.kraskovski.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static User DTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setAge(userDTO.getAge());
        return user;
    }

    public static UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setAge(user.getAge());
        return userDTO;
    }
}

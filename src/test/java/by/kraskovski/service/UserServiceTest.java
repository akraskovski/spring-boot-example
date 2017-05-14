package by.kraskovski.service;

import by.kraskovski.model.User;
import by.kraskovski.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void find() {
        User user = userRepository.findOne("5915a1973e53020b487a30d2");
        assertEquals("Alice", user.getFirstname());
        assertEquals("Smith", user.getLastname());
    }

}
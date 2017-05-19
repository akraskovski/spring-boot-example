package by.kraskovski.service;

import by.kraskovski.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void before() {
        userService.deleteAll();
        for (int index = 0; index < 500; index++)
            userService.create(new User("firstname" + index, "lastname" + index, index));
    }

    @After
    public void after() {
        userService.deleteAll();
    }

    @Test(timeout = 500)
    public void findAll() {
        assertNotNull(userService.findAll());
    }
}
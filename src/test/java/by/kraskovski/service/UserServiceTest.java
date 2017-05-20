package by.kraskovski.service;

import by.kraskovski.model.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @After
    public void after() {
        userService.deleteAll();
    }

    @Test(timeout = 500)
    public void findAll() {
        assertNotNull(userService.findAll());
    }

    @Test
    public void findOne() {
        String id = userService.create(new User("Alexandr", "Pesnyak", 15)).getId();
        assertNotNull(userService.find(id));
    }

    @Test
    public void update() {
        User user = userService.create(new User("Alexandr", "Pesnyak", 12));
        user.setAge(3);
        userService.update(user.getId(), user);
        assertEquals(userService.find(user.getId()), user);
    }

    @Test
    public void delete() {
        String id = userService.create(new User("Alexandr", "Pesnyak", 15)).getId();
        userService.delete(id);
        assertEquals(userService.find(id), null);
    }
}
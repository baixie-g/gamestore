package com.ccxg.test;

import com.ccxg.bean.User;
import com.ccxg.service.UserService;
import com.ccxg.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author ccxg
 * @create 2024-10-21 18:50
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void addUser() {
        userService.addUser(new User(null,"舒胡贤2","kj","1234@qq.com","kjk"));
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(3);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void queryUserById() {
    }

    @Test
    public void queryUsers() {
    }

    @Test
    public void page() {
    }
}

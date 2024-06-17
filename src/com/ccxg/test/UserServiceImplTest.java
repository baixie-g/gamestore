package com.ccxg.test;

import com.ccxg.bean.User;
import com.ccxg.service.UserService;
import com.ccxg.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author ccxg
 * @create 2024-08-21 15:38
 */
public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"admin","admin","225@qq.com","大河湾"
                ));
    }

    @Test
    public void login() {
        if(userService.login(new User(null,"admin123","admin",null,"大河湾"))==null) {
            System.out.println("登录失败");
        } else {

        System.out.println("登陆成功");
        }
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("admin35135")==false) {
            System.out.println("用户名可用");
        } else {
        System.out.println("用户名已存在");

        }
    }
}

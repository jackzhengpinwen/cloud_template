package com.zpw.sprintboot.sprintboottemplate;

import com.zpw.sprintboot.sprintboottemplate.system.entity.Role;
import com.zpw.sprintboot.sprintboottemplate.system.entity.User;
import com.zpw.sprintboot.sprintboottemplate.system.service.RoleService;
import com.zpw.sprintboot.sprintboottemplate.system.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Test
    void getById() {
        User user = userService.findById(12L);
        System.out.println(user);
    }

    @Test
    void save() {
        User user = new User();
        user.setUsername("李七");
        user.setGender(0);
        user.setPassword("1234567");
        user.setIdCard("110110200001010001");
        user.setEmail("0000@163.com");
        user.setPhone("13333333333");
        user.setBirthday(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setIsDeleted(0);
        Role role = roleService.findById(1L);
        user.setRoles(Collections.singletonList(role));
        userService.save(user);
    }

    @Test
    void login() {
        User user = new User();
        user.setUsername("李四");
        user.setPassword("1234567");
        userService.login(user);
    }
}

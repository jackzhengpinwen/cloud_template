package com.zpw.sprintboot.sprintboottemplate;

import com.zpw.sprintboot.sprintboottemplate.system.dao.UserDao;
import com.zpw.sprintboot.sprintboottemplate.system.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    void save() {
        User user = new User();
        user.setUsername("郑频艺");
        user.setGender(0);
        user.setPassword("123456");
        user.setIdCard("110110200001010001");
        user.setEmail("0000@163.com");
        user.setPhone("13333333333");
        user.setBirthday(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        User saveUser = userDao.save(user);
        System.out.println(saveUser);
    }

    @Test
    void getById() {
        Optional<User> user = userDao.findById(2L);
        user.ifPresent(System.out::println);
    }

    @Test
    void updateById() {
        Optional<User> user = userDao.findById(1L);
        user.ifPresent(u -> {
            u.setUsername("李四");
            User user0 = userDao.save(u);
            System.out.println(user0);
        });
    }

    @Test
    void deleteById() {
        userDao.deleteById(1L);
        Assertions.assertTrue(userDao.findById(1L).isEmpty());
    }

    @Test
//    @Transactional
    void logicDeleteById() {
        userDao.logicDeleteById(2);
        Assertions.assertTrue(userDao.findById(2L).isEmpty());
    }
}

package com.adrien.service;


import com.adrien.entity.User;
import com.adrien.mapper.UserDAO;
import com.adrien.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void selectUserServiceTests() {

        User user = userService.selectUserById("1000");
        System.out.println("=================123===============");
        System.out.println(user);


    }


}

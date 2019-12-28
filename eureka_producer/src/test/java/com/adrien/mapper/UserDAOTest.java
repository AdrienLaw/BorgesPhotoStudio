package com.adrien.mapper;


import com.adrien.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void selectUserDAO() {
        System.out.println("=================123===============");
        User user = userDAO.selectUserInfo("1000");
        System.out.println("=================123===============");
        System.out.println(user);


    }


}

package com.adrien.controller;

import com.adrien.entity.User;
import com.adrien.service.IUserervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {

    @Autowired
    private IUserervice userervice;

    @GetMapping("/user")
    public User selectByUserId(@RequestParam String id){
        User userById = userervice.selectUserById(id);
        System.out.println("===========UserService=============");
        return userById;
    }


}

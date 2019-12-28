package com.adrien.service;

import com.adrien.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserervice {
    User selectUserById(String id);
}

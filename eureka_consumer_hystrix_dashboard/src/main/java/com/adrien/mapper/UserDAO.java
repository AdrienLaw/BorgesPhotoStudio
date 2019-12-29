package com.adrien.mapper;

import com.adrien.entity.User;

public interface UserDAO {
    User selectUserInfo(String id);
}

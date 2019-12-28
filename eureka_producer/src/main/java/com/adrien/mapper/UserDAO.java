package com.adrien.mapper;

import com.adrien.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDAO {
    @Select("select * from s_user where id = #{id}")
    User selectUserInfo(String id);
}

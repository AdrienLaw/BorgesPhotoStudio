package com.adrien.service.impl;


import com.adrien.entity.User;
import com.adrien.mapper.UserDAO;
import com.adrien.service.IUserervice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("userervice")
public class UserServiceImpl implements IUserervice {

    private Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserDAO userDAO;

    @Override
    public User selectUserById(String id) {
        /*//提前查询缓存--bloom filter
        int hashValue = Math.abs(id.hashCode());
        long index = (long) (hashValue % Math.pow(2, 32));
        //布隆过滤器 拿出缓存数据
        Boolean studio_user = redisTemplate.opsForValue().getBit("studio_user", index);
        if (!studio_user) {
            LOGGER.info("取出缓存",id);

        }*/

        /*2. 读取缓存*/
        Object cacheValue = redisTemplate.opsForValue().get(id);
        if (cacheValue != null) {
            LOGGER.info("缓存中获取");
            return (User) cacheValue;
        } else {
            LOGGER.info("数据库查询");
            User user = userDAO.selectUserInfo(id);
            redisTemplate.opsForValue().set(id,user);
            return user;
        }


        /*if (user != null) {
            redisTemplate.opsForValue().set("studio_user",user.toString());
            System.out.println("======缓存=============");
        }*/

    }
}

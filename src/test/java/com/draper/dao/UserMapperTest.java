package com.draper.dao;

import com.draper.BaseTest;
import com.draper.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        user.setName("draper");
        user.setEmail("draper_hxy@163.com");
        user.setPassword("draper");
        userMapper.insertPhoneUser(user);
    }

    @Test
    public void testSelectUser() {
        User user = userMapper.selectUserByPhone("admin");
        logger.warn("password = {}", user.getPassword());
    }


    @Test
    public void testSelectUserIdByAccount() {
        long id = userMapper.selectUserIdByPhone("admin");
        logger.warn("id = {}", id);
    }

}

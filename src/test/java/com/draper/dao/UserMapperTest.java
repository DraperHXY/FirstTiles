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
        user.setAccount("admin");
        user.setPassword("admin");
        userMapper.insertUser(user);
    }

    @Test
    public void testSelectUser() {
        User user = userMapper.selectUserByAccount("admin");
        logger.warn("password = {}", user.getPassword());
    }


    @Test
    public void testSelectUserIdByAccount() {
        long id = userMapper.selectUserIdByAccount("admin");
        logger.warn("id = {}", id);
    }

}
